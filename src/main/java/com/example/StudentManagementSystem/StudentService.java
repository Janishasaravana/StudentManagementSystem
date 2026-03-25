package com.example.StudentManagementSystem;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentService {
@Autowired
private StudentRepo repo;

public List<Student>getAllStudents() {
try{
return repo.fetch();
}
catch(Exception e) {
	System.out.println(e.getMessage());
	return null;
}
}
public void addStudent(Student s1) throws ClassNotFoundException, SQLException {
	repo.save(s1);
}
public void updateStudent(int id,String name) throws ClassNotFoundException, SQLException {
	repo.update(id, name);
}
public void deleteStudent(int id) throws Exception {
	repo.deleteStudent(id);
}

}