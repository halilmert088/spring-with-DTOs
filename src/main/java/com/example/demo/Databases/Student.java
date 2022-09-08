package com.example.demo.Databases;

import jakarta.persistence.*;

@Entity
@Table(schema = "public", name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department dept;

    @Column(name = "phone")
    private int phone;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Student(){}
    public Student(int id, int phone, String name, String surname, Department dept)
    {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.surname = surname;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}