package com.example.demo.Controllers;

import com.example.demo.DTO.FacultyDTO;
import com.example.demo.Interfaces.FacultyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FacultyController {

    @Autowired private FacultyInterface facultyInterface;

    @GetMapping("/showAllFaculty")
    public List<FacultyDTO> showAll ()
    {
        var faculty = new ArrayList<FacultyDTO>();
        var users = facultyInterface.findAll();

        for(int i=0; i < users.size(); i++)
        {
            FacultyDTO temp = new FacultyDTO();

            temp = FacultyDTO.facultyBuilder.facultyBuilderWith()
                    .name(users.get(i).getFacultyName())
                    .id(users.get(i).getFacultyId())
                    .build();

            faculty.add(temp);
            temp = null;
        }
        return faculty;
    }
}
