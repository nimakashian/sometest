import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class M2 {
    public static void main(String[] args) {
        //TODO @
        String retryTimes="1576740019436,1576740227128";

        StringTokenizer stringTokenizer=new StringTokenizer(retryTimes);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        while(stringTokenizer.hasMoreTokens())
            System.out.println(simpleDateFormat.format(new Date(Long.parseLong(stringTokenizer.nextToken(",")))));

    }
}
