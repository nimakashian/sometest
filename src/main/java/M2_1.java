import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.*;

public class M2_1 {
    public static void main(String[] args) {

        Integer[] dest = new Integer[1000000];

        for (Integer n : dest) {
            n = new Integer(500000);
        }
        long avg;

        long t1 = System.nanoTime();
        Integer[] src = new Integer[dest.length];
        int i = 0;
        for (Integer n : dest) {
            n = dest[i++];
        }
        long t2=System.nanoTime();

    }

    public static void s() throws InterruptedIOException, NegativeArraySizeException, SocketException, Exception {
        throw new IOException();
    }
}
