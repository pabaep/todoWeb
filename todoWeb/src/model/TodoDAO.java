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
	
	public static ArrayList<TodoDTO> getAlltodo() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TodoDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from todoT");
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

}
