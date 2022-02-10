package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			System.out.println(con);
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
}
