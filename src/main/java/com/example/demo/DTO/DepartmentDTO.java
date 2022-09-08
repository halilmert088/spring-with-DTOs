package com.example.demo.DTO;
import com.example.demo.Databases.Department;
import com.example.demo.Databases.Faculty;
import com.example.demo.Mappers.StudentMapper;
import lombok.*;

import java.util.*;

@Getter
@Builder
public class DepartmentDTO {
    private int id;
    private String name;

    private FacultyDTO facultyDTO;
    public DepartmentDTO(){}

    public DepartmentDTO(int id, String name, FacultyDTO facultyDTO)
    {
        this.id = id;
        this.name = name;
        this.facultyDTO = facultyDTO;
    }

    public Department convert(DepartmentDTO departmentDTO)
    {
        StudentMapper studentMapper = new StudentMapper();
        Department department = new Department();
        department.setDeptId(departmentDTO.getId());
        department.setDeptName(departmentDTO.getName());
        department.setFacultyId(departmentDTO.getFacultyDTO().getId());
        return department;
    }

}
