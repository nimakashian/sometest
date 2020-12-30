package restclient;

import javax.ws.rs.core.Form;

public class TokenRequest extends Form {
    String grant_type="password";
    String username = "hom";
    String password = "123";

    public TokenRequest(String grant_type, String username, String password) {
        this.grant_type = grant_type;
        this.username = username;
        this.password = password;
    }

    public TokenRequest() {
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Form getForm(){
        return this
                .param("grant_type",getGrant_type())
                .param("username", getUsername())
                .param("password", getPassword());
    }

    @Override
    public String toString() {
        return "grant_type=" + getGrant_type() + "&username=" + getUsername() +
                "&password=" + getPassword();
    }
}