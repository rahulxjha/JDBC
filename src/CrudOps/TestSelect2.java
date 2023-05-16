package CrudOps;

import java.sql.*;

public class TestSelect2 {
    /* In this file, to execute SELECT query we will use another method from Statement(I) that is executeQuery(). */

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/m10_rj";
            String user = "root";
            String pass = "rahul";

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();

            String query = "SELECT * FROM student";
            ResultSet set = stmt.executeQuery(query);

            while (set.next()){
                System.out.println(set.getInt(1));
                System.out.println(set.getString(2));
                System.out.println(set.getString(3));
                System.out.println(set.getString(4));
                System.out.println("--------------------------");
            }

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
