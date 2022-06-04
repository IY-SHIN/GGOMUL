package com.ggomul.join;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggomul.user.Teacher;

public interface JoinTeacherRepository extends JpaRepository<Teacher, Long> {
}
