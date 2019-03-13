import DataBase.DAO.StudentDAO;
import data.Student;

public class Main {

    public static void main(String... args){
        Student student = new StudentDAO().getStudent(2);

        System.out.println(student.getFirstName()+" "+ student.getLastName());



    }
}
