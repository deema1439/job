package com.example.job.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

 @NotNull(message = "user id should not be Empty")
 @Column(columnDefinition = "int not null")
 private Integer userId;

 @NotNull(message = "job post id can not be empty")
 @Column(columnDefinition = "int not null")
 private Integer jobPostId;











}
