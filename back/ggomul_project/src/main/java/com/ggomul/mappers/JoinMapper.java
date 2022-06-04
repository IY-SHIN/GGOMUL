package com.ggomul.mappers;

import java.util.Map;
import java.util.Optional;

import com.ggomul.user.Teacher;
import com.ggomul.user.User;

public interface JoinMapper {
	int insert(User user) throws Exception;
	int teacherInsert(Map<String, Object> params) throws Exception;
	public Optional<Teacher> findByEmail(String email);
}
