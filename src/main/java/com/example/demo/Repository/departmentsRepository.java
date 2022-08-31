package com.example.demo.Repository;
import com.example.demo.Databases.Departments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentsRepository extends CrudRepository <Departments, Integer> {
}
