package CrudOps;

import java.sql.*;

public class TestSelect {
    /* In this file, to execute query we use one of the method from Statement(I) that is execute().*/
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/m10_rj";
            String user = "root";
            String pass = "rahul";

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM student";

            boolean execute = stmt.execute(query);
            ResultSet set = stmt.getResultSet();

            System.out.println(execute);

            while (set.next()){
                System.out.println(set.getInt(1));
                System.out.println(set.getString(2));
                System.out.println(set.getString(3));
                System.out.println(set.getString(4));
                System.out.println("------------------------------");
            }

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
