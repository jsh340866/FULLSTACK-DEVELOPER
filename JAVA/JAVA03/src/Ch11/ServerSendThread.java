package Ch11;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ServerSendThread implements Runnable {

	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);
	String send = null;

	public ServerSendThread(DataOutputStream dout) {
		this.dout = dout;
	}

	@Override
	public void run() {

		String send = null;

		while (true) {
			System.out.print("[SERVER (q:종료)] : ");
			send = sc.nextLine();
			// Server -> Client(송신)
			try {
				dout.writeUTF(send);
				dout.flush();
//				if (send.equals("q"))
//					break;	// q종료는 recv에서만 이중확인은 꼬임.
			} catch (IOException e) {
				System.out.println("[EXCEPTION] : " + e.getCause());
				break;
//				e.printStackTrace();
			}

		}
//		sc.close();

	}

}
