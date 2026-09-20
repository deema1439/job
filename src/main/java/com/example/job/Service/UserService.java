package com.example.job.Service;

import com.example.job.Model.User;
import com.example.job.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User>getUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
     userRepository.save(user);
    }

    public boolean UpdateUser(Integer id,User user){
        User oldUser=userRepository.findUsersById(id);
        if(oldUser==null){
            return false;
        }
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setName(user.getName());
        oldUser.setPassword(user.getPassword());
        oldUser.setRole(user.getRole());
        userRepository.save(oldUser);
        return true;
    }

    public boolean deleteUser(Integer id){
        User deleteUser=userRepository.findUsersById(id);
        if(deleteUser==null){
            return false;
        }
        userRepository.delete(deleteUser);
        return true;

    }




















}
