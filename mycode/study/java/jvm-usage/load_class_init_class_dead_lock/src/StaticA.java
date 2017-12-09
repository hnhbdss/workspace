public class StaticA {
    static {
	try {
	    Thread.sleep(5000);
	}
	catch(InterruptedException e) {
	    e.printStackTrace();
	}
	try {
	    Class.forName("StaticB");
	}
	catch(ClassNotFoundException e) {
	    e.printStackTrace();
	}
	System.out.println("StaticA init ok");
    }
}
    
