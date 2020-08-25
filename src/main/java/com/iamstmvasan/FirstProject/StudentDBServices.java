package com.iamstmvasan.FirstProject;

import com.iamstmvasan.FirstProject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDBServices {

    @Autowired
    StudentDBRepository studentDBRepository;

    List<Student> studentList = new ArrayList<>();


    public List<Student> getAllStudents(){
        studentList = studentDBRepository.getAllStudents();
        return studentList;
    }

    public ResponseEntity addStudentToDB(Student addStudent){
        studentList = getAllStudents();
        boolean isIdAvailable = addStudent(addStudent.getId());
        if(isIdAvailable){
            return new ResponseEntity("Student Id is already Availbale !" , HttpStatus.NOT_ACCEPTABLE);
        }else{
            return studentDBRepository.addStudentToDB(addStudent);
        }
    }
    private boolean addStudent(int id){
        boolean isIdAvailable = false;
        for(Student student : studentList)
            if(student.getId() == id){
                isIdAvailable = true;
                break;
            }
        return isIdAvailable;
    }
}
