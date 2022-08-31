package com.example.demo.Interfaces;

import com.example.demo.Databases.Departments;
import java.util.*;

public interface departmentsInterface {
    List<Departments> findAll();
    Optional<Departments> findById(int id);
}
