import performance.MyArrayDequeu;

public class M1 {
    public static void main(String[] args) {
        MyArrayDequeu<Integer> mySynchronizedArrayDequeu=new MyArrayDequeu<>();
        for (int i=0; i<20 ; i++){
            mySynchronizedArrayDequeu.addLast(i);
        }
        mySynchronizedArrayDequeu.removeFirst();
        mySynchronizedArrayDequeu.removeFirst();
        mySynchronizedArrayDequeu.removeFirst();
        mySynchronizedArrayDequeu.removeFirst();
        mySynchronizedArrayDequeu.removeFirst();
        mySynchronizedArrayDequeu.removeFirst();
        mySynchronizedArrayDequeu.removeFirst();

        for (int i=0; i<30 ; i++){
            mySynchronizedArrayDequeu.addLast(i);
        }
    }
}
