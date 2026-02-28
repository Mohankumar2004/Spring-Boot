package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/teacher")
@RestController
public class TeacherController {

	@Autowired
	private TeacherRepository repository;

	@GetMapping("/home")
	public String home() {
		System.out.println("Welcome Home");
		return "Welcome Home";
	}

	@GetMapping
	public List<Teacher> getAllTeacher() {
		return repository.findAll();
	}

	@GetMapping("/getbyid")
	public Teacher getById(@RequestParam int id) {
		return repository.findById(id).orElseThrow(() -> new NullPointerException());
	}

	@GetMapping("/{id}/{name}")
	public Teacher getByIdName(@PathVariable int id, @PathVariable String name) {
		return repository.findById(id).orElseThrow(() -> new NullPointerException("e"));
	}

	@PostMapping("/create")
	public String create() {
		System.out.println("Account created");
		return "Account created";
	}

	@PostMapping
	public Teacher save(@RequestBody Teacher teacher) {
		return repository.save(teacher);
	}

	@PutMapping
	public Teacher update(@RequestBody Teacher teacher) {
		repository.findById(teacher.getId()).orElseThrow(() -> new NullPointerException());
		return repository.save(teacher);
	}

	@DeleteMapping
	public void delete(@RequestParam int id) {
		repository.findById(id).orElseThrow(() -> new NullPointerException());
		repository.deleteById(id);
	}

	@PatchMapping("/updateOneValue")
	public Teacher updateOneValue(@RequestParam int id, @RequestParam String name) {
		Teacher teacher = repository.findById(id).orElseThrow(() -> new NullPointerException("e"));
		teacher.setName(name);
		return repository.save(teacher);
	}
	
	@PostMapping("/customsort")
	public List<Teacher> customSort(@RequestBody Teacher teacher)
	{
		org.springframework.data.domain.Example<Teacher> teac = org.springframework.data.domain.Example.of(teacher);
		return repository.findAll(teac);
		
	}
	
	@DeleteMapping("/deletebyid")
	public void deleteById(@RequestParam(required = false) int id)
	//public void deleteById(@RequestParam(defaultValue = "Guest") String name)
	{
		repository.findById(id).orElseThrow(()-> new NullPointerException("e"));
		System.out.println(id);
		repository.deleteById(id);
		
	}
	
	@GetMapping("/findByIdAndName")
	public List<Teacher> findByIdAndName(@RequestParam Integer id, @RequestParam String name)
	{
		return repository.findByIdAndName(id,name);
	}
	
	
}