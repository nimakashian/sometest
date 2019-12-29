package encoding;

import java.io.*;

public class Main1 {



    public static void main(String[] args) throws Exception {
        String str ="فروردین";
        StringBuilder b = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c >= 128)
                b.append("\\u").append(String.format("%04X", (int) c));
            else
                b.append(c);
        }

        System.out.println(b);
    }
//    String result="\u00D9\uFFFD\u00D8\u00B1\u00D9\u02C6\u00D8\u00B1\u00D8\u00AF\u00DB\u0152\u00D9\u2020";

}
