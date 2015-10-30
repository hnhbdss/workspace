import java.lang.ref.*;

public class TestSoftRef {
    public static class User {
	public int id = 0;
	public String name = "";

	public User(int id, String name) {
	    this.id = id;
	    this.name = name;
	}

	public String toString() {
	    return "User(id:" + id + ",name:" + name + ")";
	}

    }

    public static void main(String[] args) {

	User a = new User(1, "1");
	SoftReference<User> softUser = new SoftReference<User>(a);
	a = null;
	System.out.println(softUser.get());
	System.gc();
	System.out.println(softUser.get());

	byte[] b = new byte[1024 * 925 * 7];
	System.gc();
	System.out.println(softUser.get());
    }
}
