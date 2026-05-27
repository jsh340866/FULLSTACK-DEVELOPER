package Ch06;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class C03FileCopyMain {

	private static final String PATH ="C:\\IOTEST\\" ;
	
	public static void main(String[] args) throws IOException {
		//args[0] : source filename
		//args[1] : destination filename
		Reader fin = new FileReader(PATH + args[0]);
		Writer fout = new FileWriter(PATH + args[1]);
		
		int data = 0;
		while((data = fin.read())!=-1) {
			
			System.out.print((char)data);
			fout.write((char)data);
			fout.flush();
			
		}
		fout.close();
		fin.close();

	}

}
