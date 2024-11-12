package com.example.student_management_system.Service;

import java.util.List;

import com.example.student_management_system.Entity.Student;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAll();
    Student getStudentById(Integer id);
    void deleteStudent(Integer id);
    Student updateStudent(Student student, Integer id);
    List<Student> getStudentsByYearOfEnrollment(Integer yearOfEnrollment);
    String getDepartmentByStudentId(Integer id);
    void deleteStudentsByYearOfEnrollment(Integer yearOfEnrollment);
}
