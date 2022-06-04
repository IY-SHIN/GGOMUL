package com.ggomul.mappers;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
	@Autowired
	private SqlSession sqlSessionTemplate;
	
	public int teacherInsert(Map<String, Object> params) throws Exception{
		return sqlSessionTemplate.insert("com.ggomul.mappers.UserMapper.teacherInsert", params);
	}
}
