package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.kh.model.vo.Member;

//import com.kh.common.JDBCTemplate;
import static com.kh.common.JDBCTemplate.*; //-> 일일이 JDBCTemplate클래스 입력안해도 됨


public class MemberDao {

	
	
	public int insertMember(Connection conn, Member m) {
		// insert문 => 처리된 행수(int)
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";

		try {
			
			pstmt = conn.prepareStatement(sql); // 미완성 sql문 => 바로실행(executeXXX) 불가 => 완성형태로 만든 후 실행
			
			// 미완성 sql => 완성형태로
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			
			// 실행
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
				
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			
			// 다쓴 자원반납
			/*
			try {
				if(pstmt != null && !pstmt.isClosed()) { // NullPointerException 방지차원
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			*/
			close(pstmt);
		
		}
		
		return result;
		
	}
	
	
	public ArrayList<Member> selectList(Connection conn) {
		// select문 => ResultSet (여러행)
		
		ArrayList<Member> list = new ArrayList<>();
		
		ResultSet rset = null;
		
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM MEMBER";
		
		try {
			pstmt = conn.prepareStatement(sql); // 완성된sql문 -> 완성되었기때문에 바로실행
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
							
				list.add(new Member(rset.getInt("USERNO"),
						   rset.getString("USERID"),
						   rset.getString("USERPWD"),
						   rset.getString("USERNAME"),
						   rset.getString("GENDER"),
						   rset.getInt("AGE"),
					       rset.getString("EMAIL"),
						   rset.getString("PHONE"),
						   rset.getString("ADDRESS"),
						   rset.getString("HOBBY"),
						   rset.getDate("ENROLLDATE")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*
			try {
				if(rset != null && !rset.isClosed()) {
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			*/
			close(rset);
			
			/*
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			*/
			close(pstmt);
			
		}
		
		return list;
		
	}
	
	
	public Member selectByUserId(Connection conn, String userId) {
		// Select문 => ResultSet (한 행)
		
		Member m = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				m = new Member(rset.getInt("USERNO"),
						       rset.getString("USERID"),
						       rset.getString("USERPWD"),
						       rset.getString("USERNAME"),
						       rset.getString("GENDER"),
						       rset.getInt("AGE"),
						       rset.getString("EMAIL"),
						       rset.getString("PHONE"),
						       rset.getString("ADDRESS"),
						       rset.getString("HOBBY"),
						       rset.getDate("ENROLLDATE"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
	}
	
	public ArrayList<Member> selectByUserName(Connection conn, String keyword) {
		// select문 => ResultSet (여러 행)
		
		ArrayList<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE '%' || ? || '%'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("USERNO"),
						            rset.getString("USERID"),
						            rset.getString("USERPWD"),
						            rset.getString("USERNAME"),
						            rset.getString("GENDER"),
						            rset.getInt("AGE"),
						            rset.getString("EMAIL"),
								    rset.getString("PHONE"),
								    rset.getString("ADDRESS"),
								    rset.getString("HOBBY"),
								    rset.getDate("ENROLLDATE")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	
	public int updateMember(Connection conn, Member m) {
		// update문 -> result -> 트랜잭션 처리
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER SET USERPWD = ?, EMAIL = ?, PHONE = ?, ADDRESS = ? WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
		
		
	}
	
	public int deleteMember(Connection conn, String userId) {
		// delete문 -> result(int) -> 트랜잭션 처리
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
