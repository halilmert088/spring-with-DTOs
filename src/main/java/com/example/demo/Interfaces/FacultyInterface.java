package com.example.demo.Interfaces;

import com.example.demo.Databases.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyInterface {
    List<Faculty> findAll();
    Optional<Faculty> findById(int id);
}
