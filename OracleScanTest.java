import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class OracleScanTest {

    public static void main(String[] args) {
        // Set the SCAN address and port
        String scanAddress = "<scanAddress>";
        String scanPort = "<port>";

        // Set the service name or SID
        String service = "<service>";

        // Set the username and password
        String username = "<username>";
        String password = "<password>";

        // Set the number of iterations for testing
        int iterations = 300;

        // Set the retry parameters
        int retryCount = 100;
        long retryInterval = 2000; // milliseconds (2 seconds)
        long timeout = 300000; // milliseconds (1 minute)

        // Create OracleDataSource and set connection properties
        OracleDataSource ods;
        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST="
                    + scanAddress + ")(PORT=" + scanPort + "))(CONNECT_DATA=(SERVICE_NAME=" + service + ")))");
            ods.setUser(username);
            ods.setPassword(password);

            // Loop for the specified number of iterations
            for (int i = 0; i < iterations; i++) {
                System.out.println("Iteration " + (i + 1));
                boolean success = false;
                long startTime = System.currentTimeMillis();

                // Retry loop
                while (!success && System.currentTimeMillis() - startTime < timeout) {
                    try {
                        Connection connection = ods.getConnection();
                        try {
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("SELECT 1 FROM DUAL");
                            if (resultSet.next()) {
                                int result = resultSet.getInt(1);
                                System.out.println("Query result: " + result);
                            }
                            resultSet.close();
                            statement.close();
                            success = true; // Connection and query successful
                        } catch (SQLException e) {
                            System.out.println("Error: " + e.getMessage());
                            // Wait before the next retry
                            Thread.sleep(retryInterval);
                        } finally {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        // Wait before the next retry
                        Thread.sleep(retryInterval);
                    }
                }

                if (!success) {
                    System.out.println("Timeout reached. Exiting the loop.");
                    break; // Exit the loop if timeout is reached
                }

                System.out.println();
                Thread.sleep(3000); // Wait for 5 seconds before the next iteration
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
