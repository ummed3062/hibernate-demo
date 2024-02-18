package com.nxtwave.dao;

import java.util.List;

import com.nxtwave.entities.Student;

public interface StudentDao {

	void creatStudent(Student student);

	void updateStudent(Student student);

	Student getStudentById(int id);

	List<Student> getStudents();

	void deleteStudent(int id);

}