package com.example.demo.Controllers;

import com.example.demo.Interfaces.studentsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Component
@RestController
public class TestController {

    @Autowired
    private studentsInterface studentsInterface;

    @GetMapping("/")
    public String homepage(@RequestParam(value = "home", defaultValue = "Home Page")String home){
        return String.format(home);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/sorry")
    public String sorry(@RequestParam(defaultValue = "Sorry :(")String sorry){
        return String.format(sorry);
    }

}