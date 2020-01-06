
package testsoap.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SoapMtServiceService", targetNamespace = "http://service/", wsdlLocation = "http://localhost:8888/adp/SoapMtService?wsdl")
public class SoapMtServiceService
    extends Service
{

    private final static URL SOAPMTSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException SOAPMTSERVICESERVICE_EXCEPTION;
    private final static QName SOAPMTSERVICESERVICE_QNAME = new QName("http://service/", "SoapMtServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8888/adp/SoapMtService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOAPMTSERVICESERVICE_WSDL_LOCATION = url;
        SOAPMTSERVICESERVICE_EXCEPTION = e;
    }

    public SoapMtServiceService() {
        super(__getWsdlLocation(), SOAPMTSERVICESERVICE_QNAME);
    }

    public SoapMtServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOAPMTSERVICESERVICE_QNAME, features);
    }

    public SoapMtServiceService(URL wsdlLocation) {
        super(wsdlLocation, SOAPMTSERVICESERVICE_QNAME);
    }

    public SoapMtServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOAPMTSERVICESERVICE_QNAME, features);
    }

    public SoapMtServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SoapMtServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SoapMtService
     */
    @WebEndpoint(name = "SoapMtServicePort")
    public SoapMtService getSoapMtServicePort() {
        return super.getPort(new QName("http://service/", "SoapMtServicePort"), SoapMtService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SoapMtService
     */
    @WebEndpoint(name = "SoapMtServicePort")
    public SoapMtService getSoapMtServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service/", "SoapMtServicePort"), SoapMtService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOAPMTSERVICESERVICE_EXCEPTION!= null) {
            throw SOAPMTSERVICESERVICE_EXCEPTION;
        }
        return SOAPMTSERVICESERVICE_WSDL_LOCATION;
    }

}
