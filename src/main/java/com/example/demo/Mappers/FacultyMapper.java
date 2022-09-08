package com.example.demo.Mappers;

import com.example.demo.Databases.Faculty;
import com.example.demo.Databases.Department;
import com.example.demo.DTO.DepartmentDTO;
import com.example.demo.DTO.FacultyDTO;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class FacultyMapper {
    public static FacultyDTO map(Faculty faculty)
    {
        List<Department> facultySet = faculty.getDepartments();
        List<DepartmentDTO> departmentsDTOList = facultySet.stream().map(DepartmentMapper::map).collect(Collectors.toList());

        return FacultyDTO.builder()
                .id(faculty.getFacultyId())
                .name(faculty.getFacultyName())
                .build();
    }

    public static Faculty convertEntity(FacultyDTO facultyDTO)
    {
        Faculty faculty = new Faculty();
        faculty.setFacultyId(facultyDTO.getId());
        faculty.setFacultyName(facultyDTO.getName());
        return faculty;
    }
}
