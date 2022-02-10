package model;

import java.sql.SQLException;

import exception.MessageException;
import model.DTO.UserDTO;

public class TodoService {
	//User - CRUD
	public static boolean addUser(UserDTO user) throws MessageException{
		boolean result = false;
		try {
			result = UserDAO.addUser(user);
			
		} catch (SQLException e) {
			throw new MessageException("올바르게 입력하지 않았습니다.");
		}
		return result;
	}
	public static UserDTO login(String userEmail, String userPw) throws MessageException {
		UserDTO result = null;
		
		try {
			result = UserDAO.login(userEmail, userPw);
		} catch (SQLException e) {
			throw new MessageException("이메일 혹은 비밀번호가 잘못 입력되었습니다.");
		}
		
		return result;
	}
}
