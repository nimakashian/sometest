package increasingincreement;

public class Main {
    public static void main(String[] args) {
        int[] seq={1,3,6,7,11,13,3,23,19};

        int durationThreshold=5;
        int curThread=0;
        int exThread=0;
        int incThread=0;
        for (int i : seq){
            exThread=curThread;
            curThread=i/durationThreshold;
            incThread=curThread-exThread;

            System.out.println("new thread "+i+" :"+exThread+" :"+curThread+" :"+incThread);
        }
    }
}
