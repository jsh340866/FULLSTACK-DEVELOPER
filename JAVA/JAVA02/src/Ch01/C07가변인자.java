package Ch01;

class C07Simple {
	int sum (int ...arg) {
		System.out.println(arg);
		int s = 0;
		
		for(int item : arg) {
			System.out.println(item);
			s += item;
		}
		return s;
		
	}
}


public class C07가변인자 {
	
	public static void main(String[] args) {
		C07Simple obj = new C07Simple();
		obj.sum(10,20);
		int result = obj.sum(10,20,30,40,50,60,70);		
		System.out.println("누적 합 : " + result);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
