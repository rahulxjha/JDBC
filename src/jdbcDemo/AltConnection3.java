package jdbcDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AltConnection3 {
    /* In this file we are establishing the connection by using an external file to read user and password, we
    are reading that by FileInputStream. And pass these data as an arg of getConnection(url, properties). It is more
    secure as we are using an external file to store username and password.*/

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/m10_rj";
            FileInputStream stream = new FileInputStream("D:\\Eclipse JEE\\JDBC\\src\\jdbcDemo\\mydbinfo.properties");
            Properties properties = new Properties();
            properties.load(stream);

            Connection con = DriverManager.getConnection(url, properties);
            System.out.println("Connected");

            con.close();

        } catch (ClassNotFoundException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
