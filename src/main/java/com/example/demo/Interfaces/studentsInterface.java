package com.example.demo.Interfaces;

import com.example.demo.Databases.Student;

import java.util.*;

public interface studentsInterface {
    List<Student> findAll();
    Student getStudent(int num);
    Optional<Student> findById(int id);
}
