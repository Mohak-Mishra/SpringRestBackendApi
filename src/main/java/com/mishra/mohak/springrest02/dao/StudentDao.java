package com.mishra.mohak.springrest02.dao;

import com.mishra.mohak.springrest02.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {
    public Student findBySname(String sname);
}
