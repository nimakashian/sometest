import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sun.xml.internal.ws.developer.Serialization;
import org.apache.commons.lang3.SerializationUtils;

import java.io.*;

public class Main8 {
    Message message;
    public static void main(String[] args) throws IOException {
        int i1 = Long.toString(System.currentTimeMillis()).getBytes("utf8").length;
        int i2 = Long.toString(System.currentTimeMillis()).getBytes().length;
        String textmessage = (new Main8()).message.createJson();
        int i3 = textmessage.getBytes().length;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(textmessage);
        oos.flush();
        byte [] data = bos.toByteArray();
        int i4 = data.length;


        System.out.println(i1 + ":" + i2 + ":" +  i3 + ":" + i4 );
        System.out.println(textmessage);
    }

    public Main8() {
        this.message = new Message();
        this.message.createtime = System.currentTimeMillis();
        this.message.newMessage = new NewMessage();
    }
    class NewMessage {
        long a = 4;
        long b = 5;
    }

    class Message implements Serializable {
        NewMessage newMessage;
        Long createtime;
        String internalid = "72057592557420023";
        String operatorid = "61E4EF400334DE8C";
        String clientid = "jdbcmt/326872869";
//        String messagebody = "dfgdfgdg یبلیبلیل یبلیبل م ممممممممممممممممم مممممممممممممممممممممبلابلابلاللللللللللللللللللللللل للللللللللللللللللللللللللللللمم ممممممممممممممممممممم یبلیبل یبلی ";
//        String srcaddress = "982000995";
//        String dstaddress = "989103000410";
//        String status = "32";
//        String alphabet = "0";
//        String dcs = "8";
//        String dstnpi = "1";
//        String srcnpi = "1";
//        String srcton = "1";
//        String dstton = "1";
//        String accountid = "4010";
//        String clientpluginid = "PROXY";
//        String operatorpluginid = "PARDIS-MT";
//        String routeid = "1601";
//        String validityperiod = "86400";
//        String registereddelivery = "true";
//        String messageclass = "1";
//        String accepttime = "2019-11-25 01:07:31.937";
//        String expiretime = "2019-11-26 01:07:31.937";
//        String updatedtime = "2019-11-25 01:07:34.715";
//        String reasoncode = "0";
//        String udh = "0604081010201";
//        String persisttime = "2019-11-26 00:06:12.672424";

        public String createJson() throws IOException {
            Gson gson = new Gson();

//            gson.fromJson(gson.toJson(this), Message.class);

//            ObjectMapper mapper = new ObjectMapper();
//            String json = mapper.writeValueAsString( this );

            //Saving of object in a file
            String filename = "testserial";
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object
            out.writeObject(this);
            out.close();
            file.close();



            String json = gson.toJson(null);

            return json;

        }
    }
}
