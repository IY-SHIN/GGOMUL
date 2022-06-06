package com.ggomul.persistence;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ggomul.config.RootContext;
import com.ggomul.join.JoinTeacherRepository;
import com.ggomul.join.JoinUserRepository;
import com.ggomul.user.Teacher;
import com.ggomul.user.User;

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

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-sql");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			/*
			 * User m = new User(); m=User.builder() .typeNo(1) .name("인")
			 * .email("qmffo311r25") .password("a1234") .tel("01020230143")
			 * .dateBirth("911121") .gender("F") .address("인천") .detailAddress("서구")
			 * .signDt(date).build();
			 */
			joinUserRepository.insertUser(1, "인", "21ass2", "a12314", "0121232883", "F", "911121", "서구", "인천", date);
			em.persist(joinUserRepository); // persist == save
			tx.commit();

			

//			Teacher a = new Teacher();
//			a.getUsers().getUser_no();
//
//			joinTeacherRepository.insertTeacher(10, "qwer", "우리", "12345");
//			em.persist(joinTeacherRepository); // persist == save

		} catch (Exception e) {
			tx.rollback();
		} finally {

		}

		List<Long> id = joinUserRepository.findId(5L);
		System.out.println("#########################################@@@@@@@@@@@@@@" + id);
		
		Long lastNo = null;
		if(!id.isEmpty()) {
			lastNo = id.get(id.size()-1);
		}
		System.out.println("##########################" + lastNo);
		
		try {
			/*
			 * User m = new User(); m=User.builder() .typeNo(1) .name("인")
			 * .email("qmffo311r25") .password("a1234") .tel("01020230143")
			 * .dateBirth("911121") .gender("F") .address("인천") .detailAddress("서구")
			 * .signDt(date).build();
			 */

			joinTeacherRepository.insertTeacher(lastNo, 10, "qwer", "우리", "12345");
			em.persist(joinTeacherRepository); // persist == save

		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
		// when
//		user1 = joinUserRepository.save(user1);

//		List<User> test2 = joinUserRepository.findUser(3L);
//		System.out.println("###########     "+test2.toString());

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
