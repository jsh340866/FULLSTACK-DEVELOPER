package Ch04;

import java.util.ArrayList;
import java.util.List;

public class C01ListMain중요 {
	
	public static void main(String[] args) {
//		List<String> list = new ArrayList(); 
		List<String> list = new ArrayList<String>();
		
		//추가
		list.add("HTML/CSS/JS");
		list.add("NODEJS");
		list.add("SCSS");
		list.add("REACT");
		list.add("JAVA");
		list.add("JSP/SERVLET");
		list.add("SYS");
		list.add("SPRING BOOT");
		
		//조회
		System.out.println("개수 확인 : " +  list.size());
		System.out.println("idx로 조회 : " +  list.get(2));
		System.out.println("Value로 idx 확인 : " +  list.indexOf("JAVA"));
		System.out.println("-------------");
		//전체 조회
//		list.forEach((el)->{System.out.println(el);}); // 원문
//		list.forEach(el->System.out.println(el));	// 생략
		list.forEach(System.out::println); // 최종 생략
		
		//삭제
		list.remove(0);
		list.remove("REACT");
		System.out.println("-------------");
		list.forEach(System.out::println);
		//전체삭제
		list.clear();
		
		
	}
}
