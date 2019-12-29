package encoding;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        OutputStream output = new FileOutputStream("DAteUtilOut.java");
        InputStream input = new FileInputStream("D:\\IdeaProjects\\mp\\plugins\\client-plugins\\src\\main\\java\\com\\textgateway\\mp\\plugin\\client\\util\\DateUtil.java");
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
        String in;
        while((in =reader.readLine())!=null)

        {
            StringBuilder b = new StringBuilder();

            for (char c : in.toCharArray()) {
                if (c >= 128)
                    b.append("\\u").append(String.format("%04X", (int) c));
                else
                    b.append(c);
            }
            writer.write(in);
            writer.newLine();

        }
        writer.flush();
        writer.close();
    }
}
