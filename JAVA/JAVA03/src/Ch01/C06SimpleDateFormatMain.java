package Ch01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class C06SimpleDateFormatMain {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.printf("YYYY/MM/DD 입력 : ");
		String ymd = sc.next();
		
		System.out.println("문자열 : " + ymd);
		
		//포매터 객체 생성(입력용)
		SimpleDateFormat fmtin = new SimpleDateFormat("yyyy/MM/dd");
		Date date = fmtin.parse(ymd);
		System.out.println("fmtin : " + date);
		
		//포매터 객체 생성(출력용)
		SimpleDateFormat fmtout = new SimpleDateFormat("yyyy~MM~dd");
		System.out.println(fmtout.format(date));
		
	}

}
