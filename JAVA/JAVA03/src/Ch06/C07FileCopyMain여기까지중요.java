package Ch06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class C07FileCopyMain여기까지중요 {
	
	private static final String PATH ="C:\\IOTEST\\" ;
	
	public static void main(String[] args) throws IOException {
		//args[0] : source filename
		//args[1] : destination filename
		
		InputStream fin = new FileInputStream(PATH + args[0]);
		OutputStream fout = new FileOutputStream(PATH + args[1]);
		
		long startTime = System.currentTimeMillis();
		
		int data = 0;
		
		byte [] buff = new byte[4096];
		
 		while((data = fin.read(buff))!=-1) {
			
			fout.write(buff,0,data);
			fout.flush();
			
		}
		fout.close();
		fin.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("소요시간 : " + (endTime - startTime) + "ms");
	}

}
