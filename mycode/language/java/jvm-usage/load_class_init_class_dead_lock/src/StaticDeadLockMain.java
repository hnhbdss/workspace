public class StaticDeadLockMain extends Thread {

    private char flag;

    public StaticDeadLockMain(char flag) {
	this.flag = flag;
	this.setName("Thread-" + flag);
    }

    @Override
    public void run() {
	try {
	    Class.forName("Static" + flag);
	}
	catch(ClassNotFoundException e) {
	    e.printStackTrace();
	}
	System.out.println(getName() + " over");
    }

    public static void main(String[] args) {

	StaticDeadLockMain a = new StaticDeadLockMain('A');
	a.start();
	StaticDeadLockMain b = new StaticDeadLockMain('B');
	b.start();
    }
}

    
			  
    
