package edu.miu.cs.sis.controller;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.miu.cs.sis.dto.EmailDto;
import edu.miu.cs.sis.dto.Login;
import edu.miu.cs.sis.model.Student;
import edu.miu.cs.sis.service.StudentService;
import edu.miu.cs.sis.util.EmailUtil;

@Controller
public class LoginController {
	private final MailSender mailSender;
	

	private final StudentService studentService;

	public LoginController(StudentService studentService, MailSender mailSender) {
		this.studentService = studentService;
		this.mailSender = mailSender;
	}

	@GetMapping({ "/", "/login" })
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("/login_student")
	public String login(@ModelAttribute Login login, HttpSession session, Model model, HttpServletResponse response) {
		
		Student student = studentService.getStudentByStudentNameandPassword(login.getStudentName(), login.getPassword());
		if(student != null) {
			session.setAttribute("sname", login.getStudentName());
			session.setAttribute("id", student.getId());
			if(login.getRememberMe() != null) {
				Cookie cookie1 =  new Cookie("studentName", login.getStudentName());
				Cookie cookie2 =  new Cookie("password", login.getPassword());
				Cookie cookie3 = new Cookie("id", String.valueOf(student.getId()));
				cookie1.setMaxAge(100);
				cookie2.setMaxAge(100);
				cookie3.setMaxAge(100);

				response.addCookie(cookie1);
				response.addCookie(cookie2);
				response.addCookie(cookie3);


			}
			return "redirect:/home";	
		}
		model.addAttribute("msg", "Wrong User Name and Password!!");
		return "login";
		
	}
	@GetMapping("/logout")
	public String getLogout(Model model, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		session.invalidate();
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i=0; i<cookies.length; i++){
				if(cookies[i].getName().equals("studentName")){
					model.addAttribute("sname", cookies[i].getValue());
				}
				else if(cookies[i].getName().equals("password")){
					model.addAttribute("spass", cookies[i].getValue());
				}
				else if(cookies[i].getName().equals("id")){
					model.addAttribute("id", Integer.parseInt(cookies[i].getValue()));
				}
			}
		}
		model.addAttribute("msg", "You are Successfully Logged Out!!");
		return "login";
	}
	
	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestParam String email, Model model) {
		Student student = studentService.getStudentByEmail(email);
		
		if(student !=null) {
			String newPassword = getRandomPassword();
			student.setPassword(newPassword);
			studentService.updateStudentInfo(student);
			EmailDto emailDto = new EmailDto();
			emailDto.setFromAddress("babita.lamichhane6@gmail.com");
			emailDto.setToAddress(student.getEmail());
			emailDto.setSubject("Password Reset");
			String msgBody = "Your new password is: " + newPassword;
			emailDto.setMsgBody(msgBody);
			EmailUtil.sendEmail(mailSender, emailDto);
			model.addAttribute("forgetMsg", "Your password has been reset successfully");
		}
		model.addAttribute("forgetMsg", "Your email is not found in our database..");

		return "login";
	}
	
	private String getRandomPassword() {
		SecureRandom random = new SecureRandom();
		String password = new BigInteger(50, random).toString(30);
		return password;
	}

}
