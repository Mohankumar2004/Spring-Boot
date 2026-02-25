package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.StudentRepository;

@RequestMapping("/teacher")
@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository student;
	
	@GetMapping("/home")
	public String home() {
		System.out.println("Welcome Home");
		return "Welcome Home";
	}

	@GetMapping
	public List<Student> getAllTeacher() {
		return student.findAll();
	}
	
	@GetMapping("/getbyid")
	public Student getById(@RequestParam int id) {
		return student.findById(id).orElseThrow(() -> new NullPointerException());
	}

	@GetMapping("/{id}/{name}")
	public Student getByIdName(@PathVariable int id, @PathVariable String name) {
		return student.findById(id).orElseThrow(() -> new NullPointerException("e"));
	}
	
}
