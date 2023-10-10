package kr.ch07.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User6DTO {
	private String uid;
	private String name;
	private String birth;
	private String gender;
	private int age;
	private String addr;
	private String hp;

	public String getGenderString() {
		return gender.equals("M") ? "남자" : "여자";
	}
}