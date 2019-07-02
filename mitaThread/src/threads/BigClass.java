package threads;

public class BigClass {
	
	public static void main(String[] args) {
		Thread t1=new Thread(new ClassToRun("Bolchis"));
		Thread t2=new Thread(new ClassToRun("Popica"));
		Thread t3=new Thread(new ClassToRun("Vali"));
		Thread t4=new Thread(new ClassToRun("Heredea"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
	}
}
