package jdbcDemo;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection2 {
    public static void main(String[] args) {
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            String url = "jdbc:mysql://localhost:3306/m10_rj";
            String user = "root";
            String pass = "rahul";

            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");

            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
