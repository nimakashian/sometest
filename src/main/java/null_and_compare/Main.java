package null_and_compare;

public class Main {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s);
        try {
            System.out.println(s.length());
        }catch (NullPointerException e){
            System.err.println(e);
        }
    }
}
