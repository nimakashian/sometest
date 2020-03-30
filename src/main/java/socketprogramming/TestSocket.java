package socketprogramming;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TestSocket {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",49494);
        OutputStream outputStream = s.getOutputStream();
        outputStream.write("hihihi".getBytes());
        outputStream.flush();
//        Socket s1 = new Socket("127.0.0.1",49494);
//        OutputStream outputStream1 = s.getOutputStream();
//        outputStream1.write("hihihi".getBytes());
//        outputStream1.flush();
        System.out.println("hi");
    }
}
