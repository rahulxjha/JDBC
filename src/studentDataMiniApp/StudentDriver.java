package studentDataMiniApp;

import java.util.Arrays;

public class StudentDriver {
    public static void main(String[] args) {
        Student student = new Student(104, "Ram", "Dahsrath", "Ayodhya Vihar", "8456374812");
        StudentDAO dao = new StudentDAO();
        System.out.println(dao.saveStudent(student));
//        System.out.println(dao.getStudentById(104));
//        System.out.println(dao.updateStudent(student));
//        System.out.println(dao.deleteStudentById(104));
        System.out.println(Arrays.toString(dao.getStudentList().toArray(new Student[0])));

    }
}
