package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
	@Query(value = "from Teacher where id=:id")
	List<Teacher> findByAge(Integer id);
	
	List<Teacher> findByIdLessThanEqual(Integer id);
	
	List<Teacher> findByIdAndName(Integer id, String name);
}
