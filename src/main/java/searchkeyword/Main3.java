package searchkeyword;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++)
            System.out.println(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000 * i));
        String stemp = "startTime";
        String startDate = "acceptTime=Sun Dec 22";
        boolean startFlag = false;
        String nextLine = "";
        try {
            PrintWriter out = new PrintWriter("out.txt");
            long max = 0L;
            long max2 = 0L;
            long max3 = 0L;
            long max4 = 0L;

            String maxStr = "";
            String maxStr2 = "";
            String maxStr3 = "";
            String maxStr4 = "";
            String maxLine = "";
            String maxLine2 = "";
            String maxLine3 = "";
            String maxLine4 = "";


            File f = new File("./debugarchive");
            Scanner scanner = new Scanner((f.listFiles())[0]);
            while (scanner.hasNextLine()) {
                nextLine = scanner.nextLine();
                if (nextLine.contains(startDate) && !startFlag) {
                    startFlag = true;
                }

                if (nextLine.contains(stemp) && startFlag) {
                    String a1 = nextLine.substring(nextLine.indexOf("acceptTime="));
                    int b1 = a1.indexOf(";");

                    String a2 = a1.substring(a1.indexOf("startTime="));
                    int b2 = a2.indexOf(";");

                    String a3 = a1.substring(a1.indexOf("createTime="));
                    int b3 = a3.indexOf(";");
                    long diff = (-Long.parseLong(a2.substring(a2.indexOf("=") + 1, b2)) + Long.parseLong(a3.substring(a3.indexOf("=") + 1, b3)));
                    if (diff > max) {
                        max = diff;
                        maxStr = a1.substring(0, b1);
                        maxLine = nextLine;
                    }

                    String a4 = a1.substring(a1.indexOf("enqueueTimes="));
                    int b4semicolon = a4.indexOf(";") == -1 ? 1000000 : a4.indexOf(";");
                    int b4comma = a4.indexOf(",") == -1 ? 1000000 : a4.indexOf(",");
                    int b4 = b4comma > b4semicolon ? b4semicolon : b4comma;
                    long diff2 = (-Long.parseLong(a3.substring(a3.indexOf("=") + 1, b3)) + Long.parseLong(a4.substring(a4.indexOf("=") + 1, b4)));
                    if (diff2 > max2) {
                        max2 = diff2;
                        maxStr2 = a1.substring(0, b1);
                        maxLine2 = nextLine;
                    }

                    long diff3=0L;
                    String a5="";
                    int b5=0;
                    try {
                        a5 = a1.substring(a1.indexOf("submitTimes="));
                        int b5semicolon = a5.indexOf(";") == -1 ? 1000000 : a5.indexOf(";");
                        int b5comma = a5.indexOf(",") == -1 ? 1000000 : a5.indexOf(",");
                        b5 = b5comma > b5semicolon ? b5semicolon : b5comma;
                        diff3 = (-Long.parseLong(a4.substring(a4.indexOf("=") + 1, b4)) + Long.parseLong(a5.substring(a5.indexOf("=") + 1, b5)));
                        if (diff3 > max3) {
                            max3 = diff3;
                            maxStr3 = a1.substring(0, b1);
                            maxLine3 = nextLine;
                        }
                    }catch(Exception e){
                        System.out.println("ERROR-submit");
                        System.out.println(nextLine);
                    }

                    long diff4=0L;
                    try {
                        String a6 = a1.substring(a1.indexOf("responseTimes="));
                        int b6 = a6.indexOf(",") == -1 ? a6.length() : a6.indexOf(",");
                        diff4 = (-Long.parseLong(a5.substring(a5.indexOf("=") + 1, b5)) + Long.parseLong(a6.substring(a6.indexOf("=") + 1, b6)));
                        if (diff4 > max4) {
                            max4 = diff4;
                            maxStr4 = a1.substring(0, b1);
                            maxLine4 = nextLine;
                        }
                    }catch(Exception e){
                        System.out.println("ERROR-response");
                        System.out.println(nextLine);
                    }





                    out.println(
                            a1.substring(0, b1) + "," +
                                    diff + "," +
                                    diff2 + "," +
                                    diff3 + "," +
                                    diff4 + "," +
                                    nextLine.substring(nextLine.indexOf(stemp))
                    );
                    out.flush();

                }
            }
            System.out.println("-----------");
            System.out.println(max);
            System.out.println(maxStr);
            System.out.println(maxLine);
            System.out.println("-----------");
            System.out.println(max2);
            System.out.println(maxStr2);
            System.out.println(maxLine2);
            System.out.println("-----------");
            System.out.println(max3);
            System.out.println(maxStr3);
            System.out.println(maxLine3);
            System.out.println("-----------");
            System.out.println(max4);
            System.out.println(maxStr4);
            System.out.println(maxLine4);
        } catch (Exception e) {
            System.out.println("ERROR");
            System.out.println(nextLine);
        }
    }


}
