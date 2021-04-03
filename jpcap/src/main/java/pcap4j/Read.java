package pcap4j;

import org.pcap4j.core.*;
import org.pcap4j.packet.Packet;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Stream;

public class Read {
    static final int log_reported_size = 104924721;
    static final String file_name = "pcap/dump_3.pcap";

    public static void main(String[] args) throws Exception {


        int i = 0;
        PcapHandle handle;
        try {
            handle = Pcaps.openOffline(file_name, PcapHandle.TimestampPrecision.NANO);
        } catch (PcapNativeException e) {
            handle = Pcaps.openOffline(file_name);
        }

        String filter = "tcp src port 3090";
        handle.setFilter(filter, BpfProgram.BpfCompileMode.OPTIMIZE);

        // Create a listener that defines what to do with the received packets
        PcapHandle finalHandle = handle;
        PacketListener listener = new PacketListener() {
            @Override
            public void gotPacket(Packet packet) {
                // Override the default gotPacket() function and process packet

                Packet p = packet;
               while(p != null && p.getHeader() != null){
                    p = p.getPayload();
                }

                if (p != null) {
                    System.out.println(finalHandle.getTimestamp());
//                    System.out.println(new String(p.getRawData(), StandardCharsets.UTF_8));
                    byte[] rawBytes = p.getRawData();
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(rawBytes);
                    try {
                        while (byteArrayInputStream.available() != 0) {
                            byte[] result = null;
                            result = readPduFromStream(byteArrayInputStream);
                            if (result != null) {
                                byte[] temp = new byte[byteArrayInputStream.available()];
//                                byteArrayInputStream.read(temp);
//                                System.out.println(new String(result) +":"+ new String(temp));
//                                System.out.println(p);
                                byteArrayInputStream.skip(byteArrayInputStream.available());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


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

        System.out.println("bye");
    }

    protected static int properRead(byte[] target, InputStream in) throws Exception {
        int targetSize = target.length;
        int read = 0;
        while (read != targetSize) {

            byte[] b = new byte[targetSize - read];
            int c = in.read(b);
            if (c == -1)
                return -1;
            System.arraycopy(b, 0, target, read, c);
            read += c;
        }
        return read;
    }

    public static byte[] readPduFromStream(InputStream in) throws Exception {
        byte[] length = new byte[4];
        int bytes = properRead(length, in);
        if (bytes != 4) {
            System.out.println("PDU is fragmented: " + bytes);
            return length;
        }

        int size = btoi(length);
        if (size == log_reported_size)
            System.out.println(" hey I got you");
        if (size > 65536) // 64k - is reasonable enough
        {
//            System.out.println("@@@adp: size of pdu=" + size );
            System.out.println("PDU is too big " + size);
            return length;
        }

        if (size < 16) {
            // dont be daft, this PDU is too small
//            System.out.println("@@@adp: size of pdu=" + size );
            System.out.println("PDU is too small " + size);
            return length;
        }

        byte[] header = new byte[12];
        //in.read(header);
        properRead(header, in);
        int commandID = btoi(header, 0, 3);


//        System.out.println("Header:");
//        System.out.println("            Length: " + hexString(length));
//        System.out.println("                id: " + hexString(header, 0, 3));
//        System.out.println("            status: " + hexString(header, 4, 7));
//        System.out.print(" ---sequence: " + hexString(header, 8, 11));
        System.out.print(" ---sequence: " + btoi(header, 8, 11) + "  ");
//        System.out.println("CommandID is " + SmppCommandCodes.toString(commandID) + "(" + commandID + ")");


        byte[] pdu = new byte[size - 16];
        properRead(pdu, in);

//        String s = hexString(pdu);
//        if (!StringUtils.isEmpty(s))
//            System.out.println("  " + hexString(pdu));


        switch (commandID) {
            case SmppCommandCodes.GENERIC_NACK:
                System.out.println("SmppCommandCodes.GENERIC_NACK");
                break;
            case SmppCommandCodes.COMMAND_BIND_RECEIVER:
                System.out.println("SmppCommandCodes.COMMAND_BIND_RECEIVER");
                break;
            case SmppCommandCodes.COMMAND_BIND_RECEIVER_RESPONSE:
                System.out.println("SmppCommandCodes.COMMAND_BIND_RECEIVER_RESPONSE");
                break;
            case SmppCommandCodes.COMMAND_BIND_TRANSMITTER:
                System.out.println("SmppCommandCodes.COMMAND_BIND_TRANSMITTER");
                break;
            case SmppCommandCodes.COMMAND_BIND_TRANSMITTER_RESPONSE:
                System.out.println("SmppCommandCodes.COMMAND_BIND_TRANSMITTER_RESPONSE");
                break;
            case SmppCommandCodes.COMMAND_QUERY_SM:
                System.out.println("SmppCommandCodes.COMMAND_QUERY_SM");
                break;
            case SmppCommandCodes.COMMAND_QUERY_SM_RESPONSE:
                System.out.println("SmppCommandCodes.COMMAND_QUERY_SM_RESPONSE");
                break;
            case SmppCommandCodes.COMMAND_SUBMIT_SM:
                System.out.println("SmppCommandCodes.COMMAND_SUBMIT_SM");
                break;
            case SmppCommandCodes.COMMAND_SUBMIT_SM_RESPONSE:
                System.out.println("SmppCommandCodes.COMMAND_SUBMIT_SM_RESPONSE");
                break;
            case SmppCommandCodes.COMMAND_DELIVER_SM:
                System.out.println("SmppCommandCodes.COMMAND_DELIVER_SM");
                break;
            case SmppCommandCodes.COMMAND_DELIVER_SM_RESPONSE:
                System.out.println("SmppCommandCodes.COMMAND_DELIVER_SM_RESPONSE");
                break;
            case SmppCommandCodes.COMMAND_UNBIND:
                System.out.println("SmppCommandCodes.COMMAND_UNBIND");
                break;
            case SmppCommandCodes.COMMAND_UNBIND_RESPONSE:
                System.out.println("SmppCommandCodes.COMMAND_UNBIND_RESPONSE");
                break;
            case SmppCommandCodes.COMMAND_REPLACE_SM:
                System.out.println("SmppCommandCodes.COMMAND_REPLACE_SM");
                break;
            case SmppCommandCodes.COMMAND_REPLACE_SM_RESPONSE:
                System.out.println("SmppCommandCodes.COMMAND_REPLACE_SM_RESPONSE");
                break;
            case SmppCommandCodes.COMMAND_CANCEL_SM:
                System.out.println("SmppCommandCodes.COMMAND_CANCEL_SM");
                break;
            case SmppCommandCodes.COMMAND_CANCEL_SM_RESPONSE:
                System.out.println("SmppCommandCodes.COMMAND_CANCEL_SM_RESPONSE");
                break;
            case SmppCommandCodes.COMMAND_BIND_TRANSCEIVER:
                System.out.println("SmppCommandCodes.COMMAND_BIND_TRANSCEIVER");
                break;
            case SmppCommandCodes.COMMAND_BIND_TRANSCEIVER_RESPONSE:
                System.out.println("SmppCommandCodes.COMMAND_BIND_TRANSCEIVER_RESPONSE");
                break;
            case SmppCommandCodes.COMMAND_ENQUIRE_LINK:
                System.out.println("SmppCommandCodes.COMMAND_ENQUIRE_LINK");
                break;
            case SmppCommandCodes.COMMAND_ENQUIRE_LINK_RESPONSE:
                System.out.println("SmppCommandCodes.COMMAND_ENQUIRE_LINK_RESPONSE");
                break;
            case SmppCommandCodes.COMMAND_DATA_SM:
                System.out.println("SmppCommandCodes.COMMAND_DATA_SM");
                break;
            case SmppCommandCodes.COMMAND_DATA_SM_RESPONSE:
                System.out.println("SmppCommandCodes.COMMAND_DATA_SM_RESPONSE");
                break;
            default:
                System.out.println("default");
        }


        return null;
    }

    public static int btoi(byte[] var0) {
        int var1 = 0;

        for (int var2 = 0; var2 < var0.length; ++var2) {
            var1 <<= 8;
            int var3 = var0[var2];
            if (var3 < 0) {
                var3 += 256;
            }

            var1 += var3;
        }

        return var1;
    }

    public static int btoi(byte[] var0, int var1, int var2) {
        int var3 = 0;

        for (int var4 = var1; var4 <= var2; ++var4) {
            var3 <<= 8;
            int var5 = var0[var4];
            if (var5 < 0) {
                var5 += 256;
            }

            var3 += var5;
        }

        return var3;
    }

    public static String hexString(byte[] b) {
        StringBuilder result = new StringBuilder();
        for (int value : b) {
            int x = value;
            if (x < 0)
                x += 256;
            String p = Integer.toHexString(x);
            if (p.length() == 1)
                p = "0" + p;
            result.append(p).append(' ');
        }
        return result.toString();
    }

    public static String hexString(byte[] b, int start, int finish) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= finish; i++) {
            int x = b[i];
            if (x < 0)
                x += 256;
            String p = Integer.toHexString(x);
            if (p.length() == 1)
                p = "0" + p;
            result.append(p).append(' ');
        }
        return result.toString();
    }
}
