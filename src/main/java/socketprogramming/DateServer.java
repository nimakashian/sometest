package socketprogramming;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * A simple TCP server. When a client connects, it sends the client the current
 * datetime, then closes the connection. This is arguably the simplest server
 * you can write. Beware though that a client has to be completely served its
 * date before the server will be able to handle another client.
 */
public class DateServer {
    public static void main(String[] args) throws IOException {
        byte[] bytes = {0,0,0,23,0,0,0,9,0,0,0,0,0,0,0,1,0,0,0,51,0,0,1};
        String str="";
        for(byte b: bytes){
            str=str+String.valueOf(b);

        }
        System.out.println(str);
        try  {
            ServerSocket listener = new ServerSocket(50505);
            System.out.println("The date server is running..."+listener.getLocalSocketAddress());
            while (true) {
                try  {
                    Socket socket = listener.accept();
                    OutputStream out = socket.getOutputStream();
                    out.write(bytes);
                    Thread.sleep(1000);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
