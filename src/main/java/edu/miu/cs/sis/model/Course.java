package edu.miu.cs.sis.model;

import javax.persistence.*;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private long courseId;
	@Column(name = "course_name")
	private String courseName;
	private String description;
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
