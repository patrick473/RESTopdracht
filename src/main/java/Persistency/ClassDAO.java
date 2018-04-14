package Persistency;

import Domain.ClassObject;
import Domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public ArrayList<ClassObject> getAllClasses(){
        return getClasses("select * from class");
    }

    public ClassObject getClass(int id){
        return getClasses("select * from class where id = "+id).get(0);
    }

    public boolean addClass(ClassObject classobject){
        try (Connection con = super.getlocalConnection()) {

            String query = "INSERT INTO class (name, id)" +
                    " VALUES(?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,classobject.getName());
            stmt.setInt(2,classobject.getId());


            if(stmt.executeUpdate() == 1) {

                return true;
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }

        return false;
    }

    public boolean updateClass(ClassObject classobject){
        int editted =0;
        try (Connection con = super.getlocalConnection()) {

            String query = "UPDATE class " +
                    "set name = ?, " +

                    "WHERE id = ?" ;
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,classobject.getName());
            stmt.setInt(2,classobject.getId());



            System.out.println(query);
            editted = stmt.executeUpdate();
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return editted==1;
    }
    public boolean deleteClass(int id){
        int deleted =0;

        try (Connection con = super.getlocalConnection()) {

            PreparedStatement stmt = con.prepareStatement("delete from class where id = ?");
            stmt.setInt(1,id);
            deleted = stmt.executeUpdate();
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return deleted==1;
    }

}
