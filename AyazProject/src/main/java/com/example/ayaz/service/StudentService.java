package com.example.ayaz.service;

import com.example.ayaz.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    Student updateStudent(Student student, Integer id);

    Student findUserById(Integer id);

    String deleteStudent(Integer id);

    List<Student> findAllStudent();

}
