package com.ggomul.join;


import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ggomul.user.Teacher;
import com.ggomul.user.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JoinDto {
	@NotBlank
	@Pattern(regexp = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$")
	private String email;
	
	@JsonIgnore
    @NotBlank
    @Size(min = 4, max = 15)
	private String password;
	
	@NotBlank
	@Size(min = 6, max = 10)
	private String name;
	
	
}
