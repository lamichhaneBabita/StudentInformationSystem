package edu.miu.cs.sis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import edu.miu.cs.sis.model.Student;
import edu.miu.cs.sis.service.StudentService;
import edu.miu.cs.sis.util.ImageUtil;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/add_student", method = RequestMethod.GET)
	public String getStudentForm() {
		return "addStudent";
	}
	@RequestMapping(value = "/save_student", method = RequestMethod.POST)
	public String saveStudentInfo(@ModelAttribute Student student, @RequestParam CommonsMultipartFile file ) {
		String imageUrl  = ImageUtil.writeImageToDisk(file);
		student.setImageUrl(imageUrl);
		studentService.saveStudentInfo(student);
		return "redirect:/list_student";
	}
	
	@RequestMapping(value ="/list_student")
	public String getAllUserInfo(Model model) {
		model.addAttribute("students", studentService.getAllStudentInfo());

		return "listStudent";
	}

	@RequestMapping(value = "/edit_student")
	public String getEditStudentForm(@RequestParam int id, Model model) {
		
		model.addAttribute("student", studentService.getStudentInfoById(id));
		return "editStudent";
	}

	@RequestMapping(value = "/update_student", method = RequestMethod.POST)
	public String updateStudentInfo(@ModelAttribute Student student, @RequestParam CommonsMultipartFile file) {
		String imageUrl  = ImageUtil.writeImageToDisk(file);
		student.setImageUrl(imageUrl);
		
		studentService.updateStudentInfo(student);

		return "redirect:/list_student";
	}

	@RequestMapping(value = "/delete_student")
	public String deleteStudent(@RequestParam int id) {
		studentService.deleteStudentInfo(id);
		return "redirect:/list_student";
	}
	
	

	

}
