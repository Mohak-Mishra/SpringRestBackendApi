package com.mishra.mohak.springrest02.service;

import com.mishra.mohak.springrest02.bean.Student;
import com.mishra.mohak.springrest02.dao.StudentDao;
import com.mishra.mohak.springrest02.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private StudentDao studentDao;
    @Override
    public Integer saveStudent(Student student) {
        studentDao.save(student);
        return student.getSid();
    }

    @Override
    public void updateStudent(Student student) {
        if(studentDao.existsById(student.getSid())||student.getSid()!=null){
            studentDao.save(student);
        }
        else{
            throw new StudentNotFoundException("student does't exist"+student.getSid());
        }
    }

    @Override
    public void deleteStudent(Integer sid) {
        if(studentDao.existsById(sid)){
            studentDao.deleteById(sid);
        }
        else{
            throw new StudentNotFoundException("student doesn't exist"+sid);
        }
    }

    @Override
    public Student getOneStudent(Integer sid) {
        return studentDao.findById(sid).orElseThrow(()->new StudentNotFoundException("student not found by "+sid));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }
}
