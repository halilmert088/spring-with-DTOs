package com.example.demo.Interfaces;

import com.example.demo.Databases.Department;
import java.util.*;

public interface DepartmentsInterface {
    List<Department> findAll();
    Optional<Department> findById(int id);
}
