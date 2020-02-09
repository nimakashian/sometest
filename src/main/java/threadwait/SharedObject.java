package threadwait;

import java.util.Hashtable;

public class SharedObject {

    static Hashtable<Integer, String> integerStringHashtable;


    public static void main(String[] args) {
        testHash();
    }
    static void testHash(){
        for (int i=0;i<1000000;i++){

            integerStringHashtable.put(i,"hi");
        }
    }

}
