package com.iamstmvasan.FirstProject;

import com.iamstmvasan.FirstProject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @RequestMapping(value = "/student/db/add" , method = RequestMethod.POST)
    public ResponseEntity addStudentToDB(@RequestBody  Student addStudent){
        return studentDBServices.addStudentToDB(addStudent);
    }

}
