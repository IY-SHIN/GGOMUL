package com.ggomul.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j2;

//Runner 클래스(테스트 메소드를 실행하는 클래스)를 SpringJUnit4ClassRunner로 실행
@RunWith(SpringRunner.class)
//location 속성 경로에 있는 xml 파일을 이용해서 스프링이 로딩됨
@ContextConfiguration(locations="/spring/dataSource.xml")
@Log4j2
public class DataSourceTest {

	// DataSource의 객체를 new를 사용해 따로 생성해줄 필요없이 스프링이 생성해서 주입해줌
	@Inject
	private DataSource dataSource;

	@Test
	public void testFactory() {
		log.debug(dataSource);
	}
	
	@Test
	public void testSession() throws Exception {
		try (Connection con = dataSource.getConnection()) {
			log.debug("연결 성공!");
			log.debug(con);
		} catch (Exception e) {
			log.debug("연결 실패!");
			e.printStackTrace();
		}
	}
}
