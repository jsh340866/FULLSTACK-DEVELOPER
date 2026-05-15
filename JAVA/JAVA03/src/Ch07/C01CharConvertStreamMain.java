package Ch07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class C01CharConvertStreamMain {

	public static void main(String[] args) throws IOException {
		
		String str = "문자 변환 스트림테스트!";
		//---------------------
		// OUTPUT 보조스트림
		//---------------------
//		OutputStream out = new FileOutputStream("C:\\IOTEST\\test.txt");
////		out.write(str.getBytes());	// String -> byte[] 변환
////		out.flush();
//		OutputStreamWriter wout = new OutputStreamWriter(out);
////		wout.write(str);
////		wout.flush();
//		
//		BufferedWriter bout = new BufferedWriter(wout);
//		bout.write(str);
//		bout.flush();
//	
//		out.close();

		
		
		//---------------------
		// INPUT 보조스트림
		//---------------------
		InputStream in = new FileInputStream("C:\\IOTEST\\test.txt");
		InputStreamReader rin = new InputStreamReader(in);
		BufferedReader bin = new BufferedReader(rin);
		
		while(true) {
			int data = bin.read();
			if(data==-1) {
				break;
			}
			System.out.println((char)data);
		}
		
		
		
	}

}
