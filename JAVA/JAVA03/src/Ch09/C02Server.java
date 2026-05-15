package Ch09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C02Server {

	public static void main(String[] args) throws IOException {
		//서버 소켓 생성
		ServerSocket server = new ServerSocket(7000); // IP: 서버IP(현재컴퓨터) PORT : 7000
		System.out.println("[INFO] SERVER SOCKET LISTENING");
		
		//연결받는 작업
		Socket client = server.accept();
		System.out.println("[INFO] 접속자 IP : " + client.getInetAddress());
		
		//기본스트림 // 바이트 단위로 받음
		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		
		//보조스트림 // int,double,String 등을 쓸 수 있게 해줌
		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);
		
		//
		Scanner sc = new Scanner(System.in);	//키보드 입력
		String send = null;		//송신용
		String recv = null;		//수신용
		
		//루프
		while(true) {
			System.out.print("[SERVER (q:종료)] : ");
			send = sc.nextLine();
			//Server -> Client(송신)
			dout.writeUTF(send);
			dout.flush();
			if(send.equals("q"))
				break;
			//Client -> Server(수신)
			try {
				recv = din.readUTF();
			} catch(EOFException e) {
				System.out.println("[ERROR] 클라이언트가 연결을 끊었습니다.");
				break;
			}
			if(recv.equals("q"))
				break;
			System.out.println("[CLIENT] : " + recv);
			
		}
		sc.close();
		dout.close();
		din.close();
		out.close();
		in.close();
		client.close();
		server.close();
		System.out.println("[SERVER] 연결 종료합니다.");
		
		
	}

}
