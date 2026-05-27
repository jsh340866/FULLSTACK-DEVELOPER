package Ch05;

class Point2D {
	int x;
	int y;

	// 디폴트 생성자
	Point2D() {
		System.out.println("Point2D 디폴트생성자 호출!");
	}
	Point2D(int x) {
		this.x = x;
		System.out.println("Point2D(int x) 생성자 호출!");
	}
	Point2D(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Point2D(int x, int y) 생성자 호출!");
	}

	// toString() 재정의
	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}

}

class Point3D extends Point2D {
	int z;

	Point3D() {
		super();		//상위클래스 디폴트 생성자 호출(기본값) // 생략되어도 이미 들어있음
		System.out.println("Point3D 디폴트생성자 호출!");
	}
	Point3D(int x){
//		super.x = x;
//		this.x = x;
		super(x);
		System.out.println("Point3D(int x) 생성자 호출!");
	}
	Point3D(int x, int y){
		super(x,y);
		System.out.println("Point3D(int x, int y) 생성자 호출!");
	}
	Point3D(int x, int y, int z){
		super(x,y);
		this.z = z;
		System.out.println("Point3D(int x, int y, int z) 생성자 호출!");
	}
	@Override
	public String toString() {
		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
	}

}

public class C02InheritanceMain {

	public static void main(String[] args) {
		Point3D ob = new Point3D(10,20,30);
		
		System.out.println(ob);
		
		
	}

}
