package com.mishra.mohak.springrest02.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "studentTable")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer sid;
    @NotBlank(message = "name can't be blank")
    private String sname;
    @NotBlank(message = "dob can't be blank"
    )
    private Date dob;
    @NotBlank(message = "gender can't be blank")
    private String sgender;
    @NotBlank(message = "address can't be blank")
    private String saddress;
    private String scourse;

}
