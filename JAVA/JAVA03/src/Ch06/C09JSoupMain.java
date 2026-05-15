package Ch06;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.UUID;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class C09JSoupMain {

	public static void main(String[] args) throws IOException {
		//https://g-sa.koreaisacademy.com/
		
		Connection conn = Jsoup
							.connect("https://g-sa.koreaisacademy.com/")
							.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/147.0.0.0 Safari/537.36")
							.timeout(0)
							.ignoreHttpErrors(true)
							.followRedirects(true);
		
		
		//DOM 객체 받기
		Document document =  conn.get();
//		System.out.println(document);		
		
		//이미지 요소만 추출
		Elements elements =  document.getElementsByTag("img");
		System.out.println("총 img size : " + elements.size());
		
		
		elements.forEach((el)->{
			
			try {
	//			System.out.println(el);
				String img_url = el.getElementsByAttribute("src").attr("src");
				String img_path= "https://g-sa.koreaisacademy.com";
				if(!img_url.startsWith("http")) {
					img_path+=img_url;
					System.out.println(img_path);
				}
				
				URL url = (new URI(img_path)).toURL();
				
				//기본스트림 추출
				InputStream in = url.openStream();
				//보조스트림 추가
				BufferedInputStream bin = new BufferedInputStream(in);
				
				OutputStream out = null;
				
				if(img_url.contains(".png"))
					out = new FileOutputStream("c:\\IOTEST\\"+UUID.randomUUID()+".png");
				else if(img_url.contains(".svg"))
					out = new FileOutputStream("c:\\IOTEST\\"+UUID.randomUUID()+".svg");
				else if(img_url.contains(".gif"))
					out = new FileOutputStream("c:\\IOTEST\\"+UUID.randomUUID()+".gif");
				else if(img_url.contains(".webp"))
					out = new FileOutputStream("c:\\IOTEST\\"+UUID.randomUUID()+".webp");
				else if(img_url.contains(".jpg"))
					out = new FileOutputStream("c:\\IOTEST\\"+UUID.randomUUID()+".jpg");
				else
					out = new FileOutputStream("c:\\IOTEST\\"+UUID.randomUUID()+".png");
				
				
				while(true) {
					int data = bin.read();
					if(data==-1)
						break;
					out.write((byte)data);
					out.flush();
				}
				out.close();
				bin.close();
				in.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		});
		
		
		
		
		
	}

}
