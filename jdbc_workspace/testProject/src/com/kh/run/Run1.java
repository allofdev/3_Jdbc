package com.kh.run;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Run1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		
		/*
		 * java.sql 에 있는것들
		 * 
		 * * JDBC용 객체(다 쓰면 자원반납 해야됨)
		 * - Connection : DB의 연결정보를 담는객체
		 * - [Prepared]Statement : DB에 SQL문을 전달해서 실행하고 그 결과를 받아내는 객체
		 * 			> Statement         : 실행시킬 sql문 완성형태여야됨
		 *          > PreparedStatement : 실행시킬 sql문을 미완성상태로 둬도됨
		 * - ResultSet : Select문 수행 후 조회된 결과가 담겨있는 객체
		 */
		
		// insert문 할거임!!!    => 결과: 처리된 행 수(int)
		// 필요한 변수들 먼저 셋팅
		int result = 0; // 처리된 결과(처리된 행 수)를 받아줄 변수
		// DB의 연결정보를 담는 객체(Connection) 선언
		Connection conn = null;
		// SQL문 실행 및 결과 받는 객체(Statement) 선언
		Statement stmt = null;
		
		// 실행할 SQL문 (완성형태로!!!!!!!)
		// INSERT INTO TEST VALUES('강보람', 20 '서울시 관악구') => 마지막에 세미콜론은 없어야됨!!!
		
		String sql = "INSERT INTO TEST VALUES('" + name + "', " + age + ", '" + address +  "')";
		//System.out.println(sql); --> 잘 입력했는지 확인해봄
		
		
		try {			
			// 1) jdbc driver 등록 : DBMS가 제공하는 걸로 등록 --> oracle, mysql 등등 있음 --> 나는 oracle
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			// ClassNotFoundException : ojdbc6.jar 추가했는지 확인해볼것
			//                          오타없는지 확인해볼 것
			
			// 2) Connection 객체 생성(DB에 연결 --> url, 계정명, 계정비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			                                                  //      |                계정명      비밀번호
															  //  각자 본인 pc : 1)127.0.0.1   2)localhost
			
			// 3) Statement 객체 생성 (SQL문 실행용)
			stmt = conn.createStatement();
			
			// 4) sql문 실행(DML문 : executeUpdate메소드  /  SELECT문 : executeQuery메소드)
			// 5) 결과 받기
			result = stmt.executeUpdate(sql);
			
			// 6) 트랜잭션 처리
			if(result > 0) {
				conn.commit(); // commit처리
			}else {
				conn.rollback(); // rollback처리
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 7) 다 쓴 자원 반납(생성된 역순으로) -- 예외가 발생해도 무조껀 반납해야됨
			try {
				stmt.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		if(result > 0) { // 성공일 경우
			System.out.println("잘 추가되었습니다.");
		}else { // 실패일 경우
			System.out.println("제대로 추가가 안되었습니다.");
		}
		
		
	}
}
