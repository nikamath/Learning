package nikita.practice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPractice {
	static  volatile Flag obj = new Flag(true);
	public static void main(String[] args) {
		Object lock = new Object();
		CharacterThread cThread = new CharacterThread(obj, lock);
		NumberThread nThread  = new NumberThread(obj, lock);
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
		newFixedThreadPool.submit(nThread);
		newFixedThreadPool.submit(cThread);
		newFixedThreadPool.shutdown();
	}

}
