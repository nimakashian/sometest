package searchkeyword;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        for (int i = 0; i < 7; i++)
            System.out.println(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000 * i));
        String stemp = "Hit an exception";
        String startDate = "acceptTime=Thu Dec 19";
        boolean startFlag = false;
        String nextLine = "";
        try {
            PrintWriter out = new PrintWriter("out.txt");



            File f = new File("./debugarchive");
            Scanner scanner = new Scanner((f.listFiles())[0]);
            while (scanner.hasNextLine()) {
                nextLine = scanner.nextLine();
                if (nextLine.contains(startDate) && !startFlag) {
                    startFlag = true;
                }

                if (nextLine.contains(stemp) && startFlag) {

                    out.println(   nextLine                                      );
                    out.flush();

                }
            }

        } catch (Exception e) {
            System.out.println("ERROR");
            System.out.println(nextLine);
        }
    }

}
