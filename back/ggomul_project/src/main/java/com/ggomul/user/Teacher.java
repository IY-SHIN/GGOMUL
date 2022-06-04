package com.ggomul.user;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@Table(name="TEACHER_TB")
@DiscriminatorValue("TEACHER")
@ToString
@NoArgsConstructor
@DynamicInsert
@PrimaryKeyJoinColumn(name = "no")
public class Teacher{
	
	// 강사
	@Column(name="no", insertable=false, updatable=false)
	@Id
	@JoinColumn(name="no")
	private Long teacherNo;
	
	@Column(name = "branch_no")
	private int branchNo; // 지점 번호

	@Column(name = "profile_photo")
	private String profilePhoto; // 프로필사진

	@Column(name = "name_bank")
	private String nameBank; // 은행명

	@Column(name = "account_number")
	private String accountNumber; // 계좌번호

	@Builder
	public Teacher(Long teacherNo, int branchNo, String profilePhoto, String nameBank, String accountNumber) {
		this.teacherNo = teacherNo;
		this.branchNo = branchNo;
		this.profilePhoto = profilePhoto;
		this.nameBank = nameBank;
		this.accountNumber = accountNumber;
	}

	


}
