package swithreturn;

public class Main {
    public static void main(String[] args) {
        int key =1;
        switch (key){
            case 0 :
                System.out.println("case 0");
                break;
            case 1:
                System.out.println("case 1");
                return;

        }
        System.out.println("end");
    }
}
