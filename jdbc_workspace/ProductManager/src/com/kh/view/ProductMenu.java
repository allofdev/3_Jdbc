package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;
import com.kh.controller.ProductController;
import com.kh.model.vo.Product;

public class ProductMenu {

	private Scanner sc = new Scanner(System.in);
	private ProductController pc = new ProductController();
	
	
	public void mainMenu() {
		
		while(true) {
			
			System.out.println("\n제품 관리 프로그램");
			System.out.println("1. 전체 조회 하기");
			System.out.println("2. 상품 추가 하기");
			System.out.println("3. 상품 수정 하기 (상품id로 조회하고 수정)");
			System.out.println("4. 상품 삭제 하기 (상품id로 조회하고 삭제)");
			System.out.println("5. 상품 검색 하기 (상품 이름으로 키워드 검색)");
			System.out.println("0. 프로그램 종료하기");
			
			System.out.print("메뉴를 선택해 주세요 : ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: pc.selectList(); break;
			case 2: insertProduct(); break;
			case 3: updateProduct(inputProductId()); break;
			case 4: pc.deleteProduct(inputProductId()); break;
			case 5: pc.selectListKeyword(inputProductName()); break;
			case 0: System.out.println("프로그램을 종료합니다."); return;
			}
			
		}
		
	}
	
	

	public void insertProduct() {
		
		System.out.println("\n==== 상품 추가 ====");
		System.out.print("상품 아이디 : ");
		String productId = sc.nextLine();
		System.out.print("상품명 : ");
		String pName = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("상품상세정보 : ");
		String description = sc.nextLine();
		System.out.print("재고 : ");
		int stock = sc.nextInt();
		sc.nextLine();
		pc.insertProduct(new Product(productId, pName, price, description, stock));
		
	}
	
	
	public String inputProductId() {
		System.out.print("상품 아이디 : ");
		return sc.nextLine();
	}
	
	
	public void updateProduct(String productId) {
		
		System.out.println("\n==== [" + productId + "] 의 상품 수정 ====");
		System.out.print("상품명 : ");
		String pName = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("상품상세정보 : ");
		String description = sc.nextLine();
		System.out.print("재고 : ");
		int stock = sc.nextInt();
		sc.nextLine();
		
		pc.updateProduct(new Product(productId, pName, price, description, stock));
		
	}
	
	public String inputProductName() {
		System.out.print("상품명 : ");
		return sc.nextLine();
	}
	
	
	
	
	
	
	
	//--------------------------- 출력 화면 ----------------------------------
	
	/**
	 * 데이터 없음 출력 화면
	 */
	public void displayNoData() {
		System.err.println("\n데이터가 존재하지 않습니다.");
	}
	
	
	/**
	 * list 결과 출력 화면
	 * @param list
	 */
	public void displayProductList(ArrayList<Product> list) {
		System.out.println();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	/**
	 * 성공 화면
	 * @param result
	 */
	public void displaySuccess(String result) {
		System.out.println("성공 화면 : " + result);
	}
	
	/**
	 * 실패 화면
	 * @param result
	 */
	public void displayFail(String result) {
		System.err.println("실패 화면 : " + result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
