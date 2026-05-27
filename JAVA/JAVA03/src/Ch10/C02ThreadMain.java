package Ch10;

public class C02ThreadMain {

	public static void main(String[] args) {

		// 1 Runnable Intefrace를 이용한 스레드 분할

		// 1)
		C02Worker1 w1 = new C02Worker1();
		C02Worker2 w2 = new C02Worker2();

		// 2)
		Thread th1 = new Thread(w1);
		Thread th2 = new Thread(w2);

		// 3)
		th1.start();
		th2.start();

		// 2 Thread Class를 이용한 스레드 분할
		new Thread() {

			@Override
			public void run() {

				for (int i = 0; i < 5; i++) {
					System.out.println("TASK03...");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}.start();

	}

}
