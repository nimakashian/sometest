package socketprogramming;


import java.io.IOException;
import java.net.Socket;

public class TestSocketParams {



        public static void main(String[] args) throws IOException {
            //calling the constructor of the socket class
            Socket socket = new Socket();
            //enabling the SO_TIMEOUT option
            boolean on=true;
            //setTcpNoDelay() method enables or disables the SO_TIMEOUT option
//            socket.setTcpNoDelay(on);
            //getTcpNoDelay() returns the setting for SO_TIMEOUT option
            System.out.println("SO_TIMEOUT : "+socket.getTcpNoDelay());
            System.out.println("Send Buffer : "+socket.getSendBufferSize());
            System.out.println("Receive Buffer : "+socket.getReceiveBufferSize());

    }
}
