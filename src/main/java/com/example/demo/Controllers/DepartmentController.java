package com.example.demo.Controllers;

import java.util.*;

import com.example.demo.Databases.Department;
import com.example.demo.Interfaces.departmentsInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private departmentsInterface deptInterface;

    @GetMapping("/showDept")
    public List<Department> showDept(){
        var users = (List <Department>) deptInterface.findAll();
        return users;
    }
}
