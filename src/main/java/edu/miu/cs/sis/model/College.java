package edu.miu.cs.sis.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class College {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "college_name")
	private String collegeName;
	@OneToMany
	private List<Student> students;
	@OneToMany
	private List<Course> courses;
	@OneToOne
	private Address address;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
