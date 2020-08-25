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
        if(studentList.isEmpty())
            studentList = getAllStudents();
        boolean isIdAvailable = isIdAvailable(addStudent.getId());
        if(isIdAvailable){
            return new ResponseEntity("Student Id is already Availbale !" , HttpStatus.NOT_ACCEPTABLE);
        }else{
            return studentDBRepository.addStudentToDB(addStudent);
        }
    }

    public ResponseEntity updateStudentInDB(Student updateStudent){
        if(studentList.isEmpty())
            studentList = getAllStudents();
        if(isIdAvailable(updateStudent.getId())){
            return studentDBRepository.updateStudentInDB(updateStudent);
        }else{
            return new ResponseEntity("Student Id is not Available for update/edit data !" , HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity deleteStudentInDB(int id){
        if(studentList.isEmpty())
            studentList = getAllStudents();
        if(isIdAvailable(id)){
            return studentDBRepository.deleteStudentInDB(id);
        }else{
            return new ResponseEntity("Student Id is not Available for delete data/record !" , HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity fetchStudentByCgpa(int cgpa){
        return studentDBRepository.fetchStudentByCgpa(cgpa);
    }
    public ResponseEntity fetchNameById(int id){
        if(studentList.isEmpty())
            studentList = getAllStudents();
        if(isIdAvailable(id)){
            return studentDBRepository.fetchNameById(id);
        }else{
            return new ResponseEntity("Student Id is not Available for fetch Name !" , HttpStatus.NOT_FOUND);
        }
    }
    private boolean isIdAvailable(int id){
        boolean isIdAvailable = false;
        for(Student student : studentList)
            if(student.getId() == id){
                isIdAvailable = true;
                break;
            }
        return isIdAvailable;
    }
}
