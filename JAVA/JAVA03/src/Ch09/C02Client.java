package Ch09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class C02Client {

	public static void main(String[] args) throws IOException {
		// 서버 생성
		Socket server = new Socket("192.168.5.7", 7000);
		System.out.println("[CLIENT] SERVER와의 연결이 완료되었습니다.");

		// 기본스트림 // 바이트 단위로 받음
		InputStream in = server.getInputStream();
		OutputStream out = server.getOutputStream();

		// 보조스트림 // int,double,String 등을 쓸 수 있게 해줌
		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);

		//
		Scanner sc = new Scanner(System.in); // 키보드 입력
		String send = null; // 송신용
		String recv = null; // 수신용

		// 루프
		while (true) {
			// Server -> Client(송신)
			try {
				recv = din.readUTF();
			} catch (EOFException e) {
				System.out.println("[ERROR] 클라이언트가 연결을 끊었습니다.");
				break;
			}
			if (recv.equals("q"))
				break;
			System.out.println("[SERVER] : " + recv);
			
			
			System.out.print("[CLIENT (q:종료)] : ");
			send = sc.nextLine();
			// Client -> Server(수신)
			dout.writeUTF(send);
			dout.flush();
			if (send.equals("q"))
				break;
			

		}
		sc.close();
		dout.close();
		din.close();
		out.close();
		in.close();
		server.close();
		System.out.println("[CLIENT] 연결 종료합니다.");
	}

}
