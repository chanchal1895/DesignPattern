package SingletonEx;

public class SingletonSynchEx {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				Sync obj = Sync.getInstance();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				Sync obj = Sync.getInstance();

			}
		});
		t1.start();
		t2.start();
	}

}

class Sync {

	private static Sync sync;

	private Sync() {
		System.out.println("Object created");

	}

	public static synchronized Sync getInstance() {

		if (sync == null) {
			sync = new Sync();
		}
		return sync;
	}

}