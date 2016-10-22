package Model;

public class BuoyModel extends Thread{
	
	private static int CLOCK = 20000;
	
	@Override
	public void run() {
		try {
			sleep(CLOCK);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}
}
