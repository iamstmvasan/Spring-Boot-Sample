package com.iamstmvasan.FirstProject;

import com.iamstmvasan.FirstProject.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentServices {
    public List<Student> studentList = new ArrayList<>();

    //Checking before add a student, if that student data is already available or not
    public boolean addStudentData(Student addStudent){
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

    //Checking a student data is available or not for update student data
    public boolean editStudentData(Student editStudent){
        boolean studentEdited = false;
        Iterator<Student> iterator = studentList.iterator();

        while(iterator.hasNext()){
            Student student = iterator.next();
            if(student.getId() == editStudent.getId()){
                iterator.remove();
                studentEdited = true;
                break;
            }
        }

        if(studentEdited)
            studentList.add(editStudent);
        return studentEdited;
    }

    // Checking a student data is available or not for delete student data
    public boolean deleteStudentData(int deleteStudentId){
        boolean studentDeleted = false;
        Iterator<Student> iterator = studentList.iterator();

        while(iterator.hasNext()){
            Student student = iterator.next();
            if(student.getId() == deleteStudentId){
                iterator.remove();
                studentDeleted = true;
                break;
            }
        }

        return studentDeleted;

    }
}
