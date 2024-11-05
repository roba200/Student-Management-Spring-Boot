package com.example.student_management_system.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management_system.Entity.Student;
import com.example.student_management_system.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            repository.delete(student.get());
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public Student updateStudent(Student student, Integer id) {
        Student eStudent = repository.findById(id).orElseThrow(() -> new RuntimeException());
        eStudent.setFirstName(student.getFirstName());
        eStudent.setLastName(student.getLastName());
        eStudent.setEmail(student.getEmail());
        eStudent.setYearOfEnrollment(student.getYearOfEnrollment());
        eStudent.setDepartment(student.getDepartment());
        repository.save(eStudent);
        return eStudent;
    }

}
