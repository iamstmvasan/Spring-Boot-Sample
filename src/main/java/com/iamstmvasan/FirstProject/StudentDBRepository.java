package com.iamstmvasan.FirstProject;

import com.iamstmvasan.FirstProject.model.Qualification;
import com.iamstmvasan.FirstProject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDBRepository {
   @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> getAllStudents(){
        String query = "SELECT * FROM student";
        List<Student> studentList = jdbcTemplate.query(query, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDept(resultSet.getString("dept"));

                Qualification qualification = new Qualification();
                qualification.setCgpa(resultSet.getString("cgpa"));
                qualification.setSkill(resultSet.getString("skill"));

                student.setQualification(qualification);

                return student;
            }
        });
        return studentList;
    }

    public ResponseEntity addStudentToDB(Student addStudent){
        String query = "INSERT INTO student (id , name , dept , cgpa , skill) VALUES (? , ? , ? , ? , ?)";
        int rowAffected = jdbcTemplate.update(query , addStudent.getId() , addStudent.getName() , addStudent.getDept() ,
                                                        addStudent.getQualification().getCgpa() , addStudent.getQualification().getSkill());

        return new ResponseEntity("Succesfully added "+ rowAffected +" row !" ,HttpStatus.OK);
    }
    public ResponseEntity updateStudentInDB(Student updateStudent){
        deleteStudentInDB(updateStudent.getId());
        addStudentToDB(updateStudent);
        return new ResponseEntity("Succesfully updated !" , HttpStatus.OK);
    }
    public ResponseEntity deleteStudentInDB(int studentId){
        String query = "DELETE FROM student WHERE id = ?";
        int rowAffected = jdbcTemplate.update(query , studentId);
        return new ResponseEntity("Successfully deleted "+rowAffected+" row !" , HttpStatus.OK);

    }
    public ResponseEntity fetchStudentByCgpa(int cgpa){
        String query = "SELECT * FROM student WHERE cgpa >= "+cgpa;
        List<Student> studentCgpaList = jdbcTemplate.query(query, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDept(resultSet.getString("dept"));

                Qualification qualification = new Qualification();
                qualification.setCgpa(resultSet.getString("cgpa"));
                qualification.setSkill(resultSet.getString("skill"));

                student.setQualification(qualification);
                return student;
            }
        });
        return new ResponseEntity(studentCgpaList , HttpStatus.OK);
    }
    public ResponseEntity fetchNameById(int id){
        String query = "SELECT name FROM student WHERE id = "+id;
        String name = jdbcTemplate.queryForObject(query , String.class);
        return new ResponseEntity("The name of this Id is : "+name , HttpStatus.OK);
    }
}
