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

Certainly! Here's an example section you can add to the README file to provide instructions for running the program:

## Running the Application

To run the `OracleScanTest` program, follow these steps:

1. Ensure that you have the following prerequisites installed and configured:
   - Java Development Kit (JDK): [Download and install JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   - Oracle JDBC driver: [Download the Oracle JDBC driver](https://www.oracle.com/database/technologies/jdbc-driver-ucp-downloads.html) and include it in the project's classpath.

2. Compile the Java file using the Java compiler. Open a command prompt or terminal and navigate to the directory where the `OracleScanTest.java` file is located. Run the following command:
   ```
   javac OracleScanTest.java
   ```

3. Once the compilation is successful, you can run the program by executing the compiled Java class. Use the following command:
   ```
   java OracleScanTest
   ```

4. The program will attempt to establish a connection to the Oracle database using the provided configuration parameters. It will perform a simple query and display the result if the connection is successful.

5. The program is designed to handle connection failures gracefully by retrying based on the specified retry parameters. It will continue iterating until the specified number of iterations is reached or the timeout is reached.

Note: Make sure you have the Oracle JDBC driver included in your classpath during compilation and execution. If you encounter any issues, double-check that the driver JAR file is correctly referenced.

## License

This project is licensed under the [MIT License](LICENSE).

Feel free to customize the instructions based on your specific environment and requirements.
