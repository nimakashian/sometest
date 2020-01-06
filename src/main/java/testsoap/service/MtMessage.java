
package testsoap.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mtMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mtMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="destAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srcAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="textMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mtMessage", propOrder = {
    "destAddress",
    "srcAddress",
    "textMessage",
    "timeStamp"
})
public class MtMessage {

    protected String destAddress;
    protected String srcAddress;
    protected String textMessage;
    protected String timeStamp;

    public MtMessage(String srcAddress, String destAddress, String textMessage, String timeStamp) {
        this.srcAddress = srcAddress;
        this.destAddress=destAddress;
        this.textMessage = textMessage;
        this.timeStamp = timeStamp;
    }

    public MtMessage() {
    }

    /**
     * Gets the value of the destAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestAddress() {
        return destAddress;
    }

    /**
     * Sets the value of the destAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestAddress(String value) {
        this.destAddress = value;
    }

    /**
     * Gets the value of the srcAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcAddress() {
        return srcAddress;
    }

    /**
     * Sets the value of the srcAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcAddress(String value) {
        this.srcAddress = value;
    }

    /**
     * Gets the value of the textMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextMessage() {
        return textMessage;
    }

    /**
     * Sets the value of the textMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextMessage(String value) {
        this.textMessage = value;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStamp(String value) {
        this.timeStamp = value;
    }

}
