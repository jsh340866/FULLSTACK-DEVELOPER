package Ch06;

import java.util.Iterator;
import java.util.Scanner;

public class C04FOR {

	public static void main(String[] args) {

//		int i = 0;
//		while (i < 10) {
//			System.out.println("HELLOWORLD");
//			i++;
//		}

//		for(int i=0;i<10;i++) {
//			System.out.println("HELLOWORLD");
//		}

		
		
		
		
		
		
		
		// 02WHILE.java 의 while문을 모두 for문으로 바꾸세요
		// 2 - 9 단 출력
//		for (int dan = 2; dan < 10; dan++) {
//			for(int i =0; i<10;i++){
//				System.out.printf("%d x %d = %d\n", dan, i, dan * i);
//			}
//			System.out.println();
//		}
		
		
		
		

		// N - 9 단 출력
//		Scanner sc = new Scanner(System.in);
//		for(int dan = sc.nextInt();dan<10;dan++) {
//			for(int i =1;i<10;i++) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//			}
//			System.out.println();
//		}
//		sc.close();

		
		
		
		
		
		// N - M 단 출력(N<M, N>=2 && N<=9, M>2 && M<10)
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		
//		//유효성검증(N<M, N>=2 && N<=9, M>2 && M<10) 이 아닌경우
//		//(N>=M) ||  (N<2 || N>9) || (M<=2 || M>=10)
//		while((n>=m) ||  (n<2 || n>9) || (m<=2 || m>=10)) {
//			System.out.print("n,m 다시 입력 : ");
//			n = sc.nextInt();
//			m = sc.nextInt();
//		}
//		for(int dan=n;dan<m+1;dan++) {
//			 for(int i=0;i<10;i++){
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//			}
//			System.out.println();
//		}
//		sc.close();

		
		
		
		
		// N - M 단 출력 거꾸로 9 x 9 , 9 x 8 ....
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		
//		//유효성검증(N<M, N>=2 && N<=9, M>2 && M<10) 이 아닌경우
//		//(N>=M) ||  (N<2 || N>9) || (M<=2 || M>=10)
//		while((n>=m) ||  (n<2 || n>9) || (m<=2 || m>=10)) {
//			System.out.print("n,m 다시 입력 : ");
//			n = sc.nextInt();
//			m = sc.nextInt();
//		}
//		
//		for (int dan = m;dan>n-1;dan--){
//			for (int i = 9;i>0;i--){
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//			}
//			System.out.println();
//		}
//		sc.close();

		
		
		
		
		// 1) 고정높이
		// *****
		// *****
		// *****
		// *****
//		for (int i =0;i<4;i++){
//			for (int j=0;j<5;j++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		
		

		// 2)
		// 높이 : 4
		// *****
		// *****
		// *****
		// *****
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		for (int i =0;i<h;i++){
//			for (int j=0;j<5;j++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		sc.close();
		
		
		
		
		

		// 3) 고정높이
		// *
		// **
		// ***
		// ****
//		for (int i =0;i<4;i++){
//			for(int j=0;j<=i;j++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}

		
		
		
		// 4)
		// 높이 : 4
		// *
		// **
		// ***
		// ****
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		for (int i =0;i<h;i++){
//			for(int j=0;j<=i;j++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		sc.close();
		
		
		
	

		// 5)
		// 높이 : 4
		// ****
		// ***
		// **
		// *
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		for (int i =0; i<h;i++){
//			for (int j=0;j<=(h-1)-i;j++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		sc.close();
		
		
		
		

		// 6)
		// 높이 : 4
		//    *
		//   ***
		//  *****
		// *******
//		for (int i = 0; i<4; i++){	
//			//공백
//			for (int j=0; j<3-i;j++){
//				System.out.print(" ");
//			}
//			//별
//			for (int k=0;k<=i*2;k++){
//				System.out.print("*");
//			}		
//			System.out.println();
//		}	

//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		for (int i =0; i<h;i++){	
//			//공백
//			for(int j=0; j<(h-1-i);j++){
//				System.out.print(" ");
//			}
//			//별
//			for (int k =0;k<=i*2;k++){
//				System.out.print("*");
//			}		
//			System.out.println();
//		}
//		sc.close();

		
		
		
		// 6)
		// 높이 : 4
		// *
		// ***
		// *****
		// *******
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		for (int i =1 ;i<5;i++){
//			for (int j =1;(j/2)<i;j++){
//				System.out.printf("*");
//			}
//			System.out.println();
//		}
//		sc.close();

		
		
		
		
		// 7)
		// 높이 : 4
		// *******
		// *****
		// ***
		// *
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		for (int i = h; i>0;i--){
//			for (int j =1; (j/2)<i;j++){
//				System.out.printf("*");
//			}
//			System.out.println();
//		}
//		sc.close();

		
		
		
		
		// 8) 고정높이
		// *
		// ***
		// *****
		// *******
		// *****
		// ***
		// *
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		int k = 1;
//		for (int i =1; i<(h+1);i++){
//			for(int j =1;j/2 < k;j++){
//				System.out.printf("*");
//			}
//			System.out.println();
//			if(i<(h+1)/2) {
//				k++;
//			}
//			else {
//				k--;
//			}
//		}
//		sc.close();

//		int starCount = 1; // 실제 찍을 별의 기준 (1->2->3->4->3->2->1)
//		for (int i =1; i<= 7; i++){
//		    // 작성하셨던 j/2 < starCount 로직 그대로 활용!
//		    for(int j=1;j/2<starCount;j++){
//		        System.out.print("*");
//		    }
//		    System.out.println();
//		    // 중간(4번째 줄) 전까지는 별을 늘리고, 그 뒤로는 줄여요
//		    if (i < 4) {
//		        starCount++;
//		    } else {
//		        starCount--;
//		    }
//		}
		
		
		
		

		// 9)
		// 높이 : 7
		// *
		// ***
		// *****
		// *******
		// *****
		// ***
		// *
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		int l = 0;
//		for (int i =0; i<h;i++){
//			for (int j =0;j<(h/2)-1;j++){
//				System.out.printf(" ");
//			}
//			for (int k=0; k<=l*2;k++){
//				System.out.printf("*");
//			}
//			if ( i < (h/2)) {
//				l++;
//			}
//			else l--;
//			System.out.println();
//		}
//		sc.close();
		
		
		
		
		
		
		// 10)
		// 높이 : 7
		// *******
		// *****
		// ***
		// *
		// ***
		// *****
		// *******

// -----------------------------------------------------------------------
 
		
		
		
		
		

		//6)
		//높이 : 4
		//   *
		//  ***
		// *****
		//*******
//		for (int i = 0; i<4 ; i++){
//			for (int j =0; j<3-i;j++){
//				System.out.printf(" ");
//			}
//			for (int k =0; k<=i*2;k++){
//				System.out.printf("*");
//			}
//			System.out.println();
//		}

		
		
		
		
		
		
// -----------------------------------------------------------------------
		
		//7)
		//높이 : 4
		//*******
		// *****
		//  ***
		//   *
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		for (int i =0; i<h;i++){
// 			//공백
//			for (int j =0 ;j<i;j++){
//				System.out.printf(" ");
//			}
//			//별
//			for (int k=0;k <= ((h-1)*2)-(i*2);k++){
//				System.out.printf("*");
//			}
//			System.out.println();
//		}
//		sc.close();
		
		

		
		
		
		
// -----------------------------------------------------------------------
		
		//8) 고정높이
		//   *
		//  ***
		// *****
		//*******
		// *****
		//  ***
		//   *
//		for(int i =0; i<7;i++){
//			if (i < 4) {
//				// 공백
//				for (int j =0 ; j<3-i;j++){
//					System.out.printf(" ");
//				}
//				// 별
//				for (int k =0; k<=i*2;k++){
//					System.out.printf("*");
//				}
//			}
//			else {
//				// 공백
//				for (int j=0;j<i-(7/2);j++){
//					System.out.printf(" ");
//				}
//				// 별
//				for (int k =0; k<(7*2-1)-(i*2);k++){
//					System.out.printf("*");
//				}
//			}
//			System.out.println();
//		}


		
		
		
		

// -----------------------------------------------------------------------
		
		//9)
		//높이 : 7
		//   *
		//  ***
		// *****
		//*******
		// *****
		//  ***
		//   *	
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		while(h%2==0 || h<=1) {
//			System.out.printf("다시 입력해주세요.(홀수만) >>> ");
//			h = sc.nextInt();
//		}
//		for (int i =0; i<h;i++){
//			if (i <= h/2) {
//				// 공백
//				for (int j =0;j<h/2 -i;j++){
//					System.out.printf(" ");
//				}
//				// 별
//				for (int k =0; k<=i*2;k++){
//					System.out.printf("*");
//				}
//			}
//			else {
//			// 공백
//				for (int j =0;j < i - (h/2);j++){
//					System.out.printf(" ");
//				}
//				// 별
//				for (int k=0;k <= (2*(h-1))-(i*2);k++){
//					System.out.printf("*");
//				}
//			}
//			System.out.println();
//		}		
//		sc.close();
			
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		int l = 0;
//		for (int i =0; i<h;i++){
//			for (int j =0;j < (h/2) - l;j++){
//				System.out.printf(" ");
//			}
//			for (int k=0;k <= l*2;k++){
//				System.out.printf("*");
//			}
//			if ( i < (h/2)) {
//				l++;
//			}
//			else l--;
//			System.out.println();
//		}
//		sc.close();

		
		
		
		
		
		
		
		
		
//	---------------------------------------------------------------------

		// 10)
		// 높이 : 7
		//*******
		// *****
		//  ***
		//   *
		//  ***
		// *****
		//*******
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		while(h%2==0 || h<=1) {
//			System.out.printf("다시 입력해주세요.(홀수만) >>> ");
//			h = sc.nextInt();
//		}
//		for (int i=0; i<h;i++){
//			if (i <= h/2) {
//				// 공백
//				for (int j=0;j<i;j++){
//					System.out.printf(" ");
//				}
//				// 별
//				for (int k =0;k < h - i*2;k++ ){
//					System.out.printf("*");
//				}
//			}
//			else {
//			// 공백
//				for (int j= 0;j < (h-i)-1;j++ ){
//					System.out.printf(" ");
//				}
//				// 별
//				for (int k=0;k <= (2*i)-(h-1);k++ ){
//					System.out.printf("*");
//				}
//			}
//			System.out.println();
//		}		
//		sc.close();
		
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		int l = 0; 
//		for (int i =0;i < h;i++){
//			for (int j =0; j<l;j++){
//				System.out.printf(" ");
//			}
//			for (int k=0;k < h - (l * 2);k++){
//				System.out.printf("*");
//			}
//			if (i < (h / 2)) {
//				l++;
//			} else
//				l--;
//			System.out.println();
//		}
//		sc.close();
//	}
		
		
		
		
		
		
	}
}
