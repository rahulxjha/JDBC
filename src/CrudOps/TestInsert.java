package CrudOps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/m10_rj";
            String user = "root";
            String pass = "rahul";

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();

            String query = "INSERT INTO student VALUES" + "(131, 'Abhimanyu', 'abhi_man@gmail.com', 'MEAN')";
            boolean execute = stmt.execute(query);

            System.out.println(execute);



        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
