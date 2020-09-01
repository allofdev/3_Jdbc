package com.kh.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	// 이 클래스에서의 모든 메소드들 다 static 메소드
	// 싱클톤 패턴 : 메모리 영역에 단 한번만 올라간거 재사용하는 개념
	
	
	// 1. Connection 객체 생성해서(즉, DB연결된) 반환시켜주는 메소드	
	public static Connection getConnection() {
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("resources/driver.properties"));
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		Connection conn = null;
		
		try {
			/*
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			*/
			
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), 
					                           prop.getProperty("username"), 
					                           prop.getProperty("password"));
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	
	// 2. 전달받은 Connection 객체를 가지고 commit시켜주는 메소드
	public static void commit(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 3. 전달받은 Connection 객체를 가지고 rollback시켜주는 메소드
	public static void rollback(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 4. 전달받은 Connection객체 close해주는 메소드
	public static void close(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	// 5. 전달받은 Statement관련객체 close해주는 메소드
	public static void close(Statement stmt) {// 오버로딩!!! :  매게 변수가 다르면 메소드명 상관없음!!!
											  // 다형성!!!   :  Statement가 PreparedStatement의 부모 클래스임!! 즉, Statement로 둘 다 가능
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 6. 전달받은 ResultSet 객체 close해주는 메소드
	public static void close(ResultSet rset) {
		
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
}
