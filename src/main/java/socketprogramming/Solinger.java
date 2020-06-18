package socketprogramming;

import org.eclipse.jetty.server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Solinger {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(14000);


        Socket ss = socket.accept();

        ss.close();
        try {
            ss.setSoLinger(true, 0);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        ss.close();
        System.out.println("end");

    }
}
