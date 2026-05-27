package Ch03;

//https://velog.io/@9to0/%EC%9E%90%EB%B0%94%EC%9D%98-%EC%A0%95%EC%84%9D-3%ED%8C%90-12-%EC%97%B0%EC%8A%B5%EB%AC%B8%EC%A0%9C-%EC%A0%9C%EB%84%A4%EB%A6%AD%EC%8A%A4-%EC%97%B4%EA%B1%B0%ED%98%95-%EC%95%A0%EB%84%88%ED%85%8C%EC%9D%B4%EC%85%98
//----------------------------------------------------------- 
//문제: [12-1] 클래스 Box가 다음과 같이 정의되어 있을 때, 다음 중 오류가 발생하는 문장은? 경고가 발생하는 문장은?
//-----------------------------------------------------------
class Box<T> { // 지네릭 타입 T를 선언
	T item;

	void setItem(T item) {
		this.item = item;
	}

	T getItem() {
		return item;
	}
}
// a.Box<Object> b = new Box<String>();
// b.Box<Object> b = (Object) new Box<String>();
// c.new Box<String>().setItem(new Object());
// d.new Box<String>().setItem("ABC");

// -----------------------------------------------------------


//[12-2] 지네릭 메서드 makeJuice()가 아래와 같이 정의되어 있을 때, 이 메서드를 올바르게 호출한 문장을 모두 고르시오.
//(Apple과 Grape는 Fruit의 자손이라고 가정하자.)

//class Juicer {
// static <T extends Fruit> String makeJuice(FruitBox<T> box) {
//     String tmp = "";
//     for (Fruit f : box.getList()) tmp += f + " ";
//     return tmp;
// }
//}

//     a.	Juicer.<Apple>makeJuice(new FruitBox<Fruit>());
//     b.	Juicer.<Fruit>makeJuice(new FruitBox<Grape>());
//     c.	Juicer.<Fruit>makeJuice(new FruitBox<Fruit>());
//     d.	Juicer.makeJuice(new FruitBox<Apple>());
//     e.	Juicer.makeJuice(new FruitBox<Object>());

//-----------------------------------------------------------
////[12-3] 다음 중 올바르지 않은 문장을 모두 고르시오.
//
//    a.	Box<?> b = new Box();
//    b.	Box<?> b = new Box<>();
//    c.	Box<?> b = new Box<Object>();
//    d.	Box<Object> b = new Box<Fruit>();
//    e.	Box	b = new Box<Fruit>();
//    f.	Box<? extends Fruit> b = new Box<Apple>();
//    g.	Box<? extends Object> b = new Box<? extends Fruit>();

//-----------------------------------------------------------

//[12-4] 아래의 메서드는 두 개의 ArrayList를 매개변수로 받아서,
//하나의 새로운 ArrayList로 병합하는 메서드이다.
//이를 지네릭 메서드로 변경하시오.

//public static ArrayList<?extends Product> merge( ArrayList<?extends Product> list, ArrayList<?extends Product> list2)
//{
//  ArrayList<?extends Product> newList = new ArrayList<>(list);
//  newList.addAll(list2);
//  return newList;
//}


public class C06Ex {

	public static void main(String[] args) {


	}

}
