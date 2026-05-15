package Ch11;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ClientSendThread implements Runnable {

	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);
	
	public ClientSendThread(DataOutputStream dout) {
		this.dout = dout;
	}

	@Override
	public void run() {

		String send = null;

		while (true) {
			System.out.print("[CLITENT (q:종료)] : ");
			send = sc.nextLine();
			// Server -> Client(송신)
			try {
				dout.writeUTF(send);
				dout.flush();
//				if (send.equals("q"))
//					break;
			} catch (IOException e) {
				System.out.println("[EXCEPTION] : " + e.getCause());
				break;
//				e.printStackTrace();
			}

		}
//		sc.close();

	}

}
