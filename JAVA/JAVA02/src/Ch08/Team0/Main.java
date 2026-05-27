package Ch08.Team0;


import Ch08.Team0.Interfaces.SumInterface;

public class Main {
	
	static SumInterface sum1  = new Ch08.Team0.Impl.홍길동.SumImpl();
	
	
	public static void Team0CalTest() {
		sum1.sum(10);
		sum1.sum(10,20,30);
	}
	
	public static void main(String[] args) {
			
		System.out.println();
	}
}
