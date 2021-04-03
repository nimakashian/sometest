package dispatcherclient;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class SendBulkMessage extends Thread {

    public String name ;
    public SendBulkMessage(String name) {
        this.name = name;
//        start();
    }

    @Override
    public void run() {
        Client client = ClientBuilder.newBuilder().newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target("http://127.0.0.1:5556/sms");

        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.putSingle("X-SMS-APIKEY","123");
        headers.putSingle("content-type", MediaType.APPLICATION_JSON);
        Invocation.Builder builder = target.request().headers(headers);

        List<MessageRequest> messageRequestList = new ArrayList<>();
        for (int i = 0 ; i<90 ;i++) {
            messageRequestList.add(new MessageRequest("123", "321", "hello", 0, "erer"));
        }
        for (int i = 0 ; i<10 ;i++) {
            messageRequestList.add(new MessageRequest("9820007097", "321", "hello", 0, "erer"));
        }

        Response response = builder.post(Entity.json(messageRequestList));
        String tokenResponse = response.readEntity(String.class);
        System.out.println("response:" + name + ":" + tokenResponse);
    }

}
