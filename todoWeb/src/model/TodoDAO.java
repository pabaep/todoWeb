package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DTO.TodoDTO;
import model.util.DBUtil;

public class TodoDAO {
	
	public static TodoDTO getTodo(String todoId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		TodoDTO todo = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from todoT where todoId=?");
			pstmt.setString(1, todoId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				todo = new TodoDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return todo;
	}
	
	public static boolean deleteTodo(String todoId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from todoT where todoId=?");
			pstmt.setString(1, todoId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static ArrayList<TodoDTO> getAlltodo(int userId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TodoDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from todoT where userId=?");
			pstmt.setString(1, Integer.toString(userId));
			rset = pstmt.executeQuery();
			
			list = new ArrayList<TodoDTO>();
			while(rset.next()){
				list.add(new TodoDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	public static boolean addTodo(TodoDTO todo, int userId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into  todoT values(seq_todo_id.NEXTVAL, ?, ?, ?,?)");
			pstmt.setString(1, todo.getTodoContent());
			pstmt.setString(2, todo.getTodoStart());
			pstmt.setString(3, todo.getTodoEnd());
			pstmt.setString(4, Integer.toString(userId));
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean updateContent(String todocontent, int todoId, int userId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update todoT set todoContent=? where todoId=? AND where userId = ?");
			pstmt.setString(1, todocontent);
			pstmt.setInt(2, todoId);
			pstmt.setInt(3, userId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean updateTodoStart(String todoStart, int todoId, int userId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update todoT set todoStart=? where todoId=? AND where userId = ?");
			pstmt.setString(1, todoStart);
			pstmt.setInt(2, todoId);
			pstmt.setInt(3, userId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean updateTodoEnd(String todoEnd, int todoId, int userId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update todoT set todoEnd=? where todoId=? AND where userId = ?");
			pstmt.setString(1, todoEnd);
			pstmt.setInt(2, todoId);
			pstmt.setInt(3, userId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
}
