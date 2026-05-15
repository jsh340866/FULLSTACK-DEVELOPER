package Ch03;

import java.util.Arrays;
import java.util.Scanner;

public class C01ArrayMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr1 = new int[5]; //배열형 참조변수
		arr1[0] = sc.nextInt();
		arr1[1] = sc.nextInt();
		arr1[2] = sc.nextInt();
		arr1[3] = sc.nextInt();
		arr1[4] = sc.nextInt();
		
//		System.out.println("배열길이 : " + arr1.length);
//		for (int i =0;i<arr1.length;i++)
//			System.out.println(arr1[i]);
//		System.out.println("------------");
//		for(int el : arr1)
//			System.out.println(el);
//		System.out.println("------------");
//		Arrays.stream(arr1).forEach((el)->{System.out.println(el);});
		
		// 저장된 배열의 수중 최댓값 / 최솟값 구하기
		int min = arr1[0];
		for (int i =0; i<arr1.length;i++) {
			if (min>arr1[i]) {
				min = arr1[i];
			}
		}
		int max = arr1[0];
		for (int el : arr1) {
			if( el > max ) {
				max = el;
			}
		}
		System.out.println("max : " + max);
		System.out.println("min : " + min);
		
		System.out.println("MAX : " + Arrays.stream(arr1).max().getAsInt());
		System.out.println("MIN : " + Arrays.stream(arr1).min().getAsInt());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
