package com.example.demo.Databases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema = "public", name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int facultyId;

    @Column(name = "faculty_name")
    private String facultyName;

    @OneToMany(mappedBy = "faculty")
    private List<Department> departments;

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int faculty_id) {
        this.facultyId = faculty_id;
    }

    public String getFacultyName() { return facultyName; }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @JsonIgnore
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
