
package testsoap.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mtDelivery complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mtDelivery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="messageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalParts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveredParts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finalStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mtDelivery", propOrder = {
    "messageId",
    "deliveryDate",
    "language",
    "totalParts",
    "deliveredParts",
    "finalStatus",
    "statusString"
})
public class MtDelivery {

    protected String messageId;
    protected String deliveryDate;
    protected String language;
    protected String totalParts;
    protected String deliveredParts;
    protected String finalStatus;
    protected String statusString;

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Gets the value of the deliveryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the value of the deliveryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryDate(String value) {
        this.deliveryDate = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the totalParts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalParts() {
        return totalParts;
    }

    /**
     * Sets the value of the totalParts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalParts(String value) {
        this.totalParts = value;
    }

    /**
     * Gets the value of the deliveredParts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveredParts() {
        return deliveredParts;
    }

    /**
     * Sets the value of the deliveredParts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveredParts(String value) {
        this.deliveredParts = value;
    }

    /**
     * Gets the value of the finalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalStatus() {
        return finalStatus;
    }

    /**
     * Sets the value of the finalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalStatus(String value) {
        this.finalStatus = value;
    }

    /**
     * Gets the value of the statusString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusString() {
        return statusString;
    }

    /**
     * Sets the value of the statusString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusString(String value) {
        this.statusString = value;
    }

}
