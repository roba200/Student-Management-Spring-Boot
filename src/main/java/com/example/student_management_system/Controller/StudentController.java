package com.example.student_management_system.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management_system.Service.StudentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.student_management_system.Entity.Student;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(service.createStudent(student), HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
        return new ResponseEntity<Student>(service.getStudentById(id),HttpStatus.OK);
    }

    @GetMapping("{id}/department")
    public ResponseEntity<String> getDepartmentByStudentId(@PathVariable("id") Integer id) {
        return new ResponseEntity<String>(service.getDepartmentByStudentId(id), HttpStatus.OK);
    }

    @GetMapping("/year/{yearOfEnrollment}")
    public ResponseEntity<List<Student>> getStudentsByYearOfEnrollment(@PathVariable("yearOfEnrollment") Integer yearOfEnrollment) {
        return new ResponseEntity<List<Student>>(service.getStudentsByYearOfEnrollment(yearOfEnrollment), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id){
        service.deleteStudent(id);
        return new ResponseEntity<String>("Student Deleted Successfully",HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        return new ResponseEntity<Student>(service.updateStudent(student, id),HttpStatus.OK);
    }

    @DeleteMapping("/year/{yearOfEnrollment}")
    public ResponseEntity<String> deleteStudentsByYearOfEnrollment(@PathVariable("yearOfEnrollment") Integer yearOfEnrollment) {
        service.deleteStudentsByYearOfEnrollment(yearOfEnrollment);
        return new ResponseEntity<String>("Students Deleted Successfully", HttpStatus.OK);
    }
}
