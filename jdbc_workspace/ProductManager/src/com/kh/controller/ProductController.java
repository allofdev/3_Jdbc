package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.ProductService;
import com.kh.model.vo.Product;
import com.kh.view.ProductMenu;

public class ProductController {
	
	/**
	 * 전체 조회 메소드
	 */
	public void selectList() {
		
		ArrayList<Product> list = new ProductService().selectList();
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoData();
		}else {
			new ProductMenu().displayProductList(list);
		}
		
	}
	
	
	public void insertProduct(Product p) {
		
		int result = new ProductService().insertProduct(p);
		
		if(result > 0) {
			new ProductMenu().displaySuccess("상품 추가 성공!");
		}else {
			new ProductMenu().displayFail("상품 추가 실패!");
		}
		
	}
	
	
	public void updateProduct(Product p) {
		
		int result = new ProductService().updateProduct(p);
		
		if(result > 0) {
			new ProductMenu().displaySuccess("[" +p.getProductId() + "] 의 상품 수정 성공!");
		}else {
			new ProductMenu().displayFail("[" +p.getProductId() + "] 의 상품 수정 실패!");
		}
		
	}
	
	public void deleteProduct(String productId) {
		
		int result = new ProductService().deleteProduct(productId);
		
		if(result > 0) {//성공
			new ProductMenu().displaySuccess("[" + productId + "] 의 상품 삭제 성공!");
		}else {//실패
			new ProductMenu().displayFail("상품 삭제 실패!");
		}
		
	}
	
	public void selectListKeyword(String keyword) {
		
		ArrayList<Product> list = new ProductService().selectListKeyword(keyword);
		
		if(list.isEmpty()) {// 데이터 없음
			new ProductMenu().displayNoData();
		}else {//데이터 출력
			new ProductMenu().displayProductList(list);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}