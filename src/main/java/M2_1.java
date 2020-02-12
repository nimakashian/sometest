import java.util.ArrayDeque;
import java.util.Date;

public class M2_1 {
    public static void main(String[] args) {

        long expires = (new Date()).getTime();

        long key = getKey(expires);
        System.out.println(key);


    }

    private static long getKey(long expires) {
        return (expires / 1000) / 60;
    }
}
