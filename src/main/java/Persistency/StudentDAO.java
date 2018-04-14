package Persistency;

import Domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

        public ArrayList<Student> getAllStudents(){
            return getStudents("select * from student");
        }
        public ArrayList<Student> getStudentByClass(int classid){
            return getStudents("select * from student where classid = "+classid);
        }
        public Student getStudent(int id){
            return getStudents("select * from student where studentid = "+id).get(0);
        }

        public boolean addStudent(Student student){
            try (Connection con = super.getlocalConnection()) {

                String query = "INSERT INTO student (name, classid)" +
                        " VALUES(?, ?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1,student.getName());
                stmt.setInt(2,student.getClassid());


                if(stmt.executeUpdate() == 1) {

                    return true;
                }

            } catch (Exception sqle) {
                sqle.printStackTrace();
            }

            return false;
        }

        public boolean updateStudent(Student student){
            int editted =0;
            try (Connection con = super.getlocalConnection()) {

                String query = "UPDATE student " +
                        "set name = ?, " +
                        " classid = ? " +
                        "WHERE studentid = ?" ;
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1,student.getName());
                stmt.setInt(2,student.getClassid());

                stmt.setInt(3,student.getStudentid());

                System.out.println(query);
                editted = stmt.executeUpdate();
            }
            catch (Exception sqle) {
                sqle.printStackTrace();
            }
            return editted==1;
        }
        public boolean deleteStudent(int id){
            int deleted =0;

            try (Connection con = super.getlocalConnection()) {

                PreparedStatement stmt = con.prepareStatement("delete from student where product_id = ?");
                stmt.setInt(1,id);
                deleted = stmt.executeUpdate();
            } catch (Exception sqle) {
                sqle.printStackTrace();
            }
            return deleted==1;
        }


}
