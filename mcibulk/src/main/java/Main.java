import com.google.common.primitives.Longs;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws DecoderException {

        String udh = "060804d1110202";
        String out = Base64.getEncoder().encodeToString(Hex.decodeHex(udh.toCharArray()));
        System.out.println(out);




//        System.out.println("-"+out+"-");
//
//        String completeMessage1 = "BQADEQIB";
//        String out1 = new String(Base64.getDecoder().decode(completeMessage1));
//        System.out.println(out1);

//        System.out.println(new BigInteger("3hbdad7a409a47a1be91d6b1af7a8823", 16));

    }
}
