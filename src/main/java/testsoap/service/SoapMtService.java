
package testsoap.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SoapMtService", targetNamespace = "http://service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SoapMtService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ping", targetNamespace = "http://service/", className = "testsoap.service.Ping")
    @ResponseWrapper(localName = "pingResponse", targetNamespace = "http://service/", className = "testsoap.service.PingResponse")
    @Action(input = "http://service/SoapMtService/pingRequest", output = "http://service/SoapMtService/pingResponse")
    public String ping(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns testsoap.service.MtResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "submitMessage", targetNamespace = "http://service/", className = "testsoap.service.SubmitMessage")
    @ResponseWrapper(localName = "submitMessageResponse", targetNamespace = "http://service/", className = "testsoap.service.SubmitMessageResponse")
    @Action(input = "http://service/SoapMtService/submitMessageRequest", output = "http://service/SoapMtService/submitMessageResponse")
    public MtResponse submitMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        MtMessage arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns testsoap.service.MtDelivery
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMessageStatus", targetNamespace = "http://service/", className = "testsoap.service.GetMessageStatus")
    @ResponseWrapper(localName = "getMessageStatusResponse", targetNamespace = "http://service/", className = "testsoap.service.GetMessageStatusResponse")
    @Action(input = "http://service/SoapMtService/getMessageStatusRequest", output = "http://service/SoapMtService/getMessageStatusResponse")
    public MtDelivery getMessageStatus(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<testsoap.service.MtResponse>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "submitBulkMessage", targetNamespace = "http://service/", className = "testsoap.service.SubmitBulkMessage")
    @ResponseWrapper(localName = "submitBulkMessageResponse", targetNamespace = "http://service/", className = "testsoap.service.SubmitBulkMessageResponse")
    @Action(input = "http://service/SoapMtService/submitBulkMessageRequest", output = "http://service/SoapMtService/submitBulkMessageResponse")
    public List<MtResponse> submitBulkMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        List<MtMessage> arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<testsoap.service.MtDelivery>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMessageBulkStatus", targetNamespace = "http://service/", className = "testsoap.service.GetMessageBulkStatus")
    @ResponseWrapper(localName = "getMessageBulkStatusResponse", targetNamespace = "http://service/", className = "testsoap.service.GetMessageBulkStatusResponse")
    @Action(input = "http://service/SoapMtService/getMessageBulkStatusRequest", output = "http://service/SoapMtService/getMessageBulkStatusResponse")
    public List<MtDelivery> getMessageBulkStatus(
        @WebParam(name = "arg0", targetNamespace = "")
        List<String> arg0);

}
