package com.kh.run;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Run {

	public static void main(String[] args) {
		
		// Properties => Map 계열의 컬렉션 (key+vlaue 세트로)
		// 자식               부모
		
		// 특징 : key값, value값 모두다 String(문자열)!!
		//       외부파일(.properties) 파일로 출력 가능 또는 파일에 기술된거 통째로 가져오는것도 가능
		
		Properties prop = new Properties();
		
		//prop.setProperty("List", "ArrayList"); // key, value
		//prop.setProperty("Map", "HashMap");
		
		//System.out.println(prop);
		
		try {
			prop.load(new FileReader("resources/test.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop);
		
		System.out.println(prop.getProperty("Create"));
		System.out.println(prop.getProperty("Read"));
		
	}
}
