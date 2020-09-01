package com.kh.model.service;

import static com.kh.common.JDBCTemplate.getConnection;
import java.sql.Connection;
import java.util.ArrayList;

import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;
import static com.kh.common.JDBCTemplate.*;


public class ProductService {

	public ArrayList<Product> selectList() {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new ProductDao().selectList(conn);
		
		close(conn);
		
		return list;
		
	}
	
	
	public int insertProduct(Product p) {
		
		Connection conn = getConnection();
		
		int result = new ProductDao().insertProduct(conn, p);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int updateProduct(Product p) {
		
		Connection conn = getConnection();
		
		int result = new ProductDao().updateProdcut(conn, p);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int deleteProduct(String productId) {
		
		Connection conn = getConnection();
		
		int result = new ProductDao().deleteProduct(conn, productId);
		
		//트랜잭션 처리
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	
	public ArrayList<Product> selectListKeyword(String keyword) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new ProductDao().selectListKeyword(conn, keyword);
		
		close(conn);
		
		return list;
		
	}
	
	
	
	
	
}
