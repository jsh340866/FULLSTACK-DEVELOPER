package Ch04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class C04Ex {

	public static void main(String[] args) {
		//1) 1 ~ 45 까지 숫자를 6개를 랜덤으로 받아(Random클래스를 이용) set에 저장 / 출력
		Random random = new Random();
		Set<Integer> set = new HashSet<Integer>();
		
		while(set.size() < 6) {
			set.add(random.nextInt(45)+1);
			
		}
		System.out.println(set.size());
		System.out.println("------------");
	
		
		
		//2) [추가]저장된 set의 오른차순정렬을 해보세요(검색을 통해서 해결해봅니다 - 스트림함수 사용)
		//2-1)
//		List<Integer> list = new ArrayList<Integer>(set);
//		Collections.sort(list);
//		list.forEach(System.out::println);
		
		//2-2)
//		set.stream().sorted().forEach((el)->{System.out.printf(el + " ");});
		List<Integer> list = set.stream().sorted().collect(Collectors.toList());
		list.forEach((el)->{System.out.printf(el + " ");});
		System.out.println(list);
		
		
	}

}
