package Ch01;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class C07LocalDateTimeFormatMain중요 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.printf("yyyy/MM/dd 입력 : ");
//		String ymd = sc.next();
//		
//		//포매터 객체 생성(입력용)
//		DateTimeFormatter fmtin = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // 'MM' 대문자 중요
//		LocalDate date = LocalDate.parse(ymd,fmtin);
//		System.out.println(date);
//		
//		//포매터 객체 생성(출력용)
//		DateTimeFormatter fmtout = DateTimeFormatter.ofPattern("yyyy★MM★dd");
//		System.out.println("출력포맷 : " + fmtout.format(date));
		
		// -----------------------------------------------------------
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("yyyy/MM/dd HH:mm:ss 입력 : ");
		String ymd = sc.nextLine();
		
		//포매터 객체 생성(입력용)
		DateTimeFormatter fmtin = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); // 'MM' 대문자 중요
		LocalDateTime date = LocalDateTime.parse(ymd,fmtin);
		System.out.println(date);
		
		//포매터 객체 생성(출력용)
		DateTimeFormatter fmtout = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		System.out.println("출력포맷 : " + fmtout.format(date));
	}

}
