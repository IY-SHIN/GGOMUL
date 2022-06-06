package com.ggomul.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggomul.join.JoinService;
import com.ggomul.user.User;

@RequestMapping(value = "/users")
@RestController
public class JoinController {
private final JoinService joinService;
	
	@Autowired
	public JoinController(JoinService joinService) {
		this.joinService = joinService;
	}
	
	@PostMapping("")
	public Map<String, Object> save(@RequestBody User user) {
		Map<String, Object> response = new HashMap<>();
		
		if(user != null) {
			response.put("result", "SUCCESS");
			response.put("user", user);
		} else {
			response.put("result", "FAIL");
			response.put("reason", "회원 가입 실패");
		}
		
		return response;
	}
}
