package Ch06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class C02ReaderMain {

	public static void main(String[] args) throws Exception {
		Reader fin = new FileReader("C:\\IOTEST\\test1.txt");
		
//		while(true) 
//		{
//			int data = fin.read();
//			if(data == -1)
//				break;
//			
//			System.out.print((char)data);
//		}
		int data = 0;
		while((data = fin.read())!=-1) 
			System.out.print((char)data);
		
		fin.close();
		
		
	}

}
