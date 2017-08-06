package com.hasith.sample.student.resources;

import com.hasith.sample.student.model.Student;
import com.hasith.sample.student.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by hasith on 8/5/2017.
 */
@Path("/students")
public class StudentResources {

    private StudentService studentService = new StudentService();

    /**
     * get all student from db
     *
     * @return List of students.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents() {
        return studentService.getStudentsService();
    }


    /**
     * get student related to provided id.
     *
     * @param id student is.
     * @return Student related to given id
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("id") int id) {
        return studentService.getStudentByIdService(id);
    }

    /**
     * insert user
     *
     * @param student insert to database.
     * @return 200 response code if successfully inserted.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertStudent(Student student) {
        studentService.insertStudentService(student);
        return Response.ok().build();
    }

    /**
     * update student student is should not be null.
     *
     * @param student student to update
     * @return 200 response code if successfully updated.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student updateStudent(Student student) {
        return studentService.updateStudentService(student);
    }

    /**
     * delete given student.
     *
     * @param id student id should not be bull.
     * @return 200 response code if successfully deleted.
     */
    @DELETE
    public Response deleteStudent(@QueryParam("id") Integer id) {
        studentService.deleteStudentService(id);
        return Response.ok().build();
    }
}
