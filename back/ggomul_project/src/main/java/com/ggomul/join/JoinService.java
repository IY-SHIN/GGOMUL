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
	
	@Transactional
	public User save(User user) {
		User user1=User.builder()
				.typeNo(user.getTypeNo())
				.name(user.getName())
				.email(user.getEmail())
				.password(user.getPassword())
				.tel(user.getTel())
				.dateBirth(user.getDateBirth())
				.gender(user.getGender())
				.address(user.getAddress())
				.detailAddress(user.getDetailAddress())
				.signDt(user.getSignDt()).build();
		
		return joinuserRepository.save(user);
	}
}
