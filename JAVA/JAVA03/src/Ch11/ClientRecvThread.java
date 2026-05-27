package Ch11;

import java.io.DataInputStream;
import java.io.EOFException;

public class ClientRecvThread implements Runnable {

	DataInputStream din;

	public ClientRecvThread(DataInputStream din) {
		this.din = din;
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
			System.out.println("[SERVER] : " + recv);

		}

	}


}
