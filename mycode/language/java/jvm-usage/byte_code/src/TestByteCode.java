public class TestByteCode {
    public static void main(String[] args) {

	char[] cs = new char[3];
	int[] s = new int[3];
	TestByteCode t = new TestByteCode();
	t.print4(cs, s);
    }

    public void print4(char[] cs, int[] s) {
	int i, j, k, x;
	x = 99;
	s[0] = 77;
    }
}
