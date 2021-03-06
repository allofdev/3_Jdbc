package com.kh.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Product;
import static com.kh.common.JDBCTemplate.*;



public class ProductDao {
	
	
	private Properties prop = new Properties(); // 빈 prop 상태
	
	// 사용자가 어떤 서비스 요청할 때 마다 매번 new MemberDao().xxxx(); 호출
	// 즉, 이 기본생성자를 매번 호출함!!
	public ProductDao() {
		
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public ArrayList<Product> selectList(Connection conn) {
		// select문 -> ResultSet (여러 행)
		
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Product(rset.getString("PRODUCT_ID"),
						             rset.getString("P_NAME"),
						             rset.getInt("PRICE"),
						             rset.getString("DESCRIPTION"),
						             rset.getInt("STOCK")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	
	
	public int insertProduct(Connection conn, Product p) {
		// insert문 -> result(int) -> 트랜잭션처리
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getProductId());
			pstmt.setString(2, p.getpName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
			pstmt.setInt(5, p.getStock());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	public int updateProdcut(Connection conn, Product p) {
		// update문 => result(int) -> 트랜잭션 처리
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getpName());
			pstmt.setInt(2, p.getPrice());
			pstmt.setString(3, p.getDescription());
			pstmt.setInt(4, p.getStock());
			pstmt.setString(5, p.getProductId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	public int deleteProduct(Connection conn, String productId) {
		// delete문 => result(int) => 트랜잭션 처리
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteProduct");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productId);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public ArrayList<Product> selectListKeyword(Connection conn, String keyword) {
		// select문 => ResultSet(여러 행)
		
		//필요한 변수
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListKeyword");
		
		// pstmt
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Product(rset.getString("PRODUCT_ID"),
						             rset.getString("P_NAME"),
						             rset.getInt("PRICE"),
						             rset.getString("DESCRIPTION"),
						             rset.getInt("STOCK")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
}
