package studentDataMiniApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StudentDAO {
    private static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student_details";
            FileInputStream stream = new FileInputStream("D:\\Eclipse JEE\\JDBC\\src\\jdbcDemo\\mydbinfo.properties");
            Properties prop = new Properties();
            prop.load(stream);
            connection = DriverManager.getConnection(url, prop);

        } catch (ClassNotFoundException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public String saveStudent(Student student){
        Connection connection = getConnection();
        String query = "INSERT INTO student VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,student.getId());
            ps.setString(2,student.getName());
            ps.setString(3,student.getFathersName());
            ps.setString(4,student.getAddress());
            ps.setString(5,student.getPhoneNo());

            int res = ps.executeUpdate();

            connection.close();

            return res + " row of data inserted";

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String updateStudent(Student student){
        Connection connection = getConnection();
        String query = "UPDATE student SET name=?, fathers_name=?, address=?, phone_num=? WHERE id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(5,student.getId());
            ps.setString(1,student.getName());
            ps.setString(2,student.getFathersName());
            ps.setString(3,student.getAddress());
            ps.setString(4,student.getPhoneNo());

            int res = ps.executeUpdate();

            connection.close();

            return res + " row of data updated successfully";

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student getStudentById(int id)  {
        Connection connection = getConnection();
        String query = "SELECT * FROM student WHERE id=?";
        Student student = null;

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet set = ps.executeQuery();

            while (set.next()) {
                student = new Student();
                student.setId(set.getInt(1));
                student.setName(set.getString(2));
                student.setFathersName(set.getString(3));
                student.setAddress(set.getString(4));
                student.setPhoneNo(set.getString(5));
            }

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }

    public String deleteStudentById(int id){
        Connection connection = getConnection();
        String query = "DELETE FROM student WHERE id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,id);

            int res = ps.executeUpdate();

            connection.close();

            return res + " row of data deleted successfully";

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> getStudentList(){
        Connection connection = getConnection();
        String query = "SELECT * FROM student";
        List<Student> list = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(query);

            if(set.isBeforeFirst()) {
                list = new ArrayList<>();
            }

            while (set.next()){
                Student student = new Student();
                student.setId(set.getInt(1));
                student.setName(set.getString(2));
                student.setFathersName(set.getString(3));
                student.setAddress(set.getString(4));
                student.setPhoneNo(set.getString(5));
                list.add(student);
            }

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}