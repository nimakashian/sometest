package restclient;



import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class ApacheMain {
    public static void main(String[] args) {


        Client client = ClientBuilder.newBuilder().newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target("http://localhost:19000/energy/oauth/token");

        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.putSingle("authorization","Basic ZW5leC1jbGllbnQyOnNlY3JldA==");
        headers.putSingle("content-type", MediaType.APPLICATION_FORM_URLENCODED);
        Invocation.Builder builder = target.request().headers(headers);

        Response response = builder.post(Entity.form((new TokenRequest()).getForm()));
        TokenResponse tokenResponse = response.readEntity(TokenResponse.class);
         System.out.println(tokenResponse);
    }
}

/*
http://localhost:19000/energy/oauth/token \
  -H 'authorization: Basic ZW5leC1jbGllbnQyOnNlY3JldA==' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: 96305e83-583c-7c89-784a-f03156c66984' \
  -d 'grant_type=password&username=hom&password=123'



  {
    "error": "invalid_request",
    "error_description": "Invalid refresh token (expired): 643058be-5a7c-4914-8eb2-18a09b860354"
}
 */
