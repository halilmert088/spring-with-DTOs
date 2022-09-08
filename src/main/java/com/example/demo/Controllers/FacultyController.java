package com.example.demo.Controllers;

import com.example.demo.DTO.DepartmentDTO;
import com.example.demo.DTO.FacultyDTO;
import com.example.demo.Databases.Department;
import com.example.demo.Databases.Faculty;
import com.example.demo.Interfaces.DepartmentsInterface;
import com.example.demo.Interfaces.FacultyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class FacultyController {

    @Autowired private FacultyInterface facultyInterface;
    @Autowired private DepartmentsInterface departmentsInterface;

    @GetMapping("/showAllFaculty")
    public List<FacultyDTO> showAll ()
    {
        var faculty = new ArrayList<FacultyDTO>();
        var users = facultyInterface.findAll();

        for(int i=0; i < users.size(); i++)
        {
            FacultyDTO temp = new FacultyDTO();

            temp = FacultyDTO.builder()
                    .name(users.get(i).getFacultyName())
                    .id(users.get(i).getFacultyId())
                    .build();

            faculty.add(temp);
            temp = null;
        }
        return faculty;
    }

    @GetMapping("/showDepartments")
    public List<DepartmentDTO> showDept(@RequestParam(value = "id") int id)
    {
        var users = new ArrayList<DepartmentDTO>();

        List<Department> departments = departmentsInterface.findAll();
        Optional<Faculty> faculty = facultyInterface.findById(id);

        for(int i = 0; i < departments.size(); i++)
        {
            if(departments.get(i).getFacultyId() == id)
            {
                DepartmentDTO temp = new DepartmentDTO();

                temp = DepartmentDTO.builder()
                        .name(departments.get(i).getDeptName())
                        .id(departments.get(i).getDeptId())
                        .build();

                users.add(temp);
                temp = null;
            }
        }

        return users;
    }
}
