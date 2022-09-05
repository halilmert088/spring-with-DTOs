package com.example.demo.Interfaces.Services;

import com.example.demo.Databases.Department;
import com.example.demo.Interfaces.DepartmentsInterface;
import com.example.demo.Repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentsService implements DepartmentsInterface {

    @Autowired
    private DepartmentsRepository deptRepository;

    @Override
    public List<Department> findAll() {
        var users = (List<Department>) deptRepository.findAll();
        return users;
    }

    @Override
    public Optional<Department> findById(int id) {
        Optional<Department> users = deptRepository.findById(id);
        return users;
    }
}
