
package org.imt.nordeurope.j2ee.webservices.nickler.client;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TemperatureSoapWebService", targetNamespace = "http://nickler.webservices.j2ee.nordeurope.imt.org/", wsdlLocation = "temperatureSoapWebService.wsdl")
public class TemperatureSoapWebService_Service
    extends Service
{

    private final static URL TEMPERATURESOAPWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException TEMPERATURESOAPWEBSERVICE_EXCEPTION;
    private final static QName TEMPERATURESOAPWEBSERVICE_QNAME = new QName("http://nickler.webservices.j2ee.nordeurope.imt.org/", "TemperatureSoapWebService");

    static {
        TEMPERATURESOAPWEBSERVICE_WSDL_LOCATION = TemperatureSoapWebService_Service.class.getResource("temperatureSoapWebService.wsdl");
        WebServiceException e = null;
        if (TEMPERATURESOAPWEBSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'temperatureSoapWebService.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        TEMPERATURESOAPWEBSERVICE_EXCEPTION = e;
    }

    public TemperatureSoapWebService_Service() {
        super(__getWsdlLocation(), TEMPERATURESOAPWEBSERVICE_QNAME);
    }

    public TemperatureSoapWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), TEMPERATURESOAPWEBSERVICE_QNAME, features);
    }

    public TemperatureSoapWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, TEMPERATURESOAPWEBSERVICE_QNAME);
    }

    public TemperatureSoapWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TEMPERATURESOAPWEBSERVICE_QNAME, features);
    }

    public TemperatureSoapWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TemperatureSoapWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TemperatureSoapWebService
     */
    @WebEndpoint(name = "TemperatureSoapWebServiceImplPort")
    public org.imt.nordeurope.j2ee.webservices.nickler.client.TemperatureSoapWebService getTemperatureSoapWebServiceImplPort() {
        return super.getPort(new QName("http://nickler.webservices.j2ee.nordeurope.imt.org/", "TemperatureSoapWebServiceImplPort"), org.imt.nordeurope.j2ee.webservices.nickler.client.TemperatureSoapWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TemperatureSoapWebService
     */
    @WebEndpoint(name = "TemperatureSoapWebServiceImplPort")
    public org.imt.nordeurope.j2ee.webservices.nickler.client.TemperatureSoapWebService getTemperatureSoapWebServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://nickler.webservices.j2ee.nordeurope.imt.org/", "TemperatureSoapWebServiceImplPort"), org.imt.nordeurope.j2ee.webservices.nickler.client.TemperatureSoapWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TEMPERATURESOAPWEBSERVICE_EXCEPTION!= null) {
            throw TEMPERATURESOAPWEBSERVICE_EXCEPTION;
        }
        return TEMPERATURESOAPWEBSERVICE_WSDL_LOCATION;
    }

}
