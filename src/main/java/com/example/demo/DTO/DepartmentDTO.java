package com.example.demo.DTO;
import com.example.demo.Databases.Department;
import com.example.demo.Mappers.StudentMapper;
import lombok.*;

import java.util.*;

@Getter
public class DepartmentDTO {
    private int id;
    private String name;
    //private List<StudentDTO> students;

    public DepartmentDTO(){}

    public DepartmentDTO(deptBuilder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        //this.students = builder.students;
    }

    @Getter
    public static class deptBuilder{
        private int id;
        private String name;
        private List<StudentDTO> students;

        public deptBuilder() {}

        public static deptBuilder deptBuilderWith()
        {
            return new deptBuilder();
        }

        public deptBuilder id(int id)
        {
            this.id = id;
            return this;
        }

        public deptBuilder name(String name)
        {
            this.name = name;
            return this;
        }

        //public deptBuilder students(List<StudentDTO> students)
        //{
        //    this.students = students;
        //    return this;
        //}

        public Department convert(DepartmentDTO departmentDTO)
        {
            StudentMapper studentMapper = new StudentMapper();
            Department department = new Department();
            department.setDeptId(departmentDTO.getId());
            department.setDeptName(departmentDTO.getName());
            return department;
        }

        public DepartmentDTO build()
        {
            return new DepartmentDTO(this);
        }

    }
}
