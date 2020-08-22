package com.iamstmvasan.FirstProject;

import com.iamstmvasan.FirstProject.model.Qualification;
import com.iamstmvasan.FirstProject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;


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

}
