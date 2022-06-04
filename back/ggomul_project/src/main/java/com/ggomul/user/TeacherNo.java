package com.ggomul.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Embeddable
public class TeacherNo implements Serializable {
	private long userNo; //@MapsId("userNo")로 매핑
	
	@Column(name="no")
	private long teacherNo;
}
