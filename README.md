# OracleScanTest

This project demonstrates how to connect to an Oracle database using SCAN (Single Client Access Name) address and perform a simple query. It utilizes the Oracle JDBC driver and the OracleDataSource class to establish a connection.

## Prerequisites

- Java Development Kit (JDK)
- Oracle JDBC driver (Download from the Oracle website and include it in the project's classpath)

## Configuration

In the `OracleScanTest` class, modify the following variables according to your Oracle database configuration:

- `scanAddress`: The SCAN address of your Oracle database.
- `scanPort`: The port number used for the connection.
- `service`: The service name or SID of the Oracle database.
- `username`: The username for authentication.
- `password`: The password for authentication.
- `iterations`: The number of iterations for testing.
- `retryCount`: The number of retry attempts.
- `retryInterval`: The interval (in milliseconds) between retry attempts.
- `timeout`: The timeout (in milliseconds) for each attempt.

## Running the Application

1. Ensure that you have the necessary prerequisites installed and configured.
2. Compile the Java file using the Java compiler (`javac`).
3. Run the compiled Java class (`java OracleScanTest`) to execute the program.
4. The program will attempt to establish a connection to the Oracle database and perform a query. It will display the query result if successful.
5. The program will retry the connection in case of failure, based on the specified retry parameters.
6. The program will continue iterating until the specified number of iterations is reached or the timeout is reached.

Note: Make sure you have the Oracle JDBC driver included in your classpath during compilation and execution.

## License

This project is licensed under the [MIT License](LICENSE).
