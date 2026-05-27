package Ch02;

class A {
	void func() throws NullPointerException{
		System.out.println("A class func() call!");
		String str = null;
		str.toString();
	}
}
class B {
	void func() throws Exception{
		System.out.println("B class func() call!");
		throw new ArithmeticException();
	}
}

public class C06ThrowAndThrowsMain {

	public static void main(String[] args) {
		
		A ob1 = new A();
		B ob2 = new B();
		
		try {
		ob1.func();
		ob2.func();
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		System.out.println("!");
	}

}
