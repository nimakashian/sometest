import com.sun.security.ntlm.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SmppSimulator {
    public static void main(String[] args) throws Exception {
        ServerSocket ss=new ServerSocket(49494);
        while(true){
        try {


                System.out.println("started:");
                Socket s=ss.accept();
                System.out.println("-------");
                InputStreamReader inputStreamReader=new InputStreamReader(s.getInputStream());
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String st=bufferedReader.readLine();
                System.out.println(st);

                s.getOutputStream().write(12);
                s.getOutputStream().flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
}
