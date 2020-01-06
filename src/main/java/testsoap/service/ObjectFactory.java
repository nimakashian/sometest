
package testsoap.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the testsoap.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Ping_QNAME = new QName("http://service/", "ping");
    private final static QName _SubmitMessageResponse_QNAME = new QName("http://service/", "submitMessageResponse");
    private final static QName _SubmitMessage_QNAME = new QName("http://service/", "submitMessage");
    private final static QName _SubmitBlock_QNAME = new QName("http://service/", "submitBlock");
    private final static QName _PingResponse_QNAME = new QName("http://service/", "pingResponse");
    private final static QName _GetMessageStatus_QNAME = new QName("http://service/", "getMessageStatus");
    private final static QName _GetMessageStatusResponse_QNAME = new QName("http://service/", "getMessageStatusResponse");
    private final static QName _SubmitBlockResponse_QNAME = new QName("http://service/", "submitBlockResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: testsoap.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SubmitBlock }
     * 
     */
    public SubmitBlock createSubmitBlock() {
        return new SubmitBlock();
    }

    /**
     * Create an instance of {@link SubmitMessage }
     * 
     */
    public SubmitMessage createSubmitMessage() {
        return new SubmitMessage();
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link SubmitMessageResponse }
     * 
     */
    public SubmitMessageResponse createSubmitMessageResponse() {
        return new SubmitMessageResponse();
    }

    /**
     * Create an instance of {@link GetMessageStatus }
     * 
     */
    public GetMessageStatus createGetMessageStatus() {
        return new GetMessageStatus();
    }

    /**
     * Create an instance of {@link GetMessageStatusResponse }
     * 
     */
    public GetMessageStatusResponse createGetMessageStatusResponse() {
        return new GetMessageStatusResponse();
    }

    /**
     * Create an instance of {@link SubmitBlockResponse }
     * 
     */
    public SubmitBlockResponse createSubmitBlockResponse() {
        return new SubmitBlockResponse();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

    /**
     * Create an instance of {@link MtResponse }
     * 
     */
    public MtResponse createMtResponse() {
        return new MtResponse();
    }

    /**
     * Create an instance of {@link MtDelivery }
     * 
     */
    public MtDelivery createMtDelivery() {
        return new MtDelivery();
    }

    /**
     * Create an instance of {@link MtMessage }
     * 
     */
    public MtMessage createMtMessage() {
        return new MtMessage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "ping")
    public JAXBElement<Ping> createPing(Ping value) {
        return new JAXBElement<Ping>(_Ping_QNAME, Ping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "submitMessageResponse")
    public JAXBElement<SubmitMessageResponse> createSubmitMessageResponse(SubmitMessageResponse value) {
        return new JAXBElement<SubmitMessageResponse>(_SubmitMessageResponse_QNAME, SubmitMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "submitMessage")
    public JAXBElement<SubmitMessage> createSubmitMessage(SubmitMessage value) {
        return new JAXBElement<SubmitMessage>(_SubmitMessage_QNAME, SubmitMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitBlock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "submitBlock")
    public JAXBElement<SubmitBlock> createSubmitBlock(SubmitBlock value) {
        return new JAXBElement<SubmitBlock>(_SubmitBlock_QNAME, SubmitBlock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "pingResponse")
    public JAXBElement<PingResponse> createPingResponse(PingResponse value) {
        return new JAXBElement<PingResponse>(_PingResponse_QNAME, PingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessageStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getMessageStatus")
    public JAXBElement<GetMessageStatus> createGetMessageStatus(GetMessageStatus value) {
        return new JAXBElement<GetMessageStatus>(_GetMessageStatus_QNAME, GetMessageStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessageStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getMessageStatusResponse")
    public JAXBElement<GetMessageStatusResponse> createGetMessageStatusResponse(GetMessageStatusResponse value) {
        return new JAXBElement<GetMessageStatusResponse>(_GetMessageStatusResponse_QNAME, GetMessageStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitBlockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "submitBlockResponse")
    public JAXBElement<SubmitBlockResponse> createSubmitBlockResponse(SubmitBlockResponse value) {
        return new JAXBElement<SubmitBlockResponse>(_SubmitBlockResponse_QNAME, SubmitBlockResponse.class, null, value);
    }

}
