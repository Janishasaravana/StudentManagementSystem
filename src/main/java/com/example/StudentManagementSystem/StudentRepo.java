package com.example.StudentManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class StudentRepo {


public void save(Student s1) throws ClassNotFoundException,SQLException{
	DBconnection db = new DBconnection();
	Connection conn = DBconnection.getCon();
	
	String q="insert into studentdb values(?,?,?)";
	PreparedStatement ps = conn.prepareStatement(q);
	
	ps.setInt(1,s1.getId());
	ps.setString(2, s1.getName());
	ps.setString(3, s1.getCourse());
	ps.executeUpdate();
	conn.close();
	
}
	public List<Student> fetch() throws ClassNotFoundException, SQLException{

	Connection conn = DBconnection.getCon();
	String q = "select * from studentdb";
	PreparedStatement ps = conn.prepareStatement(q);

	ResultSet rs = ps.executeQuery();
	List<Student> ls = new ArrayList<>();
	while(rs.next()) {
		Student s = new Student(rs.getInt("id"),rs.getString("name"),rs.getString("course"));
		ls.add(s);
		
	}
	conn.close();
	return ls;
}


public void update(int id,String name)throws ClassNotFoundException,SQLException {
	DBconnection db = new DBconnection();
	Connection conn = DBconnection.getCon();
	
	String q="update studentdb set name=? where id =?";
	PreparedStatement ps = conn.prepareStatement(q);

	ps.setString(1, name);
	ps.setInt(2,id);
//	ps.setString(3, course);
	ps.executeUpdate();
	conn.close();
		}
	
public void deleteStudent(int id) throws Exception {

    Connection conn = DBconnection.getCon();

    String q = "delete from studentdb where id=?";
    PreparedStatement ps = conn.prepareStatement(q);

    ps.setInt(1, id);
    ps.executeUpdate();
    conn.close();

}
}
