package SingletonEx;

public class SingletonDoubleLockEx {
	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				DCheckLock obj = DCheckLock.getInstance();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				DCheckLock obj = DCheckLock.getInstance();

			}
		});
		t1.start();
		t2.start();
	}
}

class DCheckLock {
	
	private static DCheckLock obj;

	private DCheckLock() {
		System.out.println("Object created");
	}

	public static DCheckLock getInstance() {

		if (obj == null) {

			synchronized (DCheckLock.class) {
				if (obj == null)
					obj = new DCheckLock();
			}
		}
		return obj;
	}
}