package Ch02;

public class C05ExceptionMain {

	public static void main(String[] args) {
		try {
		String str = null;		
		str.toString();			//NullPointerException
		
		int arr[] = { 10,20,30 };
		arr[4] = 10;			//ArrayIndexOutOfBoundsException
		
		Animal tori = new Dog();
		Cat down = (Cat)tori;	//ClassCastException
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("이후 동작 여부 확인코드!");
		
//		}catch(NullPointerException e1) {
//			System.out.println("NullPointerException 처리");
//		}catch(ArrayIndexOutOfBoundsException e2) {
//			System.out.println("ArrayIndexOutOfBoundsException 처리");
//		}catch(ClassCastException e3) {
//			System.out.println("ClassCastException 처리");
//		}
	}

}
