package model;

import java.sql.SQLException;

import exception.MessageException;
import model.DTO.UserDTO;

public class TodoService {
	//User - CRUD
	public static boolean addUser(UserDTO user) throws MessageException{
		boolean result = false;
		try {
			System.out.println("서비스");
			result = UserDAO.addUser(user);
			
		} catch (SQLException e) {
			throw new MessageException("올바르게 입력하지 않았습니다.");
		}
		return result;
	}
}
