package rs;

public class MODto {

    String src;
    String dst;
    String msg;
    String createdAt;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getSrc())
                .append(getDst())
                .append(getMsg())
                .append(getCreatedAt());

        return builder.toString();
    }
}
