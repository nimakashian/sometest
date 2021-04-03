package pcap4j;

public class SmppCommandCodes {
    public static final int GENERIC_NACK = 0x80000000;

    public static final int COMMAND_BIND_RECEIVER = 0x00000001;
    public static final int COMMAND_BIND_RECEIVER_RESPONSE = 0x80000001;

    public static final int COMMAND_BIND_TRANSMITTER = 0x00000002;
    public static final int COMMAND_BIND_TRANSMITTER_RESPONSE = 0x80000002;

    public static final int COMMAND_QUERY_SM = 0x00000003;
    public static final int COMMAND_QUERY_SM_RESPONSE = 0x80000003;

    public static final int COMMAND_SUBMIT_SM = 0x00000004;
    public static final int COMMAND_SUBMIT_SM_RESPONSE = 0x80000004;

    public static final int COMMAND_DELIVER_SM = 0x00000005;
    public static final int COMMAND_DELIVER_SM_RESPONSE = 0x80000005;

    public static final int COMMAND_UNBIND = 0x00000006;
    public static final int COMMAND_UNBIND_RESPONSE = 0x80000006;

    public static final int COMMAND_REPLACE_SM = 0x00000007;
    public static final int COMMAND_REPLACE_SM_RESPONSE = 0x80000007;

    public static final int COMMAND_CANCEL_SM = 0x00000008;
    public static final int COMMAND_CANCEL_SM_RESPONSE = 0x80000008;

    public static final int COMMAND_BIND_TRANSCEIVER = 0x00000009;
    public static final int COMMAND_BIND_TRANSCEIVER_RESPONSE = 0x80000009;

    public static final int COMMAND_OUTBIND = 0x0000000b;

    public static final int COMMAND_ENQUIRE_LINK = 0x00000015;
    public static final int COMMAND_ENQUIRE_LINK_RESPONSE = 0x80000015;

    public static final int COMMAND_SUBMIT_MULTI = 0x00000021;
    public static final int COMMAND_SUBMIT_MULTI_RESPONSE = 0x80000021;

    public static final int COMMAND_ALERT_NOTIFICATION = 0x00000102;

    public static final int COMMAND_DATA_SM = 0x00000103;
    public static final int COMMAND_DATA_SM_RESPONSE = 0x80000103;

    public static final int COMMAND_GENERIC_NACK = 0x80000000;

    public static String toString(int commandID) {
        switch (commandID) {
            case SmppCommandCodes.GENERIC_NACK:
                return "GENERIC_NACK";
            case SmppCommandCodes.COMMAND_BIND_RECEIVER:
                return "BIND_RECEIVER";
            case SmppCommandCodes.COMMAND_BIND_RECEIVER_RESPONSE:
                return "BIND_RECEIVER_RESPONSE";
            case SmppCommandCodes.COMMAND_BIND_TRANSMITTER:
                return "BIND_TRANSMITTER";
            case SmppCommandCodes.COMMAND_BIND_TRANSMITTER_RESPONSE:
                return "COMMAND_BIND_TRANSMITTER_RESPONSE";
            case SmppCommandCodes.COMMAND_QUERY_SM:
                return "QUERY_SM";
            case SmppCommandCodes.COMMAND_QUERY_SM_RESPONSE:
                return "QUERY_SM_RESPONSE";
            case SmppCommandCodes.COMMAND_SUBMIT_SM:
                return "SUBMIT_SM";
            case SmppCommandCodes.COMMAND_SUBMIT_SM_RESPONSE:
                return "SUBMIT_SM_RESPONSE";
            case SmppCommandCodes.COMMAND_DELIVER_SM:
                return "DELIVER_SM";
            case SmppCommandCodes.COMMAND_DELIVER_SM_RESPONSE:
                return "DELIVER_SM_RESPONSE";
            case SmppCommandCodes.COMMAND_UNBIND:
                return "UNBIND";
            case SmppCommandCodes.COMMAND_UNBIND_RESPONSE:
                return "UNBIND_RESPONSE";
            case SmppCommandCodes.COMMAND_REPLACE_SM:
                return "REPLACE_SM";
            case SmppCommandCodes.COMMAND_REPLACE_SM_RESPONSE:
                return "REPLACE_SM_RESPONSE";
            case SmppCommandCodes.COMMAND_CANCEL_SM:
                return "CANCEL_SM";
            case SmppCommandCodes.COMMAND_CANCEL_SM_RESPONSE:
                return "CANCEL_SM_RESPONSE";
            case SmppCommandCodes.COMMAND_BIND_TRANSCEIVER:
                return "BIND_TRANSCEIVER";
            case SmppCommandCodes.COMMAND_BIND_TRANSCEIVER_RESPONSE:
                return "BIND_TRANSCEIVER_RESPONSE";
            case SmppCommandCodes.COMMAND_ENQUIRE_LINK:
                return "ENQUIRE_LINK";
            case SmppCommandCodes.COMMAND_ENQUIRE_LINK_RESPONSE:
                return "ENQUIRE_LINK_RESPONSE";
            case SmppCommandCodes.COMMAND_DATA_SM:
                return "DATA_SM";
            case SmppCommandCodes.COMMAND_DATA_SM_RESPONSE:
                return "DATA_SM_RESPONSE";
            default:
                return "UNKNOWN";
        }

    }
}