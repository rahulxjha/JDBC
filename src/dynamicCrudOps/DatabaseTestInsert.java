package dynamicCrudOps;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DatabaseTestInsert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/m10_rj";
            FileInputStream stream = new FileInputStream("D:\\Eclipse JEE\\JDBC\\src\\jdbcDemo\\mydbinfo.properties");
            Properties properties = new Properties();
            properties.load(stream);

            Connection con = DriverManager.getConnection(url, properties);

            String query = "INSERT INTO student VALUES(?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(query);

            statement.setInt(1, 33);
            statement.setString(2, "SitaRam");
            statement.setString(3, "sr@gmail.com");
            statement.setString(4, "Python");

            int res = statement.executeUpdate();

            System.out.println(res+" row of data insertion is successful");

            con.close();

        } catch (ClassNotFoundException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
