package nikita.practice.thread;

public class NumberThread implements Runnable {

	private Flag flag;
	private int n;
	private Object lock;

	public NumberThread(Flag flag, Object lock) {
		super();
		this.flag = flag;
		n = 1;
		this.lock = lock;
	}

	@Override
	public void run() {
		// wait()
		while (n <= 26) {
			synchronized (lock) {
				while (!flag.isFlag()) {
					try {
						lock.wait();
						if (flag.isFlag())
							break;
						else
							continue;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			System.out.println(n++);
			flag.setFlag(false);

			synchronized (lock) {
				lock.notify();
			}
		}

	}

}
