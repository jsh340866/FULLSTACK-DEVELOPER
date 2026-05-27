package Ch17;

/* ----------------------------------------------------------
   1-Ex. [학생용 문제] filter / map 기초
   ----------------------------------------------------------
   학습 단계 : C01STREAMMAIN 학습 직후
   풀이 방법 : 각 Q 의 데이터를 스트림으로 가공해 기대 출력을 만들어 보세요.
   정답 참고 : C01ExFilterMapAns.java
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class C01ExFilterMap {

	public static void main(String[] args) {

		// ====================================================
		// Q1. nums 에서 짝수만 골라 List<Integer> 로 만들고 출력
		//     기대 : [2, 4, 6, 8, 10]
		// ====================================================
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> num2 = nums.stream().filter((e)->{return e%2==0;}).collect(Collectors.toList());
		System.out.println(num2);

		// ====================================================
		// Q2. mixed 에서 음수만 골라 절댓값으로 변환해서 출력
		//     기대 : [3, 1, 7]
		// ====================================================
		List<Integer> mixed = Arrays.asList(-3, 5, -1, 8, -7, 2);
		List<Integer> mixedPlus = mixed .stream()
										.filter(e->{return e<0;})
										.map(e->{return e*(-1);})
										.collect(Collectors.toList());
		System.out.println(mixedPlus);
		// TODO 답안 작성

		// ====================================================
		// Q3. 5글자 이상의 단어만 골라 모두 대문자로 변환해서 출력
		//     기대 : [APPLE, BANANA, ELEPHANT]
		// ====================================================
		List<String> words = Arrays.asList("apple", "hi", "banana", "cat", "elephant");
		List<String> wordPlus = words .stream()
									  .filter(e->{return e.length()>4;})
									  .map(e->{return e.toUpperCase();})
									  .collect(Collectors.toList());
		System.out.println(wordPlus);
		// TODO 답안 작성

		// ====================================================
		// Q4. 1~20 중 3의 배수만 골라 제곱한 결과를 출력
		//     기대 : [9, 36, 81, 144, 225, 324]
		// ====================================================
		
		List<Integer> num = IntStream.range(1, 30).boxed().collect(Collectors.toList());
		
		List<Integer> num3 = num.stream()
								.filter(e->{return e%3==0;})
								.map(e->{return e*e;})
								.collect(Collectors.toList());
		System.out.println(num3);
		// TODO 답안 작성

		// ====================================================
		// Q5. words2 에서 'a' 로 시작하는 것만 골라 첫 글자만 추출해서 출력
		//     기대 : [a, a, a]
		// ====================================================
		List<String> words2 = Arrays.asList("apple", "banana", "ant", "kiwi", "avocado");
		List<String> wordsA = words2.stream()
									.filter(e->{return e.startsWith("a");})
									.map(e->{return e.substring(0, 1);})
									.collect(Collectors.toList());
		System.out.println(wordsA);
		// TODO 답안 작성
	}
}
