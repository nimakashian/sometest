package logger.logtest;

public class MyClass {
    public static void main(String[] args) {
        SafeLogger logger = SafeLogger.getLogger(MyClass.class);

        logger.info("plan text");
        logger.info("secret text {\"nid\":\"0079426255\",\"password\":\"Maryam@adp2\",\"className\":,\"password\":\"\"}");

    }
}
