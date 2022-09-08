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
import java.util.Optional;

@RestController
public class StudentController {


    @Autowired private StudentsRepository studentsRepository;

    @Autowired private StudentsInterface studentsInterface;
    @Autowired private DepartmentsInterface deptInterface;
    @Autowired private StudentMapper studentMapper;

    @GetMapping("/findStudent")
    public StudentDTO showDTO(@RequestParam int num)
    {
        Student student = new Student();
        student = studentsInterface.findAll().get(num);

        StudentDTO studentDTO = new StudentDTO();
        DepartmentDTO departmentDTO = DepartmentDTO.builder().name(student.getDept().getDeptName())
                .id(student.getDept().getDeptId()).build();

        studentDTO = StudentDTO.builder().id(student.getId()).name(student.getName())
                .surname(student.getSurname()).phone(student.getPhone()).departmentDTO(departmentDTO).build();

        return studentDTO;
    }

    @GetMapping("/findStudentById")
    public StudentDTO findById(@RequestParam(value = "id") int id)
    {
        var users = studentsInterface.findById(id);

        DepartmentDTO departmentDTO = DepartmentDTO.builder()
                .name(users.get().getDept().getDeptName())
                .id(users.get().getDept().getDeptId())
                .facultyDTO(FacultyDTO.builder()
                        .id(users.get().getDept().getFaculty().getFacultyId())
                        .name(users.get().getDept().getFaculty().getFacultyName())
                        .build())
                .build();

        StudentDTO studentDTO = StudentDTO.builder()
                .id(users.get().getId())
                .name(users.get().getName())
                .surname(users.get().getSurname())
                .phone(users.get().getPhone())
                .departmentDTO(departmentDTO)
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
                DepartmentDTO temp1 = new DepartmentDTO();

                temp1 = DepartmentDTO.builder()
                        .name(students.get(i).getDept().getDeptName())
                        .id(students.get(i).getDept().getDeptId())
                        .facultyDTO(FacultyDTO.builder()
                                .id(students.get(i).getDept().getFaculty().getFacultyId())
                                .name(students.get(i).getDept().getFaculty().getFacultyName())
                                .build())
                        .build();

                temp = StudentDTO.builder()
                        .name(students.get(i).getName())
                        .surname(students.get(i).getSurname())
                        .id(students.get(i).getId())
                        .phone(students.get(i).getPhone())
                        .departmentDTO(temp1)
                        .build();

                studentDTO.add(temp);
                temp = null; temp1 = null; // to better manage memory
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

    @GetMapping("/const")
    public void construct()
    {
        Student student = new Student();
    }

    @GetMapping("/deleteStudent")
    public void remove(@RequestParam (value = "id") int id)
    {
        studentsRepository.deleteById(id);
    }
}
