package getnextidredis;

public class IdUser implements Runnable {
    Thread t;
    IdGenerator idGenerator;
    String name;

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            long id = idGenerator.getNextId();
            System.out.println(name + ":" + id);
            if (id == -10) flag = false;
        }

    }

    public IdUser(String name, IdGenerator idGenerator) {
        this.name = name;
        this.idGenerator = idGenerator;
        t = new Thread(this);
        t.start();

    }
}
