package com.example.demo.Controllers;

import java.util.*;

import com.example.demo.Databases.Departments;
import com.example.demo.Interfaces.departmentsInterface;
import com.example.demo.DTO.*;
import com.example.demo.Mappers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private departmentsInterface deptInterface;

    @GetMapping("/showDept")
    public List<Departments> showDept(){
        var users = (List <Departments>) deptInterface.findAll();
        return users;
    }
}
