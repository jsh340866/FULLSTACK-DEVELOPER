package Ch01;

//관객이 매표원에게 영화표 1장을 예매한다
//
//클래스 	: 관객(Audience)
//속성 	: 보유금액(myMoney : int)
//		: 티켓개수(ticketCnt : int)
//
//기능 	: 예매하기(매표원, 보유금액의 일부)
//		: reserve(TicketSeller seller , int money) : void

class Audience {
	int myMoney;
	int ticketCnt;
	
	void reserve(TicketSeller seller, int money) {
		myMoney -= money;
		ticketCnt = seller.issue(money);
		System.out.println("영화표 " + ticketCnt + " 장을 예매했습니다.");
		
	}

	@Override
	public String toString() {
		return "Audience [보유금액=" + myMoney + ", 티켓개수=" + ticketCnt + "]";
	}

	public Audience(int myMoney, int ticketCnt) {
		super();
		this.myMoney = myMoney;
		this.ticketCnt = ticketCnt;
	}
}

//
//클래스 	: 매표원(TicketSeller)
//속성	: 보유금액(myMoney : int)
//		: 티켓재고(ticketCnt : int)
//		: 티켓가격(price : int)
//
//기능	: 발권하기(관객의 돈) : 티켓개수
//		  issue(int money) : int


class TicketSeller {
	int myMoney;
	int ticketCnt;
	int price;
	
	int issue(int money) {
		int tc = money/price;
		myMoney += tc*price;
		ticketCnt -= tc;
		return tc;
	}

	public TicketSeller(int myMoney, int ticketCnt, int price) {
		super();
		this.myMoney = myMoney;
		this.ticketCnt = ticketCnt;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "TicketSeller [보유금액=" + myMoney + ", 티켓재고=" + ticketCnt + ", 티켓가격=" + price + "]";
	}
}



public class C15Ex {

	public static void main(String[] args) {
		Audience ad = new Audience(50000, 0);
		TicketSeller ts = new TicketSeller(1000000, 1000, 30000);
		ad.reserve(ts, 50000);
		
		System.out.println(ad);
		System.out.println(ts);

	}

}
