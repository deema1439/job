package com.example.job.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.DialectOverride;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    @NotEmpty(message = "Name Should Not Be Empty")
    @Size(min = 5,message = "name of the length should be more than 4")
    @Pattern(regexp = "^[a-zA-Z]+$",message = "name must contain only characters")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @Email(message = "its invalid email")
    @NotEmpty(message = "email Should Not Be Empty")
    @Column(columnDefinition = "varchar(60) not null unique")
   private String email;


    @NotEmpty(message = "password should not be Empty")
    @Column(columnDefinition = "varchar(160) not null")
    private String password;


    @NotNull(message = "age should not be Empty ")
    @Min(value = 22,message = "age should be more than 21.")
    @Check(constraints = "age > 21")
    @Column(columnDefinition = "int not null ")
    private Integer age;


    @NotEmpty(message = "role Should Not Be Empty")
    @Check(constraints = "role in ('JOB_SEEKER' , 'EMPLOYEE')")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYEE)$",message = "role Should be only JOB_SEEKER or EMPLOYEE ")
    @Column(columnDefinition = "varchar(40) not null ")
    private String role;













}
