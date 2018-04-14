package rest;

import Controller.StudentController;
import Domain.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("/student")
public class StudentService {

    StudentController sc = new StudentController();
    @Path("/all")
    @GET
    public ArrayList<Student> getstudents(){

        return sc.getAllStudents();
    }
    @Path("/{id}")
    @GET
    public Student getStudent(@PathParam("id")int id){
        return sc.getStudent(id);
    }

    @Path("/class/{id}")
    @GET
    public ArrayList<Student> getStudentByClass(@PathParam("id")int id){
        return sc.getStudentByClass(id);
    }

    @POST
    public Response addStudent(@QueryParam("name")String name,@QueryParam("classid")int classid){
        sc.addStudent(name,classid);
        return Response.status(200).entity("succes").build();
    }

    @PUT
    @Path("/{id}")
    public Response addStudent(@QueryParam("name")String name,@QueryParam("classid")int classid,@PathParam("id")int id){
        sc.updateStudent(name,classid,id);
        return Response.status(200).entity("succes").build();
    }
    @DELETE
    @Path("/{id}")
    public Response addStudent(@PathParam("id")int id){
        sc.deleteStudent(id);
        return Response.status(200).entity("succes").build();
    }
}
