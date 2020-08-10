package com.iamstmvasan.FirstProject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    private List<Student> studentList = new ArrayList<>();

    //Initially i created two student's
    @RequestMapping(value = "student/create")
    public ResponseEntity initialStudentData(){
        ResponseEntity responseEntity;
            Student student = new Student();
            student.setId(987);
            student.setName("Thiru");
            student.setDept("MCA");

            List<String> languageList = new ArrayList<>();
            languageList.add("C");
            languageList.add("Java");
            languageList.add("Python");
            languageList.add("Android");
            languageList.add("Spring Boot");
            student.setLanguage(languageList);

            Address studentAddress = new Address();
            studentAddress.setDoorNo("3/565");
            studentAddress.setStreet("East Street");
            studentAddress.setCity("Thiruvaiyaru");
            studentAddress.setPin(613204);
            student.setAddress(studentAddress);

            Student student2 = new Student();
            student2.setId(969);
            student2.setName("Shahul");
            student2.setDept("MCA");

            List<String> languageList2 = new ArrayList<>();
            languageList2.add("C");
            languageList2.add("Python");
            student2.setLanguage(languageList2);

            Address studentAddress2 = new Address();
            studentAddress2.setDoorNo("32");
            studentAddress2.setStreet("West Street");
            studentAddress2.setCity("Kumbakonam");
            studentAddress2.setPin(613100);
            student2.setAddress(studentAddress);

        boolean studentAdded = addStudentData(student);
        boolean student2Added = addStudentData(student2);
        if(studentAdded || student2Added){
            Map<String, String> map = new HashMap<>();
            map.put("Message", "Student data is successfully Created !");
            responseEntity = new ResponseEntity(map, HttpStatus.OK);
            return responseEntity;
        }
        else{
            Map<String, String> map = new HashMap<>();
            map.put("Message", "Student data is Already Created !");
            responseEntity = new ResponseEntity(map, HttpStatus.OK);
            return responseEntity;
        }
    }

    @RequestMapping(value = "/allStudents")
    public ResponseEntity allStudents(){
        ResponseEntity responseEntity;
        if(studentList.isEmpty()){
            Map<String , String> map = new HashMap<>();
            map.put("Message","Student data is empty, Create Data(student/create)");
            responseEntity = new ResponseEntity(map , HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        else{
            responseEntity = new ResponseEntity(studentList , HttpStatus.OK);
            return responseEntity;
        }
    }

    @RequestMapping(value = "/student/name/{name}")
    public ResponseEntity fetchStudentByName(@PathVariable("name") String name){
        ResponseEntity responseEntity;
        if(studentList.isEmpty()){
            Map<String , String> map = new HashMap<>();
            map.put("Message","Student data is empty, Create Data(student/create)");
            responseEntity = new ResponseEntity(map , HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        else{
            for(Student student: studentList) {
                if(student.getName().equalsIgnoreCase(name)) {
                    responseEntity = new ResponseEntity(student, HttpStatus.OK);
                    return responseEntity;
                }
            }
            Map<String, String> map = new HashMap<>();
            map.put("message", "Student not found");
            responseEntity = new ResponseEntity(map, HttpStatus.NOT_FOUND);
            return responseEntity;
        }


    }

    @RequestMapping(value = "/student/id/{id}")
    public ResponseEntity fetchStudentById(@PathVariable("id") int id){
        if(studentList.isEmpty()){
            Map<String , String> map = new HashMap<>();
            map.put("Message","Student data is empty, Create Data(student/create)");
            ResponseEntity responseEntity = new ResponseEntity(map , HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        else{
            for(Student student: studentList) {
                if(student.getId() == id) {
                    ResponseEntity responseEntity = new ResponseEntity(student, HttpStatus.OK);
                    return responseEntity;
                }
            }
            Map<String, String> map = new HashMap<>();
            map.put("message", "Student not found");
            ResponseEntity responseEntity = new ResponseEntity(map, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
    }

    @RequestMapping(value = "/student/language/{language}")
    public ResponseEntity fetchStudentByLanguage(@PathVariable("language") String language){
        List<Student> list = new ArrayList<>();
        boolean studentKnownLanguage = false;
        if(studentList.isEmpty()){
            Map<String , String> map = new HashMap<>();
            map.put("Message","Student data is empty, Create Data(student/create)");
            ResponseEntity responseEntity = new ResponseEntity(map , HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        else{
            for(Student student : studentList)
                if(student.getLanguage().contains(language)){
                    studentKnownLanguage = true;
                    list.add(student);
                }
            ResponseEntity responseEntity;
            if(studentKnownLanguage)
                responseEntity = new ResponseEntity(list , HttpStatus.OK);
            else{
                Map<String , String> map = new HashMap<>();
                map.put("Message" , "Students dont known "+language);
                responseEntity = new ResponseEntity(map , HttpStatus.OK);
            }
            return responseEntity;
        }

    }

    @RequestMapping(value = "/addStudent" , method = RequestMethod.POST)
    public ResponseEntity addStudent(@RequestBody Student addStudent){
        ResponseEntity responseEntity;
        Map<String , String> map = new HashMap<>();
        if( addStudentData(addStudent) ){
            map.put("Message" , "Student Added Successfully !");
            responseEntity = new ResponseEntity(map , HttpStatus.OK);
            return responseEntity;
        }
        else{
            map.put("Message" , "Student Data is Already Added  !");
            responseEntity = new ResponseEntity(map , HttpStatus.OK);
            return responseEntity;
        }

    }

    private boolean addStudentData(Student addStudent){
        boolean studentAdded = true;
        for(Student student : studentList)
            if(student.getId() == addStudent.getId()){
                studentAdded = false;
                break;
            }
        if(studentAdded)
            studentList.add(addStudent);
        return studentAdded;

    }
}
