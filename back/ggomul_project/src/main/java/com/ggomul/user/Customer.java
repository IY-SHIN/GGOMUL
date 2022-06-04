package com.ggomul.user;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;

@Getter
@Entity
@DiscriminatorValue("CUSTOMER")
@PrimaryKeyJoinColumn(name = "no")
public class Customer extends User {
	// 회원
	@Column(unique = true)
	private String nickname; // 회원 닉네임
	
}
