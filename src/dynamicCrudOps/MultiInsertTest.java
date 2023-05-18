package dynamicCrudOps;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MultiInsertTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/m10_rj";
            FileInputStream stream = new FileInputStream("D:\\Eclipse JEE\\JDBC\\src\\jdbcDemo\\mydbinfo.properties");
            Properties prop = new Properties();
            prop.load(stream);

            Connection con = DriverManager.getConnection(url, prop);

            String query = "INSERT INTO student VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, 80);
            ps.setString(2,"Anamika");
            ps.setString(3,"anm@gmail.com");
            ps.setString(4,"Java");
            ps.addBatch();

            ps.setInt(1, 90);
            ps.setString(2,"Deepika");
            ps.setString(3,"deepika@gmail.com");
            ps.setString(4,"Python");
            ps.addBatch();

            ps.executeBatch();

            System.out.println("data inserted");

            con.close();

        } catch (ClassNotFoundException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
