package com.example.ayaz.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.ayaz.entity.Student;
import com.example.ayaz.repo.StudentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo repo;

    @Override
    public Student saveStudent(Student student) {
        if (Objects.isNull(student))
            return null;
        else
            return repo.save(student);
    }

    @Override

    public Student updateStudent(Student student,Integer id) {
        Student s = new Student();
        s.setId(student.getId());
        s.setName(student.getName());
        s.setAddress(student.getAddress());
        return repo.save(s);
    }

    @Override
    public Student findUserById(Integer id) {
        Student s = repo.findById(id).get();
        return s;
    }

    @Override
    public String deleteStudent(Integer id) {
        repo.deleteById(id);
        return "Student record deleted successfully.....";
    }

    @Override
    public List<Student> findAllStudent() {
        return repo.findAll();

    }
}
