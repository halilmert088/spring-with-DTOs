package com.example.demo.Databases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.example.demo.DTO.StudentDTO;

import java.util.List;
import java.util.Set;

@Entity
@Table(schema = "public", name = "Departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int deptId;
    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "faculty_id")
    private int facultyId;

    @OneToMany(mappedBy = "dept")
    private Set<Students> students;

    public Departments(){}
    public Departments(int deptId, String deptName)
    {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int Id) {
        this.deptId = Id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    @JsonIgnore
    public Set<Students> getStudents() {
        return students;
    }

    public void setStudents(Set<Students> students) {
        this.students = students;
    }
}
