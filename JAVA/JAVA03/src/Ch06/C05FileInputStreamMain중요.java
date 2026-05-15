package Ch06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class C05FileInputStreamMain중요 {

	public static void main(String[] args) throws IOException {
		InputStream fin = new FileInputStream("C:\\IOTEST\\07장_입출력.pdf");
		
		long startTime = System.currentTimeMillis();
		byte[] buffer = new byte[1024];
		
		while(true) 
		{
			int data = fin.read(buffer);
			if(data == -1)
				break;
			
//			System.out.print(data);
		}

		fin.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("소요시간 : " + (endTime - startTime) + " ms");

	}

}
