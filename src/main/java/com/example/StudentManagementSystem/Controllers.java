package com.example.StudentManagementSystem;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class Controllers {
@Autowired
private StudentService service;

@GetMapping
public List <Student>getAll() {
	return service.getAllStudents();
}
@PostMapping
public String add(@RequestBody Student student) throws ClassNotFoundException, SQLException {
	service.addStudent(student);
	System.out.println("data received");
	return "student added successfully";
	
}
@PostMapping("/update")
public String update(@RequestParam int id,@RequestParam String name) throws ClassNotFoundException, SQLException {
	service.updateStudent(id,name);
	return " Student Updated successfully";
}


}
