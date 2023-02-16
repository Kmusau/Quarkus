package org.acme.controller;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.acme.entity.Student;
import org.acme.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/students")
public class DataResourceController {

    @Inject
    StudentService studentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents() {
        var students = studentService.allStudents();
        return Response.ok(students).build();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student addStudent(Student student) {
        return studentService.addStudent(student);
    }

    @PUT
    @Path("/update/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student updateStudent(@PathParam("studentId") int studentId, Student student) {
        return studentService.updateStudent(studentId, student);
    }

    @DELETE
    @Path("/delete/{studentId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteStudent(@PathParam("studentId") int studentId) {
        studentService.deleteStudent(studentId);
        return "Deleted successfully";
    }
}
