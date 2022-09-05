package com.example.demo.Repository;

import com.example.demo.Databases.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
}
