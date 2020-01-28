import javax.print.attribute.IntegerSyntax;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.*;

public class M2_1 {
    public static void main(String[] args) {
        Integer msg =new Integer(12);
        SortedMap<Long, List<Integer>> expiresMap =
                Collections.synchronizedSortedMap(new TreeMap<Long, List<Integer>>());
        expiresMap.put(1000L,new ArrayList<>());

        long key = 1000;

        List<Integer> expiresList = null;
        synchronized (expiresMap) {
            expiresList = expiresMap.get(key);
        }
        if (expiresList != null) {
            boolean removed = false;
            synchronized (expiresList) {
                removed = expiresList.remove(msg);
            }
            if (removed) {


                if (expiresList.size() == 0) {
                    synchronized (expiresMap) {
                        expiresMap.remove(key);
                    }
                }
            }
        }

    }

    public static void s() throws InterruptedIOException, NegativeArraySizeException, SocketException, Exception {
        throw new IOException();
    }
}
