

public class ThreadsRunnable implements Runnable {
	String name;
	private static final Object lock = 1;
//	Thread runner;
	public ThreadsRunnable(String name){
		this.name = name;
//		runner = new Thread(this,name);
//		runner.start();
		Thread t = new Thread(this,name);
		t.start();
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(lock){
		for(int i = 0;i< 100;i++){
			if(i ==99){
				System.out.println("This is Thread "+ this.name);
			}
		}
		}
			
		}
	public static void main(String[] args){
		for(int i = 0;i< 100;i++){
//			Thread o = new Thread(new ThreadsRunnable(new Integer(i).toString()));
			ThreadsRunnable o = new ThreadsRunnable(new Integer(i).toString());
		}
	}

}
