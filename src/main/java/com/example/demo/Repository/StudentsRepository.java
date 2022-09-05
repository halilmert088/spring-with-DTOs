package com.example.demo.Repository;

import com.example.demo.Databases.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends CrudRepository<Student, Integer> {
}
