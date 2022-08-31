package com.example.demo.Services;

import com.example.demo.Databases.Students;
import com.example.demo.Interfaces.studentsInterface;
import com.example.demo.Repository.studentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentsService implements studentsInterface {

    @Autowired
    private studentsRepository studentsRepository;

    @Override
    public List<Students> findAll() {
        var users = (List<Students>) studentsRepository.findAll();
        return users;
    }
}
