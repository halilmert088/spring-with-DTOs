package com.example.demo.DTO;
import com.example.demo.Databases.Faculty;
import com.example.demo.Mappers.DepartmentMapper;
import lombok.*;

import java.util.*;

@Getter

public class FacultyDTO {
    private int id;

    private String name;

    public FacultyDTO(){}

    public FacultyDTO(facultyBuilder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
    }

    @Getter
    public static class facultyBuilder{
        private int id;
        private String name;
        private List <FacultyDTO> faculties;

        public facultyBuilder(){}
        public static facultyBuilder facultyBuilderWith(){return new facultyBuilder();}

        public facultyBuilder id(int id)
        {
            this.id = id;
            return this;
        }

        public facultyBuilder name(String name)
        {
            this.name = name;
            return this;
        }

        public Faculty convert(FacultyDTO facultyDTO)
        {
            DepartmentMapper departmentMapper = new DepartmentMapper();
            Faculty faculty = new Faculty();
            faculty.setFacultyId(facultyDTO.getId());
            faculty.setFacultyName(facultyDTO.getName());
            return faculty;
        }

        public FacultyDTO build(){return new FacultyDTO(this);}
    }
}
