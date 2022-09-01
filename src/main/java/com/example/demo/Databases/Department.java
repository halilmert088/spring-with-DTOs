package com.example.demo.Databases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(schema = "public", name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int deptId;
    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "faculty_id")
    private int facultyId;

    @OneToMany(mappedBy = "dept")
    private Set<Student> students;

    public Department(){}
    public Department(int deptId, String deptName)
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
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
