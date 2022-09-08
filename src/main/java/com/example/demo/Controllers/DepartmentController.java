package com.example.demo.Controllers;

import java.util.*;

import com.example.demo.DTO.DepartmentDTO;
import com.example.demo.DTO.FacultyDTO;
import com.example.demo.Databases.Department;
import com.example.demo.Interfaces.DepartmentsInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentsInterface deptInterface;

    @GetMapping("/showDept")
    public List<DepartmentDTO> showDept(){
        var users = (List <Department>) deptInterface.findAll();

        List<DepartmentDTO> dept = new ArrayList<DepartmentDTO>();

        for(int i = 0; i < users.size(); i++)
        {
            DepartmentDTO temp = new DepartmentDTO();

            temp = DepartmentDTO.builder()
                    .name(users.get(i).getDeptName())
                    .id(users.get(i).getDeptId())
                    .facultyDTO(FacultyDTO.builder()
                            .id(users.get(i).getFaculty().getFacultyId())
                            .name(users.get(i).getFaculty().getFacultyName())
                            .build())
                    .build();

            dept.add(temp);

            temp = null; // nullify temp after every DTO build to save from memory
        }

        return dept;
    }

    @GetMapping("/findDeptById")
    public DepartmentDTO findById(@RequestParam(value = "id") int num)
    {
        Optional<Department> dept = deptInterface.findById(num);

        DepartmentDTO dto = DepartmentDTO.builder().id(dept.get().getDeptId())
                .name(dept.get().getDeptName())
                .facultyDTO(FacultyDTO.builder()
                        .id(dept.get().getFaculty().getFacultyId())
                        .name(dept.get().getFaculty().getFacultyName())
                        .build())
                .build();

        return dto;
    }
}
