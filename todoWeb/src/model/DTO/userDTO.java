/**
CREATE TABLE userT (
       userId          	number  PRIMARY KEY seq,
       userEmail        VARCHAR2(20) NOT NULL,
       userName        	VARCHAR2(20) NOT NULL,
       userPw           VARCHAR2(20) NOT NULL
); */
package model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class userDTO {
	private int userId;
	private String userEmail;
	private String userName;
	private String userPw;
	
	
	
	@Override
	public String toString() {
		return "userDTO [userId=" + userId + ", userEmail=" + userEmail + ", userName=" + userName + ", userPw="
				+ userPw + "]";
	}


	//회원가입
	public userDTO(String userEmail, String userName, String userPw) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPw = userPw;
	}


	//로그인
	public userDTO(String userEmail, String userPw) {
		super();
		this.userEmail = userEmail;
		this.userPw = userPw;
	}
	
	
}


