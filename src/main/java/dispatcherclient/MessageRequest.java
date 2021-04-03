package dispatcherclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageRequest implements Serializable {
    /*long msgid;*/
    String src;
    String dest;
    String msg;
    int dcs;
    String clientId;
    String dueDate;


    public MessageRequest() {
    }

    public MessageRequest(String src, String dest, String msg, int dcs, String clientId) {
        this.src = src;
        this.dest = dest;
        this.msg = msg;
        this.dcs = dcs;
        this.clientId = clientId;
    }

    public MessageRequest(/*long msgId,*/ String src, String dest, String msg) {
        /*this.msgid = msgId;*/
        this.src = src;
        this.dest = dest;
        this.msg = msg;
    }

    /*public long getMsgid() {
        return msgid;
    }

    public void setMsgid(long msgid) {
        this.msgid = msgid;
    }*/

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getDcs() {
        return dcs;
    }

    public void setDcs(int dcs) {
        this.dcs = dcs;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
