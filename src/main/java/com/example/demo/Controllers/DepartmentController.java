package com.example.demo.Controllers;

import java.util.*;

import com.example.demo.DTO.DepartmentDTO;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.Databases.Department;
import com.example.demo.Databases.Student;
import com.example.demo.Interfaces.departmentsInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private departmentsInterface deptInterface;

    @GetMapping("/showDept")
    public List<Department> showDept(){
        var users = (List <Department>) deptInterface.findAll();
        return users;
    }

    @GetMapping("/findDeptById")
    public DepartmentDTO findById(@RequestParam(value = "id") int num)
    {
        Optional<Department> dept = deptInterface.findById(num);

        List<StudentDTO> studentDTO = new ArrayList<StudentDTO>();
        List<Student> students = dept.get().getStudents();

        for (int i = 0; i < students.size(); i++)
        {
            StudentDTO temp = new StudentDTO();

            temp = StudentDTO.StudentBuilder.studentBuilderWith()
                    .name(students.get(i).getName())
                    .surname(students.get(i).getSurname())
                    .id(students.get(i).getId())
                    .phone(students.get(i).getPhone())
                    .build();

            studentDTO.add(temp);
            temp = null;
        }

        DepartmentDTO dto = DepartmentDTO.deptBuilder.deptBuilderWith().id(dept.get().getDeptId())
                .name(dept.get().getDeptName())
                .students(studentDTO)
                .build();

        return dto;
    }
}
