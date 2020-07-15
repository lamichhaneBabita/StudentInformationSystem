package edu.miu.cs.sis.repository;

import java.util.List;

import edu.miu.cs.sis.model.Student;

public interface StudentRepository {
	public void saveStudentInfo(Student student);

	public List<Student> getAllStudentInfo();

	public void deleteStudentInfo(int id);

	public Student getStudentInfoById(int id);

	public void updateStudentInfo(Student student);

	public Student getStudentByStudentNameandPassword(String studentName, String password);

	void resetPasswordById(Student student);
	
	Student getStudentByEmail(String email);

}
