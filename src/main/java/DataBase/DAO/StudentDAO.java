package DataBase.DAO;

import data.Student;

import java.sql.*;
import java.util.List;


public class StudentDAO {

    public Student getStudent(int id) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "s1H2a3Y4");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM students WHERE id = " + String.valueOf(id);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            while (resultSet.getInt("id") != id)
                resultSet.next();

            Student student = new Student();
            student.setLastName(resultSet.getString("lastName"));
            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("firstName"));

            return student;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addStudent(Student student){
        return false;

    }

    public List<Student> getStudents(){
        return null;
    }

    public void updateStudent(Student student){

    }
    public void deleteStudent(Student student){

    }
}
