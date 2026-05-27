package Ch10;

public class C03Worker1 implements Runnable {

	C03GUI gui;
	
	public C03Worker1(C03GUI c03gui) {
		this.gui = c03gui;
	}

	@Override
	public void run() {

		try {

			for (int i = 0;; i++) {
				System.out.println("TASK01..." + i);
				gui.area1.append("Task01..." + i + "\n");
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("[EXCEPTION] WORKER01 THREAD INTERRUPTED..");
		}

	}

}
