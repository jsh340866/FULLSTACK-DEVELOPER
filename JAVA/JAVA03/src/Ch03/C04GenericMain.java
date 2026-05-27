package Ch03;


class Animal {
	String name;
}
class Panda extends Animal {
	
	Panda(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Panda [name=" + name + "]";
	}
	
}
class Tiger extends Animal {
	Tiger(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}

}



public class C04GenericMain {
	
	public static <T extends Animal> void PrintGeneric(T [] arr) {
		for(T el : arr)
			System.out.println(el);
	}
	public static void PrintByObject(Object [] arr) {
		for (Object el : arr) {
			System.out.println(el);
		}
		
	}
	
	public static void main(String[] args) {
		Tiger arr1 [] = {new Tiger("시베리안호랑이"), new Tiger("신사동호랭이"), new Tiger("타이거Jk")};
//		PrintGeneric(arr1);
		
		Panda arr2 [] = {new Panda("중국 팬더"), new Panda("쿵푸 팬더"), new Panda("래서팬더")};
//		PrintGeneric(arr2);
		
		Object arr3 [] = {new Panda("쿵푸팬더3"), new Tiger("아프리카호랑이"), new Panda("사실오랑우탄"), new Person("홍길동",30)};
//		PrintGeneric(arr3);
		PrintByObject(arr3);
		
		
		
	}

}
