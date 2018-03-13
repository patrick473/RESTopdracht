package Persistency;

import Domain.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO extends BaseDAO {

        private ArrayList<Student> getStudents(String query) {
            ArrayList<Student> results = new ArrayList<Student>();
            try (Connection con = super.getlocalConnection()) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while(rs.next()){

                    String name = rs.getString("name");
                    int id = rs.getInt("studentid");
                    int classid = rs.getInt("classid");

                    Student student = new Student(name,id,classid);

                    results.add(student);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return results;
        }

        private ArrayList<Student> getAllStudents(){
            return getStudents("select * from student");
        }
        private ArrayList<Student> getStudentByClass(int classid){
            return getStudents("select * from student where classid = "+classid);
        }
        private Student getStudent(int id){
            return getStudents("select * from student where studentid = "+id).get(0);
        }

}
