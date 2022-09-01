package com.example.demo.Mappers;

import com.example.demo.DTO.DepartmentDTO;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.Databases.Department;
import com.example.demo.Databases.Student;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DepartmentMapper {
    public DepartmentDTO map(Department department)
    {
        Set<Student> departmentSet = department.getStudents();
        Set<StudentDTO> studentDTOList = departmentSet.stream().map(StudentMapper::map).collect(Collectors.toSet());

        return DepartmentDTO.deptBuilder.deptBuilderWith()
                .id(department.getDeptId())
                .name(department.getDeptName())
                .students(studentDTOList).build();
    }

    public Department convertEntity(DepartmentDTO departmentDTO)
    {
        Department department = new Department();
        department.setDeptId(departmentDTO.getId());
        department.setDeptName(departmentDTO.getName());
        return department;
    }
}
