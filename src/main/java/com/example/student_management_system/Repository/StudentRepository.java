package com.example.student_management_system.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_management_system.Entity.Student;

public interface  StudentRepository extends JpaRepository<Student,Integer>{
    
}
