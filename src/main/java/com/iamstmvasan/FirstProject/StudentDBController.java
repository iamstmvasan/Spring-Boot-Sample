package com.iamstmvasan.FirstProject;

import com.iamstmvasan.FirstProject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/student/db/update" , method = RequestMethod.PUT)
    public ResponseEntity updateStudentInDB(@RequestBody  Student updateStudent){
        return studentDBServices.updateStudentInDB(updateStudent);
    }

    @RequestMapping(value = "/student/db/delete/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity deleteStudentInDB(@PathVariable("id") int id){
        return studentDBServices.deleteStudentInDB(id);
    }

    @RequestMapping(value = "/student/db/cgpa/{cgpa}" , method = RequestMethod.GET)
    public ResponseEntity fetchStudentByCgpa(@PathVariable("cgpa") String cgpa){
        return studentDBServices.fetchStudentByCgpa(Integer.valueOf(cgpa));
    }
    @RequestMapping(value = "/student/db/name/{id}" , method = RequestMethod.GET)
    public ResponseEntity fetchNameById(@PathVariable("id") int id){
        return studentDBServices.fetchNameById(id);
    }

}
