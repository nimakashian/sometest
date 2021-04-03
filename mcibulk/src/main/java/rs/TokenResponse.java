package rs;


import com.google.gson.Gson;

public class TokenResponse {

    String access_token = "abcdefgh";
    Long expires_in = 18000L;
    Long refresh_expires_in = 180000L;
    String refresh_token = "hgfedcba";
    String token_type = "bearer";
    Integer no_before_policy = 0;
    String session_state = "123-abc-456-def";
    String scope = "email profile";

    public TokenResponse() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    public Long getRefresh_expires_in() {
        return refresh_expires_in;
    }

    public void setRefresh_expires_in(Long refresh_expires_in) {
        this.refresh_expires_in = refresh_expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public Integer getNo_before_policy() {
        return no_before_policy;
    }

    public void setNo_before_policy(Integer no_before_policy) {
        this.no_before_policy = no_before_policy;
    }

    public String getSession_state() {
        return session_state;
    }

    public void setSession_state(String session_state) {
        this.session_state = session_state;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return (new Gson()).toJson(this);
    }
}
