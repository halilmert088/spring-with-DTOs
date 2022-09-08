package com.example.demo.DTO;
import com.example.demo.Databases.Faculty;
import com.example.demo.Mappers.DepartmentMapper;
import lombok.*;

import java.util.*;

@Getter
@Builder
public class FacultyDTO {
    private int id;

    private String name;

    public FacultyDTO(){}

    public FacultyDTO(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Faculty convert(FacultyDTO facultyDTO)
    {
        DepartmentMapper departmentMapper = new DepartmentMapper();
        Faculty faculty = new Faculty();
        faculty.setFacultyId(facultyDTO.getId());
        faculty.setFacultyName(facultyDTO.getName());
        return faculty;
    }
}
