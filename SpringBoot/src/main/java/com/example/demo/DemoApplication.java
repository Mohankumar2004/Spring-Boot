package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run=SpringApplication.run(DemoApplication.class, args);
		
		TeacherRepository repository = run.getBean(TeacherRepository.class);
		
//		Teacher teacher=new Teacher();
//		teacher.setId(3);
//		teacher.setName("Kavi");
//		
//		repository.save(teacher);
		
//		Teacher teach = repository.findById(1);
//		System.out.println(teach.getName());
		
		
		List<Teacher> list=repository.findAll();
		for (Teacher tc : list) {
			System.out.println(tc.getName());
		}
		
		
		
	}

}
