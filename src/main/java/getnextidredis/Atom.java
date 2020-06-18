package getnextidredis;

import java.util.concurrent.atomic.AtomicLong;

public class Atom {

    public static void main(String[] args) {
        IdGenerator idGenerator= new IdGenerator();
        //t1 start
        IdUser i1 = new IdUser("i1",idGenerator);
        //t2 start
        IdUser i2 = new IdUser("i2",idGenerator);

    }


}
