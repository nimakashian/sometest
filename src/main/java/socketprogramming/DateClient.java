package socketprogramming;

import java.util.Scanner;
import java.net.Socket;
import java.io.IOException;

/**
 * A command line client for the date server. Requires the IP address of
 * the server as the sole argument. Exits after printing the response.
 */
public class DateClient {
    public static void main(String[] args) throws IOException {
        while(true) {

            Socket socket = new Socket("localhost", 50505);

            Scanner in = new Scanner(socket.getInputStream());
            System.out.println(socket.getLocalAddress()+"/"+socket.getLocalPort()+"-Server response: " + in.nextLine());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }


        }
    }
}
/*
0,0,0,23,0,0,0,9,0,0,0,0,0,0,0,1,0,0,0,51,0,0,1
 */