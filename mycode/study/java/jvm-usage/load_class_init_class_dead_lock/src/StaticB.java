public class StaticB {
    static {
	try {
	    Thread.sleep(5000);
	}
	catch(InterruptedException e) {
	    e.printStackTrace();
	}
	try {
	    Class.forName("StaticA");
	}
	catch(ClassNotFoundException e) {
	    e.printStackTrace();
	}
	System.out.println("StaticB init ok");
    }
}
