package com.example.demo.Interfaces.Services;

import com.example.demo.Databases.Faculty;
import com.example.demo.Interfaces.FacultyInterface;
import com.example.demo.Repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FacultyService implements FacultyInterface {
    @Autowired private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> findAll() {
        var users = (List<Faculty>) facultyRepository.findAll();
        return users;
    }

    @Override
    public Optional<Faculty> findById(int id) {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        return faculty;
    }
}
