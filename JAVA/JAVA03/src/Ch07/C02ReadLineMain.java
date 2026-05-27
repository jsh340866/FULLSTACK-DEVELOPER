package Ch07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class C02ReadLineMain {

	public static void main(String[] args) throws IOException {
		
		//
//		Writer out = new FileWriter("C:\\IOTEST\\test2.txt");
//		out.write("a");
//		out.write("b");
//		out.write("c");
//		out.flush();
//		out.close();
		
//		BufferedWriter bout = new BufferedWriter(out);
//		PrintWriter pout = new PrintWriter(bout);
//		pout.print("HELLO WORLD");
//		pout.print("HELLO WORLD");
//		pout.print("HELLO WORLD");
//		pout.print("HELLO WORLD");
		
//		
//		pout.flush();
//		pout.close();
//		bout.close();
//		out.close();
		
		Reader in = new FileReader("C:\\IOTEST\\test2.txt");
		BufferedReader bin = new BufferedReader(in);
		
		while(true) {
			//기본 Reader
//			int data = in.read();
//			if(data==-1) {
//				break;
//			}
//			System.out.print((char)data);
			
			String msg = bin.readLine();
			if(msg==null)
				break;
			System.out.println(msg);
		}
		bin.close();
		in.close();
		
		
	}

}
