package com.example.demo.Databases;

import jakarta.persistence.*;

@Entity
@Table(schema = "public", name = "Students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Departments dept;

    @Column(name = "phone")
    private int phone;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    public Departments getDept() {
        return dept;
    }

    public void setDept(Departments dept) {
        this.dept = dept;
    }

    public Students(){}
    public Students(int id, int phone, String name, String surname)
    {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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