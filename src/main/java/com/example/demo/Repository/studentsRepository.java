package com.example.demo.Repository;

import com.example.demo.Databases.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentsRepository extends CrudRepository<Students, Integer> {
}
