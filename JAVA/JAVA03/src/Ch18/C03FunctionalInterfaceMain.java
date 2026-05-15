package Ch18;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class C03FunctionalInterfaceMain {
	
	//
	public static Function<Integer,Integer> func1 = x -> x*x;
	//
	public static Function<Integer,Integer> func2 = x -> x+x;
	//
//	public static Function<List<Integer>,Integer> func3 = (x)->{return x.stream().reduce(0,(sum,el)->{return sum+el;});};
	public static Function<List<Integer>,Integer> func3 = x->x.stream().reduce(0,(sum,el)->sum+el);
	
	public static Function<List<Object>, List<String>> func4 = x->x .stream()
																	.filter(el->el instanceof String)
																	.map(el->(String)el)
																	.collect(Collectors.toList());
	
	// 10 -> 10*10(func1 return) -> 100 + 100(func2 return)
	public static Function<Integer,Integer> func5 = func1.andThen(func2);
	// [10,20,30] -> 60(func3 return) -> 60+60(func2 return) -> 120*120(function return)
	public static Function<List<Integer>,Integer> func6 = func3.andThen(func2).andThen(func1);
	
	//
	public static Function<Integer,Function<Integer,Integer>> func7 = (x)->{
		System.out.println("func7's x : " + x);
		return (n)->{
			System.out.println("func7's return function n : " + n);
			System.out.println("func7's return function x : " + x);
			return n+x;
			};
		};
		
	//
	public static Function<Integer,Function<Integer,Integer>> func8 = x->n->n+x;
	
	
	
	public static void main(String[] args) {
		
//		System.out.println("(1) 제곱 : " + func1.apply(10));		// 100
//		System.out.println("(2) +한번더 : " + func2.apply(10));	// 20
//		System.out.println("(3) 누적합 : " + func3.apply(Arrays.asList(10,20,30,40,50)));	// 150
//		System.out.println("(4) String 만 꺼내기 : " 
//		+ func4.apply(Arrays.asList(11,10.5,"TEST",true,"HELLO","BOOL",new StringBuffer("HI"), 20, 40)));
//		
//		System.out.println("(5) andThen 1단계 : " + func5.apply(10));
//		System.out.println("(6) andThen 1단계 : " + func6.apply(Arrays.asList(10,20,30)));
		
		System.out.println("(7) func7	 : " + func7.apply(10).apply(20));
		System.out.println("(8) func8	 : " + func8.apply(10).apply(20));
	}

}
