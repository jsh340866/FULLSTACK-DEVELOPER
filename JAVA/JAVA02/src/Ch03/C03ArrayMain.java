package Ch03;

public class C03ArrayMain {

	public static void main(String[] args) {
		int arr[][] = {
				{10,20,30},
				{40,50,60,65,67},
				{70,80,90,96,11,56},
				{100,110,120,15,22,33,44},
		};
		System.out.println("arr[][]'s 배열 요소 개수 : " + arr.length);
		System.out.println("arr[0]'s 배열 요소 개수 : " + arr[0].length);
		System.out.println("arr[1]'s 배열 요소 개수 : " + arr[1].length);
		System.out.println("arr[2]'s 배열 요소 개수 : " + arr[2].length);
		System.out.println("arr[3]'s 배열 요소 개수 : " + arr[3].length);

		//1차원 배열의 배열요소 해당 자료형크기정도 이다.
		//2차원 배열의 배열요소는 1차원 배열이다.
		//3차원 배열의 배열요소는 2차원 배열이다.
	}

}
