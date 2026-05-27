package Ch02;

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

public class C04ClassCastExceptionMain {

	public static void main(String[] args) {

		Animal poppy = new Dog(); 	 // 업캐스팅
		Animal tori = new Cat(); 	 // 업캐스팅
		try {
			Dog down1 = (Dog) poppy; // o
			Dog down2 = (Dog) tori;	 // x
		} catch (ClassCastException e) {
			e.printStackTrace();	 // log's lib lombok,,	
			System.out.println("예외발생");
		}

	}

}
