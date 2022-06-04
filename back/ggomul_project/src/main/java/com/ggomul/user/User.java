package com.ggomul.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Entity
@Table(name="USER_TB")
@Inheritance(strategy = InheritanceType.JOINED) //상속으로 조인
@DiscriminatorColumn(name = "DTYPE") //구분 컬럼
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@DynamicInsert
@SequenceGenerator(
	    name = "USER_TB_NO",        // 해당 generator 이름입니다.
	    sequenceName = "SEQ_USER_TB_NO",          // generator가될 DB 테이블명입니다.
	    initialValue = 1, allocationSize = 1 // 초기값과 할당 사이즈입니다.
	)
@SuperBuilder
public class User{
	//private Teacher teacher;
	//private Customer customer;
	//private UserType memberType;

	// 공통
	@Id //PK값을 의미
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "USER_TB_NO")
	@Column(name="no", insertable=false, updatable=false)
	private Long userNo; // 회원 번호(PK)
	
	@ManyToOne
	@JoinColumn(name="no", insertable=false, updatable=false)
	private Teacher teacher;
	
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
	
	
	@Column(name = "sign_dt")
	private LocalDateTime signDt; // 가입날짜
	
	
	@Column(columnDefinition = "varchar2(1) DEFAULT 'N'")
	private String resign; // 탈퇴여부
	
	@Column(name = "email_confirm", columnDefinition = "varchar2(1) DEFAULT '0'")
	private boolean emailConfirm; // 이메일 인증 여부
	
	@Column(name = "activate_key", columnDefinition = "varchar2(1) DEFAULT '0'")
	private boolean activateKey; // 활성화 상태 여부

	
	public User(Long userNo, int typeNo, String name, String email, String password, String tel, String dateBirth,
			String gender, String address, String detailAddress, LocalDateTime signDt) {
		this.userNo = userNo;
		this.typeNo = typeNo;
		this.name = name;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.dateBirth = dateBirth;
		this.gender = gender;
		this.address = address;
		this.detailAddress = detailAddress;
		this.signDt = signDt;
	}

	

	
}


