import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class M2_1 {
    public static void main(String[] args) {


        AtomicLong atomicLong = new AtomicLong(0);
        atomicLong.getAndIncrement();


        List<String> strings= new ArrayList<>();
        for (int i=0 ;i<67;i++)
            strings.add("s"+i);
        System.out.println(strings.size());
        boolean ok = true;
        int blockSize=98;
        int f=0,t=1;
        while(ok && f<strings.size()){
            t=((f+blockSize)>(strings.size()))?(strings.size()):(f+blockSize);
            String[] ss=strings.subList(f, t).toArray(new String[0]);
            for (String s: ss) {
                System.out.print(s +":");
            }
            f=t;
            System.out.println();
        }




    }


}
