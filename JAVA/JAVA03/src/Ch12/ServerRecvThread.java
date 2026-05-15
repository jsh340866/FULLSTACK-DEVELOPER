package Ch12;

import java.io.DataInputStream;
import java.io.EOFException;

public class ServerRecvThread implements Runnable {

	DataInputStream din;
	Sgui sgui;

	public ServerRecvThread(DataInputStream din) {
		this.din = din;
	}

	public ServerRecvThread(DataInputStream din2, Sgui sgui) {
		this.din = din;
		this.sgui = sgui;
	}

	@Override
	public void run() {
		String recv = null; // 수신용
		while (true) {
			// Client -> Server(수신)
			try {
				recv = din.readUTF();
			} catch (EOFException e) {
				System.out.println("[ERROR] 클라이언트가 연결을 끊었습니다.");
				break;
			} catch (Exception e2) {
				System.out.println("[ERROR] 기타 예외발생 : " + e2.getCause());
				break;
			}
			if (recv.equals("q")) {
				System.out.println("CLIENT q 입력함..while종료!");
				break;
			}
			System.out.println("[CLIENT] : " + recv + "\n");
			sgui.area.append("[CLIENT] : " + recv + "\n");

		}
		System.exit(-1);
	}

}
