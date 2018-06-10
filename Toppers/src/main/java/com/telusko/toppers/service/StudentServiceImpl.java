package com.telusko.toppers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telusko.toppers.dao.TopStudentRepository;
import com.telusko.toppers.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	TopStudentRepository topStudentRepository;

	public void addStudent(Student student) {
		topStudentRepository.save(student);
	}

	@Transactional
	public List<Student> GetTopStudents(String vAgeGropu, String vCity) {
		int vMinAge = 0;
		int vMaxAge = 0;
		ArrayList<Student> Top5Students = new ArrayList<Student>();

		if (!vAgeGropu.equals("Other")) {
			vMinAge = Integer.parseInt(vAgeGropu.substring(0, 2));
			vMaxAge = Integer.parseInt(vAgeGropu.substring(3, 5));
			System.out.println(vMinAge);
			System.out.println(vMaxAge);
		}
		List<Student> Toppers = topStudentRepository.GetTopStudents( vMinAge,  vMaxAge,  vCity);
		for (int i = 0; i < Toppers.size(); i++) {
			Top5Students.add(Toppers.get(i));
			if (i == 4) {
				break;
			}
		}
		return Top5Students;

	}

}
