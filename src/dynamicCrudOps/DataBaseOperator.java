package dynamicCrudOps;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class DataBaseOperator {
    public static void main(String[] args) {
        System.out.println("Enter the query");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String query = reader.readLine();
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/m10_rj";
            FileInputStream stream = new FileInputStream("D:\\Eclipse JEE\\JDBC\\src\\jdbcDemo\\mydbinfo.properties");
            Properties properties = new Properties();
            properties.load(stream);

            Connection con = DriverManager.getConnection(url, properties);
            Statement statement = con.createStatement();

            boolean execute = statement.execute(query);
            if (execute){
                ResultSet set = statement.getResultSet();

                while (set.next()){
                    System.out.println(set.getInt(1));
                    System.out.println(set.getString(2));
                    System.out.println(set.getString(3));
                    System.out.println(set.getString(4));
                    System.out.println("--------------------------");
                }
            }

            System.out.println("Table Updated Successfully");

            con.close();

        } catch (ClassNotFoundException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
