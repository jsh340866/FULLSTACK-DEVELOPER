package Ch12;

import java.io.DataInputStream;
import java.io.EOFException;

public class ClientRecvThread implements Runnable {

	DataInputStream din;
	Cgui cgui;

//	public ClientRecvThread(DataInputStream din) {
//		this.din = din;
//	}

	public ClientRecvThread(DataInputStream din2, Cgui cgui) {
		this.din = din2;
		this.cgui = cgui;
	}

	@Override
	public void run() {
		String recv = null;		// 수신용
		while (true) {
			// Client -> Server(수신)
			try {
				recv = din.readUTF();
			} catch (EOFException e) {
				System.out.println("[ERROR] 서버가 연결을 끊었습니다.");
				break;
			} catch (Exception e2) {
				System.out.println("[ERROR] 기타 예외발생 : " + e2.getCause());
				break;
			}
			if (recv.equals("q"))
				break;
			System.out.println("[SERVER] : " + recv + "\n");
			cgui.area.append("[SERVER] : " + recv + "\n");

		}

	}


}
