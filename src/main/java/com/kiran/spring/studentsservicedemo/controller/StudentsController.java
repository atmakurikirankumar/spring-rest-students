package com.kiran.spring.studentsservicedemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.spring.studentsservicedemo.model.Student;

@RestController
@RequestMapping(value = "/api")
public class StudentsController {

	private List<Student> students;

	public StudentsController() {

		students = new ArrayList<Student>();

		students.add(new Student(1, "Kirankumar", "Atmakuri"));
		students.add(new Student(2, "Gauravpreet", "Atmakuri"));
		students.add(new Student(3, "Bhagyalakshmi", "Atmakuri"));

	}

	@RequestMapping(value = "/getstudents", method = RequestMethod.GET)
	public List<Student> getStudents() {
		return students;
	}

	@RequestMapping(value = "/getstudents/{studentid}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable int studentid) {
		return students.get(studentid);
	}

	@RequestMapping(value = "/createstudent", method = RequestMethod.POST)
	public List<Student> createStudent(@RequestBody Student s) {
		students.add(new Student(s.getId(), s.getFirstname(), s.getLastname()));
		return students;
	}
}
