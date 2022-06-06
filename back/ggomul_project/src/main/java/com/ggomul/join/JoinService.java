package com.ggomul.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggomul.mappers.UserMapper;
import com.ggomul.user.User;

@Service
public class JoinService {
	private final JoinUserRepository joinuserRepository;
	private final UserMapper userMapper;
	
	@Autowired
	public JoinService(JoinUserRepository joinuserRepository, UserMapper userMapper) {
		this.joinuserRepository = joinuserRepository;
		this.userMapper = userMapper;
	}
	
}
