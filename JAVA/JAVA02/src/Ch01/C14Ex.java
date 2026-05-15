package Ch01;

//손님이 카페사장에게 커피 1잔을 주문한다
//클래스 	: 손님
//속성 	: 보유금액
//		: 커피잔수
//기능 	: 주문하기(카페사장, 보유금액의 일부)
//
//클래스 	: 카페사장
//속성	: 보유금액
//		: 커피재고
//		: 커피가격
//기능	: 제조하기(손님의 돈) : 커피잔수

//손님이 카페사장에게 커피 1잔을 주문한다
//
//클래스 	: 손님(Customer)
//속성 	: 보유금액(myMoney : int)
//		: 커피잔수(coffeeCnt : int)
//
//기능 	: 주문하기(카페사장, 보유금액의 일부)
//		: order(CafeOwner owner , int money) : void
//
//
//클래스 	: 카페사장(CafeOwner)
//속성	: 보유금액(myMoney : int)
//		: 커피재고(coffeeCnt : int)
//		: 커피가격(price : int)
//
//기능	: 제조하기(손님의 돈) : 커피잔수
//		  make(int money) : int

class Customer {
	private int myMoney;
	private int coffeeCnt;

	public void order(CafeOwner owner, int money) {
		myMoney -= money; // 6 - 고객 보유금액에서 돈을 지불함.
		coffeeCnt += owner.make(money); // 7 - owner.make() 부르기! -> 주문한 커피 잔수를 저장
		System.out.println("커피를 " + coffeeCnt + "잔 주문했습니다"); // 12 - 커피 잔수를 출력!
	}

	public Customer(int myMoney, int coffeeCnt) {
		super();
		this.myMoney = myMoney;
		this.coffeeCnt = coffeeCnt;
		// 2 - 필드 값 초기화!
	}

	@Override
	public String toString() {
		return "Customer [보유금액=" + myMoney + ", 커피잔수=" + coffeeCnt + "]";
		// 14 - 호출된 Customer.toString() 출력!

	}

}

class CafeOwner {
	private int myMoney;
	private int coffeCnt;
	int price;

	public int make(int money) {
		int makingCnt = money / price; // 8 - 주문 된 커피 잔수를 계산 후 makingCnt(지역변수) 변수에 저장
		coffeCnt -= makingCnt; // 9 - 커피재고에서 주문 커피 잔수를 제거
		myMoney += (makingCnt) * price; // 10 - 보유금액에 받은 돈을 저장
		return makingCnt; // 11 - 커피 잔수를 return!
	}

	public CafeOwner(int myMoney, int coffeCnt, int price) {
		super();
		this.myMoney = myMoney;
		this.coffeCnt = coffeCnt;
		this.price = price;
		// 4 - 필드 값 초기화!
	}

	@Override
	public String toString() {
		return "CafeOwner [보유금액=" + myMoney + ", 커피재고=" + coffeCnt + ", 커피가격=" + price + "]";
		// 16 - 호출된 CafeOwner.toString() 출력!
	}
}

public class C14Ex {

	public static void main(String[] args) {
		Customer customer = new Customer(20000, 0); // 1 - customer 객체 생성 + 생성자 호출
		CafeOwner cafe = new CafeOwner(100000, 100, 2000); // 3 - cafe 객체 생성 + 생성자 호출
		customer.order(cafe, 12000); // 5 - customer.order() 부르기!

		System.out.println(customer); // 13 - customer.toString() 호출!
		System.out.println(cafe); // 15 - cafe.toString() 호출!
	}

}
