import java.io.UnsupportedEncodingException;

public class Test {

    public static void main(String[] args) {
	String name = "I am 君山";
	System.out.println(name.charAt(0));
	try {

	    byte[] iso8859 = name.getBytes("iso-8859-1");
	    toHex(iso8859);
	}
	catch(UnsupportedEncodingException e) {
	    e.printStackTrace();
	}
    }

    public static void toHex(byte[] datas) {
	for (byte data : datas) {
	    System.out.printf("%2x ", data);
	}
	System.out.println("");
    }
}
