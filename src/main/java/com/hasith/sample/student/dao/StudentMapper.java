package com.hasith.sample.student.dao;

import com.hasith.sample.student.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hasith on 8/5/2017.
 */
public interface StudentMapper {

    List<Student> getStudents();

    Student getStudentById(@Param("studentId") Integer studentId);

    void insertStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(@Param("studentId") Integer studentId);
}
