package com.iamstmvasan.FirstProject;

import com.iamstmvasan.FirstProject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentDBController {

    @Autowired
    StudentDBServices studentDBServices;

    @RequestMapping(value = "/student/db/all")
    public List<Student> getAllStudents(){
        List<Student> studentList = studentDBServices.getAllStudents();
        return studentList;
    }

}
