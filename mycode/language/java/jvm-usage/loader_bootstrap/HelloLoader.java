public class HelloLoader {
    public void print() {
	System.out.println("i am in bootstap loader");
	//System.out.println("i am in app loader");
	System.out.println("loader:" + HelloLoader.class.getClassLoader());
    }
}
