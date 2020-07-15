package edu.miu.cs.sis.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.miu.cs.sis.model.Student;
import edu.miu.cs.sis.service.StudentService;
import edu.miu.cs.sis.util.ImageUtil;
@Controller
public class ImageDisplayController {

	private final StudentService studentService;
	
	@Autowired
	public ImageDisplayController(StudentService studentService) {
		
		this.studentService = studentService;
	}

	@GetMapping("/image-display")
	public void displayImage(@RequestParam int id, HttpServletResponse response) {
		
	Student student = studentService.getStudentInfoById(id);

	ImageUtil.readImageFromDisk(student.getImageUrl(), response);
	}

	
	
}

