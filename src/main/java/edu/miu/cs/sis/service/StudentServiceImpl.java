package edu.miu.cs.sis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.sis.model.Student;
import edu.miu.cs.sis.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Override
	
	public void saveStudentInfo(Student student) {
		studentRepository.saveStudentInfo(student);

	}
	@Override
	public List<Student> getAllStudentInfo() {
		
		return studentRepository.getAllStudentInfo();
	}
	@Override
	public void deleteStudentInfo(int id) {
		studentRepository.deleteStudentInfo(id);
		
	}
	@Override
	public Student getStudentInfoById(int id) {
		
		return studentRepository.getStudentInfoById(id);
	}
	@Override
	public void updateStudentInfo(Student student) {
		studentRepository.updateStudentInfo(student);
		
	}
	@Override
	public Student getStudentByStudentNameandPassword(String studentName, String password) {
		
		return studentRepository.getStudentByStudentNameandPassword(studentName, password);
	}
	@Override
	public void resetPasswordById(Student student) {
		studentRepository.resetPasswordById(student);
		
	}
	
	@Override
	public Student getStudentByEmail(String email) {
		return studentRepository.getStudentByEmail(email);
	}

}
