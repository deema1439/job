package com.example.job.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPost {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "title Should not be empty")
    @Size(min =5,message = "title length should be more than 4")
    @Column(columnDefinition = "varchar(50) not null")
    private String title;




    @NotEmpty(message = "description can not be empty")
    @Column(columnDefinition = "varchar(200) not null")
    private String description;

    @NotEmpty(message = "location should not be Empty")
    @Column(columnDefinition = "varchar(120) not null")
    private String location;

    @NotNull(message = "salary can not be Empty")
    @Positive(message = "salary should be Positive")
    @Column(columnDefinition = "int not null")
    private Integer salary;

    @NotNull(message = "postingDate should not be empty")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date not null")//نوع الديت في الداتا بيز
    private LocalDate postingDate;



















}
