package Ch03;

import java.util.ArrayList;

class 호빵재료 {
	
}

class 팥 extends 호빵재료 {
	@Override
	public String toString() {
		return "단팥";
	}

}

class 야채 extends 호빵재료 {
	@Override
	public String toString() {
		return "야채";
	}

}

class 피자 extends 호빵재료 {
	@Override
	public String toString() {
		return "피자";
	}

}

class 호빵<T extends 호빵재료 > {
	private T 재료;
	
	호빵(T 재료) {
		this.재료 = 재료;
	}

	@Override
	public String toString() {
		return "호빵 [재료=" + 재료 + "]";
	}
}

class 민트초코 {

	@Override
	public String toString() {
		return "민트초코";
	}
	
}


public class C01GenericMain {

	public static void main(String[] args) {
		호빵<팥> ob1 = new 호빵<팥>(new 팥());
		System.out.println(ob1);
		
		호빵<야채> ob2 = new 호빵<야채>(new 야채());
		System.out.println(ob2);
		
		호빵<피자> ob3 = new 호빵<피자>(new 피자());
		System.out.println(ob3);
		
//		호빵<민트초코> ob4 = new 호빵<민트초코>(new 민트초코());
//		System.out.println(ob4);

	}

}
