import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.*;

public class M2_1 {
    public static void main(String[] args) {

        int nn = 10000;

        String statusString = String.valueOf(System.currentTimeMillis()) +
                ',' +
                (nn / 1000000) + //lang
                ',' +
                (nn % 1000000)/10000 + //total
                ',' +
                0 + // ok parts
                ',' +
                (0); //failed
        System.out.println(statusString);
    }

    public static void s() throws InterruptedIOException, NegativeArraySizeException, SocketException, Exception {
        throw new IOException();
    }
}
