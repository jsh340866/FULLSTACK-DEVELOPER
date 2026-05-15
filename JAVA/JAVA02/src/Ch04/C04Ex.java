package Ch04;

import java.util.ArrayList;

//다음 2개의 static 가진 ArrayUtils 클래스를 만들어보자. concat()와 print()를 작성하여 ArrayUtil 클래스를 완성하라.
class ArrayUtils {
	   public static int[] concat(int[] a, int[] b) {
	        /* 배열 a와 b를 연결한 새로운 배열 리턴 */
		   int[] c = new int[a.length+b.length];
//		   for(int i =0; i<a.length; i++) {
//			   c[i] += a[i]; 
//		   }
//		   for (int i =0; i<b.length;i++) {
//			   c[i+a.length] += b[i];
//		   }
		   
		   System.arraycopy(a, 0, c, 0, a.length);
		   System.arraycopy(b, 0, c, a.length, b.length);
		   
		   return c;
	   }
	   public static void print(int [] a) {
		   /* 
		    * 배열내 모든 요소 1행으로 띄어쓰기 단위로 출력
		    * ex. a [] = {10,20,30,40}
		    * 출력 : 10 20 30 40
		    *  */		   
		   for(int n : a) {
			   System.out.printf("%d ",n);
		   }
	   }
}

public class C04Ex {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 1, 5, 7, 9 };
		int[] array2 = { 3, 6, -1, 100, 77 };
		int[] array3 = ArrayUtils.concat(array1, array2);
//		System.out.println(ArrayUtils.concat(array1, array2));
		ArrayUtils.print(array3);
	}
}
