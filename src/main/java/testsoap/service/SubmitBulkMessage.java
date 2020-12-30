
package testsoap.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for submitBulkMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="submitBulkMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://service/}mtMessage" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "submitBulkMessage", propOrder = {
    "arg0"
})
public class SubmitBulkMessage {

    protected List<MtMessage> arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * <p>
     * This accessor method returns a.java reference to the live list,
     * not a.java snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a.java <CODE>set</CODE> method for the arg0 property.
     * 
     * <p>
     * For example, to add a.java new item, do as follows:
     * <pre>
     *    getArg0().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MtMessage }
     * 
     * 
     */
    public List<MtMessage> getArg0() {
        if (arg0 == null) {
            arg0 = new ArrayList<MtMessage>();
        }
        return this.arg0;
    }

}
