package threads;

public class ClassToRun implements Runnable {

	private String name;
	private static int count;
	
	public ClassToRun(String name) {
		this.name=name;
		count++;
	}
	@Override
	public void run() {
		
		for(int i=0;i<count;i++) {
			System.out.println(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
