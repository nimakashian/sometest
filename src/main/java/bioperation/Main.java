package bioperation;

public class Main {
    private static final int RESPONSE_BIT = 0x80000000;
    private static final int RESPONSE_MASK = 0x7fffffff;

    public static final int COMMAND_LOGIN = 0x00000001;
    public static final int COMMAND_LOGIN_RESPONSE = COMMAND_LOGIN | RESPONSE_BIT;

    public static final int COMMAND_CREDIT_QUERY = 0x00000002;
    public static final int COMMAND_CREDIT_QUERY_RESPONSE = COMMAND_CREDIT_QUERY | RESPONSE_BIT;
    public static void main(String[] args) {

        System.out.println(RESPONSE_BIT);
        System.out.println(RESPONSE_MASK);
        System.out.println(COMMAND_LOGIN_RESPONSE);
        System.out.println(0x00000002);

    }
}
