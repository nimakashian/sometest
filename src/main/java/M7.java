import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

public class M7 {

    private byte data[] = new byte[1];

    public static void main(String[] args) {

        Vector v = new Vector();

        v.add("a");
        v.add("a");
        v.add("a");
        v.add("a");
        v.add("a");
        v.add("a");
        System.out.println(v.size());
        v.remove("a");
        System.out.println(v.size());
    }
}

