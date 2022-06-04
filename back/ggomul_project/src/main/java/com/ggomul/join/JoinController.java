package com.ggomul.join;

import java.io.File;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ggomul.user.Customer;
import com.ggomul.user.User;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

@Controller
@RequestMapping("/join")
public class JoinController implements Runnable {
	String emailAddress;
	String key;
	ExecutorService executorService;

	@Autowired
	JoinService joinService;

	String uploadDir;

	public JoinController(ServletContext sc) {
		uploadDir = sc.getRealPath("/upload/join");
	}

	@GetMapping("teacher")
	public void teacher() {
	}

	@GetMapping("customer")
	public void customer() {
	}

	@GetMapping("form")
	public void form() {
	}

	@GetMapping("registration")
	public void registration() {
	}

	@GetMapping("memberselect")
	public void memberselect() {
	}

	// 강사 회원가입
	@PostMapping("teacherJoin")
	public String teacherJoin(User user, MultipartFile filePath, String birthDay, String mail, int branchNo,
			String profilePhoto, String nameBank, String accountNumber) throws Exception {
		if (user.getTel().equals("")) {
			user.setTel(null);
		}

		String emailAddress = user.getEmail() + "@" + mail;
		user.setEmail(emailAddress);
		user.setDateBirth(birthDay);
		user.setTypeNo(1);

		Map<String, Object> params = new HashMap<>();
		if (!filePath.isEmpty()) {
			String fileName = UUID.randomUUID().toString();
			filePath.transferTo(new File(uploadDir + "/" + fileName));
			params.put("profilePhoto", fileName);
		}

		// 이메일 인증 키 넣는 곳

	

		this.emailAddress = emailAddress;
		executorService = Executors.newCachedThreadPool();
		executorService.submit(this);

		return "redirect:/app/auth/form";
	}

	// 고객 회원가입
	@PostMapping("customerJoin")
	public String customerJoin(User user, String birthDay, String mail, String nickname) throws Exception {
		if (user.getTel().equals("")) {
			user.setTel(null);
		}

		String emailAddress = user.getEmail() + "@" + mail;
		user.setEmail(emailAddress);
		user.setDateBirth(birthDay);
		user.setTypeNo(2);

		// 이메일 인증 키 넣는 곳
		Map<String, Object> params = new HashMap<>();
		

		
	    this.emailAddress = emailAddress;
	    executorService = Executors.newCachedThreadPool();
	    executorService.submit(this);
	    
		return "redirect:/app/auth/form";
	}


	@Override
	public void run() {
		//이메일 인증 SMTP 서버
	}
}
