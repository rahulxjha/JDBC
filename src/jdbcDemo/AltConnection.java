package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AltConnection {
    /* In this file we are establishing the connection by using the overloaded method of getConnection(url),
       which accepts only single arg that is URL. This url contains username and password. Although this is not a
       recommended way due to security purposes, as it is less secure.
    */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/m10_rj?user=root&password=rahul";

            Connection con = DriverManager.getConnection(url);

            System.out.println("Connected");

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
