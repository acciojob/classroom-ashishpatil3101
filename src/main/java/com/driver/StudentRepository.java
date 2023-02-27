package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentdb=new HashMap<>();
    HashMap<String, Teacher> teacherdb=new HashMap<>();
    HashMap<String, List<String>> pair=new HashMap<>();//teacher vs student

    public void  addStudent( Student student){

        studentdb.put(student.getName(),student);

    }

    public void addTeacher(@RequestBody Teacher teacher){

       teacherdb.put(teacher.getName(),teacher);


    }

    public void addStudentTeacherPair( String student,  String teacher){

        if(!pair.containsKey(teacher)) pair.put(teacher,new ArrayList<>());

        pair.get(teacher).add(student);

    }
    public Student getStudentByName( String name){
        // Assign student by calling service layer method

        return  studentdb.get(name);
    }
    public Teacher getTeacherByName( String name){
        // Assign student by calling service layer method

        return teacherdb.get(name);
    }
    public List<String> getStudentsByTeacherName( String teacher){
        // Assign list of student by calling service layer method
        List<String> li =new ArrayList<String>();
        return  pair.getOrDefault(teacher,li);

    }
    public List<String> getAllStudents(){
  // Assign list of student by calling service layer method

       List<String> ans=new ArrayList<>();

       for(String std:studentdb.keySet())
           ans.add(""+studentdb.get(std));

       return ans;
    }

    public void deleteTeacherByName( String teacher){

        teacherdb.remove(teacher);
        pair.remove(teacher);

    }

    public void deleteAllTeachers(){

          teacherdb.clear();
          pair.clear();

    }


}
