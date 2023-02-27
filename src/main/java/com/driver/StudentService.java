package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository student_Repository;
    public void  addStudent( Student student){
        student_Repository.addStudent(student);

    }
    public void addTeacher( Teacher teacher){

        student_Repository.addTeacher(teacher);


    }
    public void addStudentTeacherPair( String student,  String teacher){
        student_Repository.addStudentTeacherPair(student,teacher);

    }
    public Student getStudentByName( String name){
        Student student = student_Repository.getStudentByName(name); // Assign student by calling service layer method

        return  student;
    }
    public Teacher getTeacherByName( String name){
        Teacher teacher = student_Repository.getTeacherByName(name); // Assign student by calling service layer method

        return teacher;
    }
    public List<String> getStudentsByTeacherName( String teacher){
        List<String> students = student_Repository.getStudentsByTeacherName(teacher); // Assign list of student by calling service layer method

        return students;
    }

    public List<String> getAllStudents(){
        List<String> students = student_Repository.getAllStudents(); // Assign list of student by calling service layer method

        return students;
    }
    public void deleteTeacherByName( String teacher){
        student_Repository.deleteTeacherByName(teacher);


    }

    public void deleteAllTeachers(){
        student_Repository.deleteAllTeachers();


    }


}
