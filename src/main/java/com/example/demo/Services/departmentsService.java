package com.example.demo.Services;

import com.example.demo.Interfaces.departmentsInterface;
import com.example.demo.Databases.Departments;
import com.example.demo.Repository.departmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class departmentsService implements departmentsInterface{

    @Autowired
    private departmentsRepository deptRepository;

    @Override
    public List<Departments> findAll() {
        var users = (List<Departments>) deptRepository.findAll();
        return users;
    }

    @Override
    public Optional<Departments> findById(int id) {
        Optional<Departments> users = deptRepository.findById(id);
        return users;
    }
}
