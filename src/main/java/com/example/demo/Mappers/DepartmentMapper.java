package com.example.demo.Mappers;

import com.example.demo.DTO.DepartmentDTO;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.Databases.Departments;
import com.example.demo.Databases.Students;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DepartmentMapper {
    public DepartmentDTO map(Departments department)
    {
        Set<Students> departmentSet = department.getStudents();
        Set<StudentDTO> studentDTOList = departmentSet.stream().map(StudentMapper::map).collect(Collectors.toSet());

        return DepartmentDTO.deptBuilder.deptBuilderWith()
                .id(department.getDeptId())
                .name(department.getDeptName())
                .students(studentDTOList).build();
    }

    public Departments convertEntity(DepartmentDTO departmentDTO)
    {
        Departments department = new Departments();
        department.setDeptId(departmentDTO.getId());
        department.setDeptName(departmentDTO.getName());
        return department;
    }
}
