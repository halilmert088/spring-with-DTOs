package com.example.demo.Repository;
import com.example.demo.Databases.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentsRepository extends CrudRepository <Department, Integer> {
}
