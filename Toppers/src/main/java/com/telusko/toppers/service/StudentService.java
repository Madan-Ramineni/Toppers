package com.telusko.toppers.service;

import java.util.List;

import com.telusko.toppers.model.Student;

public interface StudentService {
	public void addStudent(Student student);

	public List<Student> GetTopStudents(String vAgeGropu, String vCity);

}
