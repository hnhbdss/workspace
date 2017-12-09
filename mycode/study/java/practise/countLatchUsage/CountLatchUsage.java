import java.util.concurrent.CountDownLatch;

public class CountLatchUsage {

    public static class MyThread extends Thread {
	private CountDownLatch latch;
	
	public MyThread(CountDownLatch latch) {
	    this.latch = latch;
	}

	public void run() {
	    try {
		Thread.sleep(2000);
		latch.countDown();
	    }
	    catch(InterruptedException e) {
	    }
	}
    }

    public static void main(String[] args) {

	try {
	    CountDownLatch latch = new CountDownLatch(2);

	    Thread t1 = new MyThread(latch);
	    Thread t2 = new MyThread(latch);
	    t1.start();
	    t2.start();
	    latch.await();
	    System.out.println("over");
	}
	catch(InterruptedException e) {
	}
    }
}
	
