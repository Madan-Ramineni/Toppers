package com.telusko.toppers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telusko.toppers.model.Student;
import com.telusko.toppers.service.StudentService;;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Qualifier(value = "studentService")
	public void setStudenrService(StudentService ss) {
		this.studentService = ss;
	}
	
	@RequestMapping("/home")
	public String home () {
		return "index";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest req, HttpServletResponse resp, Model mv) {

		String vName = req.getParameter("StudentName");
		System.out.println(vName);
		int vMarks = Integer.parseInt(req.getParameter("Marks"));
		String vCity = req.getParameter("City");
		int vAge = Integer.parseInt(req.getParameter("Age"));
		Student student = new Student();
		student.setAge(vAge);
		student.setMarks(vMarks);
		student.setCity(vCity);
		student.setName(vName);
		this.studentService.addStudent(student);

		
		 mv.addAttribute("Result", vName);

		return "Success";
	}

	@RequestMapping("/topstudents")
	public String topStudents(HttpServletRequest req, HttpServletResponse resp, Model model) {
		//ModelAndView model = new ModelAndView();
		String vAgeGropu = req.getParameter("AgeGroup");
		String vCity = req.getParameter("City");
		
		System.out.println(vAgeGropu + vCity);
		
		model.addAttribute("toppers", this.studentService.GetTopStudents(vAgeGropu, vCity));
		model.addAttribute("location", vCity);
		// model.addAttribute("listPersons", this.personService.listPersons());
		return "topstudents";
	}
}
