package com.example.demo.Mappers;

import com.example.demo.DTO.*;
import com.example.demo.Databases.Students;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class StudentMapper {
    public static StudentDTO map(Students student){
        return StudentDTO.StudentBuilder.studentBuilderWith().id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .phone(student.getPhone())
                .dept(DepartmentDTO.deptBuilder.deptBuilderWith()
                        .id(student.getDept().getDeptId()).build()).build();
    }

    public Students convertEntity (StudentDTO studentDTO)
    {
        Students student = new Students();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        DepartmentDTO.deptBuilder builder = new DepartmentDTO.deptBuilder();
        student.setDept(builder.convert(studentDTO.getDepartmentDTO()));
        return student;
    }
}

