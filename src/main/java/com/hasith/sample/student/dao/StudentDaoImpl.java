package com.hasith.sample.student.dao;

import com.hasith.sample.config.MyBatisDAOUtil;
import com.hasith.sample.student.model.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by hasith on 8/5/2017.
 */
public class StudentDaoImpl implements StudentDao{

    public List<Student> getStudents() {
        SqlSession sqlSession = MyBatisDAOUtil.getSqlSessionFactory().openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.getStudents();
        } finally {
            sqlSession.close();
        }
    }

    public Student getStudentById(Integer studentId) {
        SqlSession sqlSession = MyBatisDAOUtil.getSqlSessionFactory().openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.getStudentById(studentId);
        } finally {
            sqlSession.close();
        }
    }

    public void insertStudent(Student student) {
        SqlSession sqlSession = MyBatisDAOUtil.getSqlSessionFactory().openSession();
        try {
            StudentMapper  studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public Student updateStudent(Student student) {
        SqlSession sqlSession = MyBatisDAOUtil.getSqlSessionFactory().openSession();
        try {
            StudentMapper  studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.updateStudent(student);
            sqlSession.commit();
            return studentMapper.getStudentById(student.getId());
        } finally {
            sqlSession.close();
        }
    }

    public void deleteStudent(Integer studentId) {
        SqlSession sqlSession = MyBatisDAOUtil.getSqlSessionFactory().openSession();
        try {
            StudentMapper  studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.deleteStudent(studentId);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
