package Ch07;

interface Printer {
	void print();
}
class Inkjet implements Printer {

	@Override
	public void print() {
		System.out.println("Inkjet 프린터 출력");
		
	}
}
class Laser extends Inkjet {
	@Override
	public void print() {
		System.out.println("Laser 프린터 출력");
		
	}
}

public class C06Ex {
	
	public static void main(String[] args) {
		Printer p = new Inkjet();
		p.print();	// 'Inkjet 프린터 출력'
		p = new Laser();
		p.print();	// 'Laser 프린터 출력'
	}
}
