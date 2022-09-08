package com.example.demo.DTO;

import com.example.demo.Databases.Department;
import com.example.demo.Mappers.DepartmentMapper;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class StudentDTO {
    private int id;
    private String name;
    private String surname;
    private int phone;
    private DepartmentDTO departmentDTO;

    public StudentDTO(){}

    public StudentDTO(int id, String name, String surname, int phone, DepartmentDTO dept)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.departmentDTO = dept;
    }
}


