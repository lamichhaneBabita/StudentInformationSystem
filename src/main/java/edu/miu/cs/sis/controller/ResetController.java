package edu.miu.cs.sis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.miu.cs.sis.model.Student;
import edu.miu.cs.sis.service.StudentService;

@Controller
public class ResetController {

	private final StudentService studentService;

	public ResetController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/reset")
	public String getResetForm() {
		return "reset";
	}

	@PostMapping("/reset-pass")
	public String updateUserPassword(@RequestParam String oldPassword, @RequestParam String newPassword,
			HttpSession session, Model model) {

		Student student = studentService.getStudentInfoById((Integer) session.getAttribute("id"));

		if (student.getPassword().equals(oldPassword)) {
			student.setPassword(newPassword);
			studentService.updateStudentInfo(student);
			return "redirect:/list_student";
		}

		model.addAttribute("message", "Old password doesnot match !!!");
		return "reset";
	}

}
