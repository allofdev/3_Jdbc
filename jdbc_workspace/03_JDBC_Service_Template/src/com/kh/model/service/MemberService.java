package com.kh.model.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;

//import com.kh.common.JDBCTemplate;
import static com.kh.common.JDBCTemplate.*; //-> 일일이 JDBCTemplate클래스 입력안해도 됨

// Service : DB와 연결시키는 Connection 객체 생성 후
//           DAO 호출(이때, 여기서 생성된Connection 객체 전달값을 같이 넘겨줄꺼임!)
//           반환받은 결과(만일, result가 반환되었을 경우 트랜잭션처리도 할꺼임)
public class MemberService {

	
	public int insertMember(Member m) {
		
		// 필요한 변수 셋팅
		
		/*
		int result = 0;
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			result = new MemberDao().insertMember(conn, m);	
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		*/
		Connection conn = getConnection();
		int result = new MemberDao().insertMember(conn, m);
		
		
		// 트랜잭션 처리도 예외처리해야함
		/*
		if(result > 0) {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.commit();				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		// 다쓴 자원반납
		/*
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		close(conn);
		
		
		return result;
		
	}
	
	
	public ArrayList<Member> selectList() {
		
		
		/*
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDribver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhot:1521:xe", "JDBC", "JDBC");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		Connection conn = getConnection();
		
	 	ArrayList list = new MemberDao().selectList(conn);
		
	 	// Connection객체 반납
		close(conn);
		
		return list;
		
	}
	
	
	public Member selectByUserId(String userId) {
		
		Connection conn = getConnection();
		
		Member m = new MemberDao().selectByUserId(conn, userId);
		
		close(conn);
		
		return m;
		
	}
	
	
	public ArrayList<Member> selectByUserName(String keyword) {
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new MemberDao().selectByUserName(conn, keyword);
		
		close(conn);
		
		return list;
		
	}
	
	
	
	// 이거는 JDBCTemplate 사용하지 않고 해봄
	public int updateMember(Member m) {
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int result = new MemberDao().updateMember(conn, m);
		
		
		// 트랜잭션 처리
		if(result > 0) {
			
					try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
					
		}else {
			
				try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		}
		
		// 반납
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public int deleteMember(String userId) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId);
		
		//트랜잭션처리
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		//반납
		close(conn);
		
		return result;
		
	}
	
	
	
	
	
	
	
	
}
