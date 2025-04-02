package com.mishra.mohak.springrest02.restController;

import com.mishra.mohak.springrest02.bean.Student;
import com.mishra.mohak.springrest02.service.StudentService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/student")
public class StudentRestController {
    @Autowired
    private StudentService studentService;


    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
       int i= studentService.saveStudent(student);
        return ResponseEntity.ok("Student got saved with id " + i);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Deleted with id " + id);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResponseEntity<>("Student got updated with id"+ student.getSid(), HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Student> findStudent(@PathVariable Integer id) {
        return new ResponseEntity<>(studentService.getOneStudent(id), HttpStatus.OK);
    }

    @GetMapping("findAllStudents")
    public ResponseEntity<List<Student>> findAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

}
