package Persistency;

import Domain.ClassObject;
import Domain.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClassDAO extends BaseDAO{
    private ArrayList<ClassObject> getClasses(String query) {
        ArrayList<ClassObject> results = new ArrayList<ClassObject>();
        try (Connection con = super.getlocalConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){

                String name = rs.getString("name");
                int id = rs.getInt("id");


                ClassObject classObject = new ClassObject(name,id);

                results.add(classObject);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return results;
    }

    private ArrayList<ClassObject> getAllStudents(){
        return getClasses("select * from class");
    }

    private ClassObject getClass(int id){
        return getClasses("select * from class where id = "+id).get(0);
    }
}
