package com.example.demo.Interfaces;

import com.example.demo.Databases.Student;

import java.util.*;

public interface StudentsInterface {
    List<Student> findAll();
    Optional<Student> findById(int id);
}
