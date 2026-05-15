package Ch01;

// 고객이 사과장수에게 사과 1개를 구매한다

// 클래스 : 고객(Buyer)
// 속성 	: 보유 금액(myMoney : int)
// 			: 사과개수(appleCnt : int)
//
// 기능		: 구매하기(사과장수, 보유금액의 일부)
//			: pay(Seller seller, int money) : void

// 클래스 : 사과장수(Seller)
// 속성		: 보유 금액(myMoney : int)
// 			: 사과개수(appleCnt : int)
// 			: 사과가격(price : int)
//
// 기능		: 판매하기(구매자의 돈) : 사과개수 
// 				sales(int money): return appleCnt

class Buyer {
	private int myMoney;
	private int appleCnt;

	// 생성자
	public Buyer(int myMoney, int appleCnt) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
	}

	public void pay(Seller seller, int money) {

		// 판매자에게 구매의사금액 전달
		// 판매자는 구매자에게 사과개수 전달
		// 내 돈에서 구매의사금액만큼 차감(내보유금액>구매의사금액)
		myMoney -= money;
		int receivedAppCnt = seller.sales(money);
		// 사과개수를 현재 사과보유개수에 누적
		this.appleCnt += receivedAppCnt;
	}
	// toString
	@Override
	public String toString() {
		return "Buyer [myMoney=" + myMoney + ", appleCnt=" + appleCnt + "]";
	}

}

class Seller {
	private int myMoney;
	private int appleCnt;
	private int price;

	public int sales(int money) {
		// 구매자로 부터 받은 금애글 내 보유금액에 누적
		this.myMoney += money;
		// 구매자로 부터 받은 금액만큼 사과개수를 계산
		int calAppCnt = money / price;
		// 판매자의 보유 사과개수에서 차감(보유사과개수 vs 구매자 요청사과개수)
		this.appleCnt -= calAppCnt;
		// 계산된 사과 개수를 반환
		return calAppCnt;
	}
	public Seller(int myMoney, int appleCnt, int price) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Seller [myMoney=" + myMoney + ", appleCnt=" + appleCnt + ", price=" + price + "]";
	}
}

public class C12Ex_중요 {

	public static void main(String[] args) {

		// 고객
		Buyer 홍길동 = new Buyer(100000, 0);
		Buyer 남길동 = new Buyer(100000, 0);

		// 사과장수
		Seller 사과장수1 = new Seller(100000, 100, 1000);

		// 고객 - 구매요청 -> 사과장수
		홍길동.pay(사과장수1, 20000);
		남길동.pay(사과장수1, 10000);

		System.out.println(홍길동);
		System.out.println(남길동);
		System.out.println(사과장수1);

	}
}
