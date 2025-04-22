package Database;


import java.sql.Connection;
import java.sql.DriverManager;
// connection to the database
public class DBConnection {

    private static Connection con; // Declaring a static variable to hold the database connection.

    public static Connection createConnection() { 
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database credentials and URL
            String user = "root";
            String password = "nitish@1530k";
            String url = "jdbc:mysql://localhost:3306/student_db";

            // Establish the connection
            con = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}



/* Connection: This is the return type of the method.
It indicates that this method will return an object of type Connection,
which is an interface in the java.sql package used to represent a connection to a database. */


/*
    private static Connection con;

This is the type of the variable. Connection is an interface from the java.sql package that represents a connection to a database.
The variable con will hold a reference to an object that implements this interface. */




