package Ch04;

class ShopService {
	// 싱글톤 패턴 코드 처리
	private static ShopService instance; // 여기서만 클래스 인스턴스 쓰겠다!

	private ShopService() {
	} // 딴 데서 못쓰게 막기

	public static ShopService getInstance() { // getInstance 메서드로 객체 만들겠다
		if (instance == null) {
			instance = new ShopService();
		}
		return instance;
	}
}
class ShopServiceExample {
	private static ShopService instance;
	private ShopServiceExample() {};
	public static ShopService getInstance() {
		if (instance == null) {
			instance = ShopService.getInstance();
		}
		return ShopService.getInstance();
	}
}

public class C05Ex {

	public static void main(String[] args) {

		// ---------------------------------------
		// Practice
		// ---------------------------------------
		// shopService 객체를 싱글톤으로 만들어 보세요
		// ShopServiceExample 클래스에서 shopService 의 getInstance() 메소드로 싱글톤을 얻을 수 있도록
		// ShopService 클래스를 작성해보세요
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		if (obj1 == obj2) {
			System.out.println("같은 ShopService 객체입니다.");
		} else {
			System.out.println("다른 ShopService 객체 입니다.");
		}
	}
}
