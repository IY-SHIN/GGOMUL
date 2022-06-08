package com.ggomul.join;

import java.sql.Date;
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

import com.ggomul.user.User;

@Repository
public interface JoinUserRepository extends JpaRepository<User, Long> {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-sql");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	@Transactional
	@Modifying
	@Query(value="insert into USER_TB "
			+ "(type_no, name, email, password, tel, date_birth, gender, address, detail_address, sign_dt)"
			+ "values (:type_no, :name, :email, :password, :tel, :date_birth, :gender, :address, :detail_address, :sign_dt)", nativeQuery = true)
	void insertUser(
			@Param("type_no") Integer type_no, @Param("name") String name, 
			@Param("email") String email, @Param("password") String password, 
			@Param("tel") String tel, @Param("gender") String gender, @Param("date_birth") String dateBirth, 
			@Param("address") String address, @Param("detail_address") String detailAddress, @Param("sign_dt") Date signDt);
//	@Query(value="insert into USER_TB "
//			+ "(type_no, name, email, password, tel, dateBirth, gender, address, detailAddress, signDt, resign, emailConfirm, activateKey)"
//			+ "values (:type_no, :name, :email, :password, :tel, :dateBirth, :gender, :address, :detailAddress, :signDt, :resign, :emailConfirm, :activateKey)", nativeQuery = true)
//	void insertUser(
//			@Param("type_no") Integer type_no, @Param("name") String name, 
//			@Param("email") String email, @Param("password") String password, 
//			@Param("tel") String tel, @Param("dateBirth") String dateBirth, 
//			@Param("detailAddress") String detailAddress, @Param("signDt") LocalDateTime signDt, 
//			@Param("resign") String resign, @Param("emailConfirm") Boolean emailConfirm,
//			@Param("activateKey") Boolean activateKey);
	
	//TypedQuery<User> query = em.createQuery("SELECT m FROM User m", User.class);
	
	@Transactional
	@Modifying
    @Query(value = "select user_no from User")
	public List<Long> findId(@Param("user_no") Long user_no);
}
