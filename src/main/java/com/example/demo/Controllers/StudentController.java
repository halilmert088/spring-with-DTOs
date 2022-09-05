package com.example.demo.Controllers;

import com.example.demo.Databases.Student;
import com.example.demo.Interfaces.*;
import com.example.demo.DTO.*;
import com.example.demo.Mappers.*;

import com.example.demo.Repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired private StudentsInterface studentsInterface;
    @Autowired private StudentsRepository studentsRepository;

    @Autowired private DepartmentsInterface deptInterface;
    @Autowired private StudentMapper studentMapper;

    @GetMapping("/findStudent")
    public StudentDTO showDTO(@RequestParam int num)
    {
        Student student = new Student();
        student = studentsInterface.findAll().get(num);

        StudentDTO studentDTO = new StudentDTO();
        DepartmentDTO departmentDTO = DepartmentDTO.deptBuilder.deptBuilderWith().name(student.getDept().getDeptName())
                .id(student.getDept().getDeptId()).build();

        studentDTO = StudentDTO.StudentBuilder.studentBuilderWith().id(student.getId()).name(student.getName())
                .surname(student.getSurname()).phone(student.getPhone()).dept(departmentDTO).build();

        return studentDTO;
    }

    @GetMapping("/findStudentById")
    public StudentDTO findById(@RequestParam(value = "id", defaultValue = ("123456")) int id)
    {
        var users = studentsInterface.findById(id);

        DepartmentDTO departmentDTO = DepartmentDTO.deptBuilder.deptBuilderWith()
                .name(users.get().getDept().getDeptName())
                .id(users.get().getDept().getDeptId())
                .build();

        StudentDTO studentDTO = StudentDTO.StudentBuilder.studentBuilderWith()
                .id(users.get().getId())
                .name(users.get().getName())
                .surname(users.get().getSurname())
                .phone(users.get().getPhone())
                .dept(departmentDTO)
                .build();

        return studentDTO;
    }

    @GetMapping("/findStudentByDept")
    public List<StudentDTO> findByDept(@RequestParam(value = "id") int id)
    {
        List<StudentDTO> studentDTO = new ArrayList<StudentDTO>();

        List<Student> students = studentsInterface.findAll();

        for(int i = 0; i < students.size(); i++)
        {
            if(students.get(i).getDept().getDeptId() == id) // Check to see if dept id matches with the requested param,
                                                            // build DTO if it does
            {
                StudentDTO temp = new StudentDTO();

                temp = StudentDTO.StudentBuilder.studentBuilderWith()
                        .name(students.get(i).getName())
                        .surname(students.get(i).getSurname())
                        .id(students.get(i).getId())
                        .phone(students.get(i).getPhone())
                        .dept(DepartmentDTO.deptBuilder.deptBuilderWith()
                                .name(students.get(i).getDept().getDeptName())
                                .id(students.get(i).getDept().getDeptId())
                                .build())
                        .build();

                studentDTO.add(temp);
                temp = null; // to better manage memory
            }
        }

        return studentDTO;
    }

    @PostMapping(path = "/newStudent", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> create(@RequestBody StudentDTO newStudent)
    {
        Student student = studentsRepository.save(StudentMapper.convertEntity(newStudent));
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/deleteStudent")
    public void remove(@RequestParam (value = "id") int id)
    {
        studentsRepository.deleteById(id);
    }
}
