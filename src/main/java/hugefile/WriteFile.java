package hugefile;

import java.io.PrintWriter;

public class WriteFile {
    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter("hugefile.txt.txt");
        for (int i=5000000; i<9000000;i++){
            out.println("0"+i+"000");
            out.flush();
        }
    }
}
