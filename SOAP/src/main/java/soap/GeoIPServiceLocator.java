/**
 * GeoIPServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soap;

public class GeoIPServiceLocator extends org.apache.axis.client.Service implements soap.GeoIPService {

/**
 * <b>A web service which performs GetIpAddress Lookups.</b>
 */

    public GeoIPServiceLocator() {
    }


    public GeoIPServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GeoIPServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GeoIPServiceSoap
    private java.lang.String GeoIPServiceSoap_address = "http://wsgeoip.lavasoft.com/ipservice.asmx";

    public java.lang.String getGeoIPServiceSoapAddress() {
        return GeoIPServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GeoIPServiceSoapWSDDServiceName = "GeoIPServiceSoap";

    public java.lang.String getGeoIPServiceSoapWSDDServiceName() {
        return GeoIPServiceSoapWSDDServiceName;
    }

    public void setGeoIPServiceSoapWSDDServiceName(java.lang.String name) {
        GeoIPServiceSoapWSDDServiceName = name;
    }

    public soap.GeoIPServiceSoap_PortType getGeoIPServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GeoIPServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGeoIPServiceSoap(endpoint);
    }

    public soap.GeoIPServiceSoap_PortType getGeoIPServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            soap.GeoIPServiceSoap_BindingStub _stub = new soap.GeoIPServiceSoap_BindingStub(portAddress, this);
            _stub.setPortName(getGeoIPServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGeoIPServiceSoapEndpointAddress(java.lang.String address) {
        GeoIPServiceSoap_address = address;
    }


    // Use to get a proxy class for GeoIPServiceSoap12
    private java.lang.String GeoIPServiceSoap12_address = "http://wsgeoip.lavasoft.com/ipservice.asmx";

    public java.lang.String getGeoIPServiceSoap12Address() {
        return GeoIPServiceSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GeoIPServiceSoap12WSDDServiceName = "GeoIPServiceSoap12";

    public java.lang.String getGeoIPServiceSoap12WSDDServiceName() {
        return GeoIPServiceSoap12WSDDServiceName;
    }

    public void setGeoIPServiceSoap12WSDDServiceName(java.lang.String name) {
        GeoIPServiceSoap12WSDDServiceName = name;
    }

    public soap.GeoIPServiceSoap_PortType getGeoIPServiceSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GeoIPServiceSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGeoIPServiceSoap12(endpoint);
    }

    public soap.GeoIPServiceSoap_PortType getGeoIPServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            soap.GeoIPServiceSoap12Stub _stub = new soap.GeoIPServiceSoap12Stub(portAddress, this);
            _stub.setPortName(getGeoIPServiceSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGeoIPServiceSoap12EndpointAddress(java.lang.String address) {
        GeoIPServiceSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (soap.GeoIPServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                soap.GeoIPServiceSoap_BindingStub _stub = new soap.GeoIPServiceSoap_BindingStub(new java.net.URL(GeoIPServiceSoap_address), this);
                _stub.setPortName(getGeoIPServiceSoapWSDDServiceName());
                return _stub;
            }
            if (soap.GeoIPServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                soap.GeoIPServiceSoap12Stub _stub = new soap.GeoIPServiceSoap12Stub(new java.net.URL(GeoIPServiceSoap12_address), this);
                _stub.setPortName(getGeoIPServiceSoap12WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("GeoIPServiceSoap".equals(inputPortName)) {
            return getGeoIPServiceSoap();
        }
        else if ("GeoIPServiceSoap12".equals(inputPortName)) {
            return getGeoIPServiceSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://lavasoft.com/", "GeoIPService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://lavasoft.com/", "GeoIPServiceSoap"));
            ports.add(new javax.xml.namespace.QName("http://lavasoft.com/", "GeoIPServiceSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GeoIPServiceSoap".equals(portName)) {
            setGeoIPServiceSoapEndpointAddress(address);
        }
        else 
if ("GeoIPServiceSoap12".equals(portName)) {
            setGeoIPServiceSoap12EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
