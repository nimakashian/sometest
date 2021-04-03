public class Synchron {

    public static void main(String[] args) {

        String name = null;

        synchronized (name) {
            System.out.println("hello");
        }
    }
}
