package com.ggomul.join;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ggomul.user.Teacher;

@Repository
public interface JoinTeacherRepository extends JpaRepository<Teacher, Long> {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-sql");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	@Transactional 
	@Modifying
	@Query(value="insert into TEACHER_TB "
			+ "(user_no, branch_no, profile_photo, name_bank, account_number)"
			+ "values (:user_no, :branch_no, :profile_photo, :name_bank, :account_number)", nativeQuery = true)
	void insertTeacher(
			@Param("user_no") Long users, @Param("branch_no") Integer branchNo, @Param("profile_photo") String profilePhoto, 
			@Param("name_bank") String nameBank, @Param("account_number") String accountNumber);
	
	//TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
	
	
}
