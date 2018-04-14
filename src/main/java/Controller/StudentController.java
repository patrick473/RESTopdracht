package Controller;

import Domain.Student;
import Persistency.StudentDAO;

import java.util.ArrayList;

public class StudentController {

    StudentDAO sdao = new StudentDAO();

    public ArrayList<Student> getAllStudents(){
        return sdao.getAllStudents();
    }
    public Student getStudent(int id){
        return sdao.getStudent(id);
    }
    public ArrayList<Student> getStudentByClass(int classid) {
        return sdao.getStudentByClass(classid);
    }
    public Boolean addStudent(String name,int classid) {
        Student student = new Student(name,0,classid);

        return sdao.addStudent(student);
    }
    public Boolean updateStudent(String name,int classid,int studentid) {
        Student student = new Student(name,studentid,classid);

        return sdao.updateStudent(student);
    }
    public Boolean deleteStudent(int id) {

        return sdao.deleteStudent(id);
    }
}
