package com.ggomul.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@Table(name="TEACHER_TB")
@ToString
@NoArgsConstructor
@DynamicInsert
@Data
@SequenceGenerator(
	    name = "TEACHER_TB_TEACHER_NO",        // 해당 generator 이름입니다.
	    sequenceName = "SEQ_TEACHER_TB_TEACHER_NO",          // generator가될 DB 테이블명입니다.
	    initialValue = 1, allocationSize = 1 // 초기값과 할당 사이즈입니다.
	)

public class Teacher implements Serializable{
	
	// 강사
	@Id //PK값을 의미
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "TEACHER_TB_TEACHER_NO")
	@Column(name="teacher_no", insertable=false, updatable=false)
	private Long teacherNo; // 회원 번호(PK)
	
    
	@Column(name="user_no")
	private Long userNo;
	
	@Column(name = "branch_no")
	private int branchNo; // 지점 번호

	@Column(name = "profile_photo")
	private String profilePhoto; // 프로필사진

	@Column(name = "name_bank")
	private String nameBank; // 은행명

	@Column(name = "account_number")
	private String accountNumber; // 계좌번호

	

}
