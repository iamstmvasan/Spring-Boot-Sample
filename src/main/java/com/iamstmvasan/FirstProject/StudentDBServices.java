package com.iamstmvasan.FirstProject;

import com.iamstmvasan.FirstProject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDBServices {

    @Autowired
    StudentDBRepository studentDBRepository;

    public List<Student> getAllStudents(){
        List<Student> studentList = studentDBRepository.getAllStudents();
        return studentList;
    }
}
