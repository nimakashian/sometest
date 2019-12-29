package retried;

import java.util.Hashtable;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int key=3;

        Map<Integer ,Integer> retriedCount=new Hashtable<>();
        retriedCount.put(1,5);
        retriedCount.put(2,5);
        retriedCount.put(3,5);
        retriedCount.put(4,5);
        retriedCount.put(5,5);
        retriedCount.put(6,5);



        if(key>0) {
            Integer retriedValue=retriedCount.containsKey(key)?retriedCount.get(key):0;
            retriedCount.put(key, retriedValue==null?0:retriedValue + 1);
        }
        System.out.println(retriedCount);
    }
}
