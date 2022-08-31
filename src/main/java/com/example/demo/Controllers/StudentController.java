package com.example.demo.Controllers;

import com.example.demo.Databases.Students;
import com.example.demo.Interfaces.studentsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private studentsInterface studentsInterface;

    @GetMapping("/showAll")
    public List<Students> showAll(){
        var users = (List<Students>) studentsInterface.findAll();
        return users;
    }
}
