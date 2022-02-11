package model;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.MessageException;
import exception.NotExistException;
import model.DTO.TodoDTO;
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
	
	public static void notExistTodo(String todoId) throws NotExistException, SQLException{
		TodoDTO todo = TodoDAO.getTodo(todoId);
		if(todo == null){
			throw new NotExistException("잘못된 todoId 입니다.");
		}
	}
	
	public static ArrayList<TodoDTO> getAlltodo(int userId) throws SQLException{
		return TodoDAO.getAlltodo(userId);
	}
	
		
	
	public static boolean deleteTodo(String todoId) throws SQLException, NotExistException{
		notExistTodo(todoId);
		boolean result = TodoDAO.deleteTodo(todoId);
		if(!result){
			throw new NotExistException("할 일 삭제 실패");
		}
		return result;
	}
	public static boolean addTodo(TodoDTO todo, int userId) throws MessageException{
		boolean result = false;
		try {
			result = TodoDAO.addTodo(todo, userId);
			
		} catch (SQLException e) {
			throw new MessageException("올바르게 입력하지 않았습니다.");
		}
		return result;
	}
}
