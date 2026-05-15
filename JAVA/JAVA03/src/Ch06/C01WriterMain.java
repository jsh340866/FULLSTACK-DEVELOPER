package Ch06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

//C:\IOTEST
public class C01WriterMain {
	public static void main(String[] args) throws IOException {
		//Writer fout = new FileWriter("C:\\IOTEST\\test1.txt",false);	//덮어쓰기
		Writer fout = new FileWriter("C:\\IOTEST\\test1.txt",true);	//추가하기
		
		fout.write("HELLOWORLD\n");
		fout.write("HELLOWORLD\n");
		fout.write("HELLOWORLD\n");
		
		fout.flush(); //!!!!!
		fout.close();
	}
}
