package com.example.demo.Repository;

import com.example.demo.Databases.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface studentsRepository extends CrudRepository<Student, Integer> {
}
