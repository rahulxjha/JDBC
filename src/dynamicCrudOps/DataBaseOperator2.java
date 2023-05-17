package dynamicCrudOps;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class DataBaseOperator2 {
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

            boolean res = statement.execute(query);

            if (res) {
                ResultSet set = statement.getResultSet();
                ResultSetMetaData data = set.getMetaData();
                int count = data.getColumnCount();

                while (set.next()){
                    for (int i = 1; i<=count; i++){
                        System.out.println(set.getObject(i));
                    }
                }
            }

            else System.out.println("Table Updated Successfully");

        } catch (ClassNotFoundException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
