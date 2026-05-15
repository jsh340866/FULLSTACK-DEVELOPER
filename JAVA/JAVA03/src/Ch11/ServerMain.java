package Ch11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		// 서버 소켓 생성
		ServerSocket server = new ServerSocket(9000); // IP: 서버IP(현재컴퓨터) PORT : 7000
		System.out.println("[INFO] SERVER SOCKET LISTENING");

		// 연결받는 작업
		Socket client = server.accept();
		System.out.println("[INFO] 접속자 IP : " + client.getInetAddress());

		// 기본스트림 // 바이트 단위로 받음
		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();

		// 보조스트림 // int,double,String 등을 쓸 수 있게 해줌
		DataInputStream din = new DataInputStream(in);
		DataOutputStream dout = new DataOutputStream(out);

		// THREAD
		ServerRecvThread recvThread = new ServerRecvThread(din);
		ServerSendThread sendThread = new ServerSendThread(dout);
		
		// 스레드 등록
		Thread th1 = new Thread(recvThread);
		Thread th2 = new Thread(sendThread);
		
		// 스레드 실행
		th1.start();
		th2.start();
		
		// 실행 중인 스래드 제외 기다려!
		th1.join();
		th2.join();
		
		
		//
//		Scanner sc = new Scanner(System.in); // 키보드 입력
//		String send = null; // 송신용
//		String recv = null; // 수신용
//
//		// 루프
//		while (true) {
//			System.out.print("[SERVER (q:종료)] : ");
//			send = sc.nextLine();
//			// Server -> Client(송신)
//			dout.writeUTF(send);
//			dout.flush();
//			if (send.equals("q"))
//				break;
//
//			// Client -> Server(수신)
//			try {
//				recv = din.readUTF();
//			} catch (EOFException e) {
//				System.out.println("[ERROR] 클라이언트가 연결을 끊었습니다.");
//				break;
//			}
//			if (recv.equals("q"))
//				break;
//			System.out.println("[CLIENT] : " + recv);
//
//		}
//		sc.close();
		dout.close();
		din.close();
		out.close();
		in.close();
		client.close();
		server.close();
		System.out.println("\n[SERVER] 연결 종료합니다.");

	}

}
