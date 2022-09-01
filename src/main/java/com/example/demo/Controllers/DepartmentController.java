package com.example.demo.Controllers;

import java.util.*;

import com.example.demo.DTO.DepartmentDTO;
import com.example.demo.Databases.Department;
import com.example.demo.Interfaces.departmentsInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/showDeptDto")
    public List<DepartmentDTO> showDTO()
    {
        List<DepartmentDTO> dept = new ArrayList<DepartmentDTO>();
        List<Department> users = deptInterface.findAll();

        for(int i = 0; i < users.size(); i++)
        {
            dept.add(DepartmentDTO.deptBuilder.deptBuilderWith().id(users.get(i).getDeptId())
                    .name(users.get(i).getDeptName()).build());
        }

        return dept;
    }

    @GetMapping("/findDeptById")
    public DepartmentDTO findById(@RequestParam(value = "id") int num)
    {
        Optional<Department> dept = deptInterface.findById(num);

        DepartmentDTO dto = DepartmentDTO.deptBuilder.deptBuilderWith().id(dept.get().getDeptId()).
                name(dept.get().getDeptName()).build();

        return dto;
    }
}
