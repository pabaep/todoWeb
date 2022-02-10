package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DTO.UserDTO;
import model.util.DBUtil;

public class UserDAO {
	public static boolean addUser(UserDTO user) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			System.out.println("DAO");
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into userT values(seq_user_id.NEXTVAL, ?, ?, ?)");
			pstmt.setString(1, user.getUserEmail());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPw());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static UserDTO login(String userEmail, String userPw) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UserDTO user = null;
		try{
			System.out.println("DAO");
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select userId, userEmail, userName from userT where userEmail=? and userPw=?");
			pstmt.setString(1, userEmail);
			pstmt.setString(2, userPw);
			
			rset = pstmt.executeQuery();
			if(rset.next()){
				user = new UserDTO(Integer.parseInt(rset.getString(1)), rset.getString(2), rset.getString(3));
			}

		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return user;
	}
	
}
