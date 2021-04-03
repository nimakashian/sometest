package rs;

public class DeliveryDto {

    private String src;
    private String dst;
    private Boolean delivered;
    private DeliveryStatus finalStatus;
    private String submitDate;
    private String deliveredDate;
    private String err;
    private Long partNumber;
    private Integer partCount;
    private DeliverySendType type;

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

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public DeliveryStatus getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(DeliveryStatus finalStatus) {
        this.finalStatus = finalStatus;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(String deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public Long getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(Long partNumber) {
        this.partNumber = partNumber;
    }

    public Integer getPartCount() {
        return partCount;
    }

    public void setPartCount(Integer partCount) {
        this.partCount = partCount;
    }

    public DeliverySendType getType() {
        return type;
    }

    public void setType(DeliverySendType type) {
        this.type = type;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(getSrc())
                .append(getDst())
                .append(getDelivered())
                .append(getDeliveredDate())
                .append(getFinalStatus())
                .append(getErr())
                .append(getSubmitDate())
                .append(getType())
                .append(getPartCount())
                .append(getPartNumber());

        return builder.toString();
    }
}
