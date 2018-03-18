package nikita.practice.thread;

public class CharacterThread implements Runnable {

	private Flag flag;
	private Character c;
	private Object lock;

	public CharacterThread(Flag flag, Object lock) {
		super();
		this.flag = flag;
		this.lock = lock;
		c = 'A';
	}

	@Override
	public void run() {
		// wait()
		while (c <= 'Z') {
			synchronized (lock) {
				while (flag.isFlag()) {
					try {
						lock.wait();
						if (!flag.isFlag())
							break;
						else
							continue;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			System.out.println(c++);
			flag.setFlag(true) ;

			synchronized (lock) {
				lock.notify();
			}

		}
	}

}
