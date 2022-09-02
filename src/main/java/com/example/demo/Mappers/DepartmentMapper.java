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
        List<Student> departmentSet = department.getStudents();
        List<StudentDTO> studentDTOList = departmentSet.stream().map(StudentMapper::map).collect(Collectors.toList());

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
