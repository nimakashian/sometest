package pcap4j;

import com.sun.jna.Platform;
import org.pcap4j.core.*;
import org.pcap4j.packet.Packet;
import org.pcap4j.util.NifSelector;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

public class Main {


    static PcapNetworkInterface getNetworkDevice() {
        PcapNetworkInterface device = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("10.10.22.41");
//            device = Pcaps.getDevByAddress(inetAddress);
            device = new NifSelector().selectNetworkInterface();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return device;
    }

    static List<PcapNetworkInterface> allDevices() throws Exception {
        List<PcapNetworkInterface> allDevs = null;

        try {
            allDevs = Pcaps.findAllDevs();
        } catch (PcapNativeException e) {
            throw new IOException(e.getMessage());
        }

        if (allDevs == null || allDevs.isEmpty()) {
            throw new IOException("No NIF to capture.");
        }

        return allDevs;
    }

    public static void main(String[] args) throws Exception {
        for (PcapNetworkInterface d : allDevices()) {
            String status = " ";
            if (d.isRunning())
                status += " is running";
            if (d.isUp())
                status += " is up";
            if (d.isLocal())
                status += " is local";
            if (d.isLoopBack())
                status += " is loopback";
            System.out.println(d.getName() + status);
        }

        PcapNetworkInterface device = getNetworkDevice();
        System.out.println("You chose: " + device);

        if (device == null) {
            System.out.println("No device chosen.");
            System.exit(1);
        }

        // Open the device and get a handle
        int snapshotLength = 65536; // in bytes
        int readTimeout = 50; // in milliseconds
        final PcapHandle handle;
        handle = device.openLive(snapshotLength, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, readTimeout);

        String filter = "tcp port 2775";
        handle.setFilter(filter, BpfProgram.BpfCompileMode.OPTIMIZE);

        // Create a listener that defines what to do with the received packets
        PacketListener listener = new PacketListener() {
            @Override
            public void gotPacket(Packet packet) {
                // Override the default gotPacket() function and process packet

                Packet p = packet.getPayload().getPayload().getPayload();
                if (p != null) {
                    System.out.println(handle.getTimestamp());
                    System.out.println(p);

                }

//                byte[] bytes = packet.getRawData();
//                try {
//                    TcpPacket tcpPacket = TcpPacket.newPacket(bytes,0 , bytes.length);
//                    System.out.println();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
        };

        // Tell the handle to loop using the listener we created
        try {
            int maxPackets = -1;
            handle.loop(maxPackets, listener);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print out handle statistics
        PcapStat stats = handle.getStats();
        System.out.println("Packets received: " + stats.getNumPacketsReceived());
        System.out.println("Packets dropped: " + stats.getNumPacketsDropped());
        System.out.println("Packets dropped by interface: " + stats.getNumPacketsDroppedByIf());
        // Supported by WinPcap only
        if (Platform.isWindows()) {
            System.out.println("Packets captured: " + stats.getNumPacketsCaptured());
        }


        // Cleanup when complete
        handle.close();


    }


}
