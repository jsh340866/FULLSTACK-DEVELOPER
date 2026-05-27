package Ch01;

//학생이 서점주인에게 책 1권을 구매한다
//클래스 	: 학생
//속성 	: 보유금액 
//		: 책개수
//기능 	: 구매하기(서점주인, 보유금액의 일부)
//
//클래스 	: 서점주인
//속성	: 보유금액
//		: 책개수
//		: 책가격
//기능	: 판매하기(구매자의 돈) : 책개수

//
//클래스 	: 학생(Student)
//속성 	: 보유금액(myMoney : int)
//		: 책개수(bookCnt : int)
//
//기능 	: 구매하기(서점주인, 보유금액의 일부)
//		: buy(BookSeller seller , int money) : void
//
//
//클래스 	: 서점주인(BookSeller)
//속성	: 보유금액(myMoney : int)
//		: 책개수(bookCnt : int)
//		: 책가격(price : int)
//
//기능	: 판매하기(구매자의 돈) : 책개수
//		  sell(int money) : int

class Student {
	int myMoney;
	int bookCnt;
	
	void buy(BookSeller seller, int money) {
		myMoney -= money;
		bookCnt = seller.sell(money);
		System.out.println("책을 " + bookCnt + " 권 구매했습니다.");
		
	}

	@Override
	public String toString() {
		return "Student [보유금액=" + myMoney + ", 책개수=" + bookCnt + "]";
	}

	public Student(int myMoney, int bookCnt) {
		super();
		this.myMoney = myMoney;
		this.bookCnt = bookCnt;
	}
}

class BookSeller {
	int myMoney;
	int bookCnt;
	int price;
	
	int sell(int money) {
		int s = money/price;
		myMoney += s*price;
		bookCnt -= s;
		return s;
	}

	public BookSeller(int myMoney, int bookCnt, int price) {
		super();
		this.myMoney = myMoney;
		this.bookCnt = bookCnt;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "BookSeller [보유금액=" + myMoney + ", 책개수=" + bookCnt + ", 책가격=" + price + "]";
	}
}


public class C13Ex {

	public static void main(String[] args) {
		Student sd = new Student(35000, 0);
		BookSeller bs = new BookSeller(100000, 20, 7000);
		sd.buy(bs, 10000);
		
		System.out.println(sd);
		System.out.println(bs);

	}

}
