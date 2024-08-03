package com.jsp.BootCRUD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.BootCRUD.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByName(String name);

	List<Student> findByMobile(long mobile);

	List<Student> findByGender(String gender);

	List<Student> findByMathsGreaterThanAndSciGreaterThanAndEngGreaterThan(int marks, int marks2, int marks3);

	

}
