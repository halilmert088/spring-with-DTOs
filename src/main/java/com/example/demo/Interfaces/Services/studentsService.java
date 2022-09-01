package com.example.demo.Interfaces.Services;

import com.example.demo.Databases.Student;
import com.example.demo.Interfaces.studentsInterface;
import com.example.demo.Repository.studentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class studentsService implements studentsInterface {

    @Autowired
    private studentsRepository studentsRepository;

    @Override
    public List<Student> findAll() {
        var users = (List<Student>) studentsRepository.findAll();
        return users;
    }

    @Override
    public Student getStudent(@RequestParam int num) {
        var users = (List<Student>) studentsRepository.findAll();
        return users.get(num);
    }
}
