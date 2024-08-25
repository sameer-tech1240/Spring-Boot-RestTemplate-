package com.example.ayaz.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ayaz.entity.Student;
import com.example.ayaz.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v5")
@RequiredArgsConstructor
public class StudentControler {

    private final StudentService studentService;

    @PostMapping("/save")
    public Student createStudent(@RequestBody Student student) {
        return this.studentService.saveStudent(student);

    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Integer id) {
        return studentService.updateStudent(student, id);

    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findBYId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(this.studentService.findUserById(id));


        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("id not found");

        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "Student record deleted successfully.....";
    }

    @GetMapping("/getAll")
    public List<Student> findAllStudent() {
        return studentService.findAllStudent();
    }


}




