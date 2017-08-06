package com.hasith.sample.student.service;

import com.hasith.sample.exception.SampleException;
import com.hasith.sample.student.dao.StudentDao;
import com.hasith.sample.student.dao.StudentDaoImpl;
import com.hasith.sample.student.model.Student;

import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * Created by hasith on 8/5/2017.
 */
public class StudentService {

    private StudentDao studentDao;

    public StudentService() {
        studentDao = new StudentDaoImpl();
    }

    public Student getStudentByIdService(Integer id) {
        return studentDao.getStudentById(id);
    }

    /**
     * can manage logic behind getting students.
     *
     * @return List of students.
     */
    public List<Student> getStudentsService() {
        return studentDao.getStudents();
    }

    /**
     * can mange student insertion logic here.
     *
     * @param student student to insert.
     */
    public void insertStudentService(Student student) {
        if (student == null) {
            throw new SampleException("Student document cannot be null");
        }
        studentDao.insertStudent(student);
    }

    /**
     * can manage update student logic.
     *
     * @param student student to update.
     * @return updated student.
     */
    public Student updateStudentService(Student student) {
        if (student == null) {
            throw new SampleException("Student document cannot be null");
        }
        return studentDao.updateStudent(student);
    }

    /**
     * can manage logic behind the delete student action.
     *
     * @param id student id
     */
    public void deleteStudentService(@QueryParam("id") Integer id) {
        if (id == null) {
            throw new SampleException("Student is not provided");
        }
        studentDao.deleteStudent(id);
    }
}
