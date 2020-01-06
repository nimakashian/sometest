import performance.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class M2_1 {
    int reconnectionTry=0;
    public static void main(String[] args) {
        M2_1 m= new M2_1();
        Object o=m.getConnection();
        if(o == null )
            System.out.println("is null");
        else
            System.out.println( "is noooot null");
    }


    public Integer getConnection() {
        Integer connection = null;



        do {
            try {
                connection = null;
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
            if (connection != null) {

                return connection;
            }
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(reconnectionTry);
        } while (++reconnectionTry < 10);

        return null;
    }

}
