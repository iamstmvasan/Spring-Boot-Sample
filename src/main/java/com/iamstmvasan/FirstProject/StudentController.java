package com.iamstmvasan.FirstProject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> studentList = new ArrayList<>();
    //Initially i created two student's
    @RequestMapping(value = "/initialStudent")
    public List<Student> initialStudentData(){

        Student student = new Student();
        student.setId(121070987);
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

        studentList.add(student);

        Student student2 = new Student();
        student2.setId(121070969);
        student2.setName("Shahul");
        student2.setDept("MCA");

        List<String> languageList2 = new ArrayList<>();
        languageList2.add("C");
        languageList2.add("Python");
        student2.setLanguage(languageList);

        Address studentAddress2 = new Address();
        studentAddress2.setDoorNo("32");
        studentAddress2.setStreet("West Street");
        studentAddress2.setCity("Kumbakonam");
        studentAddress2.setPin(613100);
        student2.setAddress(studentAddress);

        studentList.add(student2);

        return studentList;
    }

}
