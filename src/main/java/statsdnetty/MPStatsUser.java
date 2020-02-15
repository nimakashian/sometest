package statsdnetty;

import java.net.DatagramSocket;
import java.net.SocketException;

public class MPStatsUser  {
    MPStats mpStats=MPStats.getInstance();
    public static void main(String[] args) {
        new MPStatsUser();
        new MPStatsUser();
        new MPStatsUser1();
        new MPStatsUser1();
        new MPStatsUser1();
        new MPStatsUser2();
        new MPStatsUser2();
        new MPStatsUser2();
        new MPStatsUser2();
        new MPStatsUser2();
        new MPStatsUser2();
        System.out.println(MPStats.getAgentsUsers());

        try {
            DatagramSocket datagramSocket =new DatagramSocket();
            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
