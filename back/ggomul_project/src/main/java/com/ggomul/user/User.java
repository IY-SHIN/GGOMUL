package com.ggomul.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Getter
@Entity
@Table(name="USER_TB")
//@Inheritance(strategy = InheritanceType.JOINED) //상속으로 조인
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@DynamicInsert
@SequenceGenerator(
	    name = "USER_TB_USER_NO",        // 해당 generator 이름입니다.
	    sequenceName = "SEQ_USER_TB_USER_NO",          // generator가될 DB 테이블명입니다.
	    initialValue = 1, allocationSize = 1 // 초기값과 할당 사이즈입니다.
	)
public class User implements Serializable{
	// 공통
	@Id //PK값을 의미
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "USER_TB_USER_NO")
	@Column(insertable=false, updatable=false)
	private Long user_no; // 회원 번호(PK)
	
	@Column(name = "type_no")
	private int typeNo; // 회원 분류
	
	@Column(name="name")
	private String name; // 이름
	
	@Column(unique = true)
	private String email; // 이메일(ID)
	
	private String password; // 비밀번호
	
	@Column(unique = true)
	private String tel; // 휴대폰번호
	
	@Column(name = "date_birth")
	private String dateBirth; // 생년월일
	
	private String gender; // 성별
	
	private String address; // 주소
	
	@Column(name = "detail_address")
	private String detailAddress; // 상세주소
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sign_dt")
	private Date signDt; // 가입날짜
	
	
	@Column(columnDefinition = "varchar2(1) DEFAULT 'N'")
	private String resign; // 탈퇴여부
	
	@Column(name = "email_confirm", columnDefinition = "varchar2(1) DEFAULT '0'")
	private boolean emailConfirm; // 이메일 인증 여부
	
	@Column(name = "activate_key", columnDefinition = "varchar2(1) DEFAULT '0'")
	private boolean activateKey; // 활성화 상태 여부

	
}


