package CH02;

public class C03TypeChange {

	public static void main(String[] args) {
		int num1 = 129; //00000000 00000000 00000000 10000001
		int num2 = 130; //00000000 00000000 00000000 10000010
		
		byte ch1 = (byte)num1; // 10000001 = -128 + 1 = -127
		byte ch2 = (byte)num2; // 10000010 = -128 + 2 = -126
		
		System.out.printf("%d\n", ch1);
		System.out.printf("%d\n", ch2);
		System.out.println(Integer.toBinaryString(num1));
		System.out.println(Integer.toBinaryString(num2));
		System.out.println(Integer.toBinaryString(ch1));
		System.out.println(Integer.toBinaryString(ch2));

	}

}
