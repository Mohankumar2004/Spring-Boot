package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Teacher;

public interface TeacherService {
	public String home();
	public List<Teacher> getAllTeacher();
	public Teacher getById(@RequestParam int id);
	public Teacher getByIdName(@PathVariable int id, @PathVariable String name);
	public String create();
	public Teacher save(@RequestBody Teacher teacher);
	
}
