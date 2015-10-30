import java.util.*

public class UsingCollection {
    public static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<String>();
        Collection<String> col = lst;

        lst.add("one");
        lst.add("two");
        lst.add("three");

        lst.remove(0);
        lst.remove(0);
        System.out.println("lst size:" + lst.size());


    }
}