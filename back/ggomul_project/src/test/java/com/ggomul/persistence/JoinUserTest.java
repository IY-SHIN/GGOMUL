package com.ggomul.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ggomul.config.RootContext;
import com.ggomul.join.JoinService;
import com.ggomul.join.JoinTeacherRepository;
import com.ggomul.join.JoinUserRepository;
import com.ggomul.user.Teacher;
import com.ggomul.user.User;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//location 속성 경로에 있는 xml 파일을 이용해서 스프링이 로딩됨
@RunWith(SpringRunner.class)
@Slf4j
@WebAppConfiguration
@ContextConfiguration(classes = RootContext.class)
public class JoinUserTest {
	@Autowired
	JoinTeacherRepository joinTeacherRepository;
	@Autowired
	JoinUserRepository joinUserRepository;

	// 회원가입 테스트
	@Test
	public void insert() throws Exception {
//		LocalDateTime date = LocalDateTime.now();  
		Date date = new java.sql.Date(System.currentTimeMillis());
		System.out.println("####################" + date);
		
//		joinUserRepository.insertUser(1, "인", "qmffo11r222", "a1234", "0102023055", "F", "911121", "서구", "인천", date);

//		//given
//		User user1=User.builder()
//				.typeNo(1)
//				.name("인")
//				.email("qmffo11r2")
//				.password("a1234")
//				.tel("0102023053")
//				.dateBirth("911121")
//				.gender("F")
//				.address("인천")
//				.detailAddress("서구")
//				.signDt(date).build();
		
		// when
//		user1 = joinUserRepository.save(user1);
		
		Optional<User> test2 = joinUserRepository.selectUser();
		System.out.println("###########     "+test2.toString());
		
//		List<Object[]> test = joinUserRepository.selectUser();		
//		for(Object[] user : test) {
//			System.out.println("###########     ["+user+"]");
//			
//		}
//		Optional<User> user = joinUserRepository.findById(4l);
		
//		Teacher teacher=
//				Teacher.builder()
//				.teacherNo(user1.getUserNo()+1)
//				.branchNo(10)
//				.profilePhoto("123")
//				.nameBank("우리")
//				.accountNumber("123").build();
//		
//		teacher = joinTeacherRepository.save(teacher);
//
//		List<User> test2 = joinUserRepository.findAll();
//		System.out.println("##########\n" + test2);
//		
//		List<Teacher> test1 = joinTeacherRepository.findAll();
//		System.out.println("#########\n" + test1);

		// then
//		assertThat(user1.getUserNo()).isNotNull();
	}

}
