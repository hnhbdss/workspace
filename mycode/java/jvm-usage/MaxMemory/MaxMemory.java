public class MaxMemory {

    public static void main(String[] args) {

	for (int i = 0; i < args.length; ++i) {
	    System.out.println("args: ["  + i + "] value:" + args[i]);
	}

	System.out.println("Max memory:" + Runtime.getRuntime().maxMemory());
    }
}
