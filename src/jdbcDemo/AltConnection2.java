package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AltConnection2 {
    /* In this file we are establishing the connection by using the overloaded method of getConnection(url, properties),
       which accepts two args that is URL and object of Properties Class. We use method setProperty(key, value) of
       Properties class to provide username and password.
    */

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/m10_rj";
            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "rahul");

            Connection con = DriverManager.getConnection(url, properties);

            System.out.println("Connected");

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
