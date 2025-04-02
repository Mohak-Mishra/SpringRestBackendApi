package com.mishra.mohak.springrest02.service;

import com.mishra.mohak.springrest02.bean.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IStudentService {
    Integer saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Integer sid);
    Student getOneStudent(Integer sid);
    List<Student> getAllStudents();
}
