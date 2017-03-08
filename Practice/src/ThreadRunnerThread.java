

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ThreadRunnerThread extends Thread {

	int name;
	public static int allowed = 0;
	public static String s = "";
	public static Object lock = new Object();
	public static List<Thread> queue= new LinkedList<Thread>();
;
	public ThreadRunnerThread(int name) {
		// super(name);
		this.name = name;
		// this.start();
		queue.add(this.name, new Thread(this, new Integer(name).toString()));
		
	}
	public void initiateThread() throws InterruptedException{
		for(Thread t:queue){
			Thread.sleep(3000);
			synchronized (lock) {

					t.start();
					//t.join();
				
			}
		}
	}

	public void run() {
		for(int i = 0;i< 100;i++){
			if(i==99){
				System.out.println(" I am "+Thread.currentThread().getName());
			}
		}
		

	}

	public static void main(String[] args) throws InterruptedException {
//		for (int i = 0; i < 100; i++) {
//			ThreadRunnerThread o = new ThreadRunnerThread(new Integer(i));
//			o.initiateThread();
//
//		}
		int i = 0;
		for(i=0;i<10;i++){}
		System.out.println(i);
		LinkedList<String> a = new LinkedList<String>();
		Iterator<String> it = a.iterator();
		Vector <String> x = new Vector<String>();
		
	}
}
