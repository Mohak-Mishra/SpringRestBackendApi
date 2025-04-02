package com.mishra.mohak.springrest02.restController;

import com.mishra.mohak.springrest02.bean.Student;
import com.mishra.mohak.springrest02.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/student")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @Operation(summary = "Save the Student Object")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201", description = "CREATED A RESOURCE AT PROVIDER",
                            content = {
                                    @Content(mediaType = "text/plain")
                            }
                    ),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST",
                            content =
                                    {
                                            @Content(mediaType ="application/json")
                                    }
                    )
            }
    )
    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody @Valid Student student) {
       int i= studentService.saveStudent(student);
        return ResponseEntity.ok("Student got saved with id " + i);
    }
    @Operation(summary = "Delete a Student by its id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200", description = "SUCCESS",
                            content = {
                                    @Content(mediaType = "plain/text")
                            }
                    ),
                    @ApiResponse(responseCode = "404", description = "Student not found",
                            content =
                                    {
                                            @Content(mediaType ="application/json", schema = @Schema(implementation =ErrorResponse.class))
                                    }
                    )
            }
    )

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Deleted with id " + id);
    }
    @Operation(summary = "Update Student object")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200", description = "SUCCESS",
                            content = {
                                    @Content(mediaType = "plain/text")
                            }
                    ),
                    @ApiResponse(responseCode = "404", description = "Student not found",
                            content =
                                    {
                                            @Content(mediaType ="application/json", schema = @Schema(implementation =ErrorResponse.class))
                                    }
                    )
            }
    )
    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody @Valid Student student) {
        studentService.updateStudent(student);
        return new ResponseEntity<>("Student got updated with id"+ student.getSid(), HttpStatus.OK);
    }
    @Operation(summary = "Find a Student by its id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200", description = "SUCCESS",
                            content = {
                                    @Content(mediaType = "application/json" , schema = @Schema(implementation =Student.class))
                            }
                    ),
                    @ApiResponse(responseCode = "404", description = "Student not found",
                            content =
                                    {
                                            @Content(mediaType ="application/json", schema = @Schema(implementation = ErrorResponse.class))
                                    }
                    )
            }
    )
    @GetMapping("find/{id}")
    public ResponseEntity<Student> findStudent(@PathVariable Integer id) {
        return new ResponseEntity<>(studentService.getOneStudent(id), HttpStatus.OK);
    }
    @Operation(summary = "Find all Student")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200", description = "SUCCESS",
                            content = {
                                    @Content(mediaType = "application/json" ,
                                            array =
                                            @ArraySchema(
                                                    schema = @Schema(implementation = Student.class)
                                            )
                                    )

                            }
                    )
            }
    )
    @GetMapping("findAllStudents")
    public ResponseEntity<List<Student>> findAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

}
