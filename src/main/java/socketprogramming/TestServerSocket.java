package socketprogramming;


import java.io.IOException;
import java.net.ServerSocket;

public class TestServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2775);
        serverSocket.accept();
        System.out.println("hi");

    }
}
