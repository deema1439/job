package com.example.job.Controller;

import com.example.job.Api.ApiResponse;
import com.example.job.Model.User;
import com.example.job.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    ResponseEntity<?>getUsers(){
        List<User>getUsers=userService.getUsers();
        return ResponseEntity.status(200).body(getUsers);
    }

    @PostMapping("/add")
    ResponseEntity<?>addUsers(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user has been added"));
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?>UpdateUser(@PathVariable Integer id,@RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean UpdateUser=userService.UpdateUser(id,user);
        if(!UpdateUser){
           return ResponseEntity.status(400).body(new ApiResponse("id not found"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("User has been updated"));
    }


    @DeleteMapping("/delete/{id}")
    ResponseEntity<?>deleteUser(@PathVariable Integer id){
        boolean deleteUser=userService.deleteUser(id);
        if(!deleteUser){
            return ResponseEntity.status(400).body(new ApiResponse("user id Not Found"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("user has been deleted"));
    }




















}
