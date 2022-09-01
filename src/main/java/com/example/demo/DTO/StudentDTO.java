package com.example.demo.DTO;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class StudentDTO {
    private int id;
    private String name;
    private String surname;
    private int phone;
    private DepartmentDTO departmentDTO;

    public StudentDTO(){};

    public StudentDTO(StudentBuilder studentBuilder)
    {
        this.id = studentBuilder.id;
        this.name = studentBuilder.name;
        this.surname = studentBuilder.surname;
        this.phone = studentBuilder.phone;
    }

    @Getter
    public static class StudentBuilder {
        private int id;
        private String name;
        private String surname;
        private int phone;
        private DepartmentDTO departmentDTO;

        public StudentBuilder() {}

        public static StudentBuilder studentBuilderWith() {
            return new StudentBuilder();
        }

        public StudentBuilder id(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public StudentBuilder phone(int phone) {
            this.phone = phone;
            return this;
        }

        public StudentBuilder dept(DepartmentDTO departmentDTO)
        {
            this.departmentDTO = departmentDTO;
            return this;
        }

        public StudentDTO build()
        {
            return new StudentDTO(this);
        }

    }
}


