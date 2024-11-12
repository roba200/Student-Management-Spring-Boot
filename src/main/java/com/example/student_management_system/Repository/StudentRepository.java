package com.example.student_management_system.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import org.springframework.data.jpa.repository.Query;


import com.example.student_management_system.Entity.Student;

import jakarta.transaction.Transactional;

public interface  StudentRepository extends JpaRepository<Student,Integer>{
    List<Student> findByYearOfEnrollment(Integer yearOfEnrollment);
    
    @Query("SELECT s.department FROM Student s WHERE s.id = :id")
    String findDepartmentByStudentId(Integer id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.yearOfEnrollment = :yearOfEnrollment")
    void deleteByYearOfEnrollment(Integer yearOfEnrollment);
}
