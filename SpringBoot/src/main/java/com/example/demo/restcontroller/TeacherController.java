package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;

import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class TeacherController {
	
	@Autowired
	private TeacherRepository repository;
	
	@GetMapping("/home")
	public String home() {
		System.out.println("Welcome Home");
		return "Welcome Home";
		
	}
	
	@PostMapping("/create")
	public String create() {
		System.out.println("Account created");
		
		return "Account created";
	}
	
	@GetMapping("/getall")
	public List<Teacher> getAllTeacher(){
		return repository.findAll();
	}
	
	
	
	
}
