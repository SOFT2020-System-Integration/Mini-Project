/**
 * GeoIPServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soap;

public class GeoIPServiceTestCase extends junit.framework.TestCase {
    public GeoIPServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testGeoIPServiceSoapWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new soap.GeoIPServiceLocator().getGeoIPServiceSoapAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new soap.GeoIPServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1GeoIPServiceSoapGetIpLocation() throws Exception {
        soap.GeoIPServiceSoap_BindingStub binding;
        try {
            binding = (soap.GeoIPServiceSoap_BindingStub)
                          new soap.GeoIPServiceLocator().getGeoIPServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getIpLocation(new java.lang.String());
        // TBD - validate results
    }

    public void test2GeoIPServiceSoapGetIpLocation_2_0() throws Exception {
        soap.GeoIPServiceSoap_BindingStub binding;
        try {
            binding = (soap.GeoIPServiceSoap_BindingStub)
                          new soap.GeoIPServiceLocator().getGeoIPServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getIpLocation_2_0(new java.lang.String());
        // TBD - validate results
    }

    public void test3GeoIPServiceSoapGetLocation() throws Exception {
        soap.GeoIPServiceSoap_BindingStub binding;
        try {
            binding = (soap.GeoIPServiceSoap_BindingStub)
                          new soap.GeoIPServiceLocator().getGeoIPServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getLocation();
        // TBD - validate results
    }

    public void test4GeoIPServiceSoapGetCountryISO2ByName() throws Exception {
        soap.GeoIPServiceSoap_BindingStub binding;
        try {
            binding = (soap.GeoIPServiceSoap_BindingStub)
                          new soap.GeoIPServiceLocator().getGeoIPServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getCountryISO2ByName(new java.lang.String());
        // TBD - validate results
    }

    public void test5GeoIPServiceSoapGetCountryNameByISO2() throws Exception {
        soap.GeoIPServiceSoap_BindingStub binding;
        try {
            binding = (soap.GeoIPServiceSoap_BindingStub)
                          new soap.GeoIPServiceLocator().getGeoIPServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getCountryNameByISO2(new java.lang.String());
        // TBD - validate results
    }

    public void testGeoIPServiceSoap12WSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new soap.GeoIPServiceLocator().getGeoIPServiceSoap12Address() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new soap.GeoIPServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test6GeoIPServiceSoap12GetIpLocation() throws Exception {
        soap.GeoIPServiceSoap12Stub binding;
        try {
            binding = (soap.GeoIPServiceSoap12Stub)
                          new soap.GeoIPServiceLocator().getGeoIPServiceSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getIpLocation(new java.lang.String());
        // TBD - validate results
    }

    public void test7GeoIPServiceSoap12GetIpLocation_2_0() throws Exception {
        soap.GeoIPServiceSoap12Stub binding;
        try {
            binding = (soap.GeoIPServiceSoap12Stub)
                          new soap.GeoIPServiceLocator().getGeoIPServiceSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getIpLocation_2_0(new java.lang.String());
        // TBD - validate results
    }

    public void test8GeoIPServiceSoap12GetLocation() throws Exception {
        soap.GeoIPServiceSoap12Stub binding;
        try {
            binding = (soap.GeoIPServiceSoap12Stub)
                          new soap.GeoIPServiceLocator().getGeoIPServiceSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getLocation();
        // TBD - validate results
    }

    public void test9GeoIPServiceSoap12GetCountryISO2ByName() throws Exception {
        soap.GeoIPServiceSoap12Stub binding;
        try {
            binding = (soap.GeoIPServiceSoap12Stub)
                          new soap.GeoIPServiceLocator().getGeoIPServiceSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getCountryISO2ByName(new java.lang.String());
        // TBD - validate results
    }

    public void test10GeoIPServiceSoap12GetCountryNameByISO2() throws Exception {
        soap.GeoIPServiceSoap12Stub binding;
        try {
            binding = (soap.GeoIPServiceSoap12Stub)
                          new soap.GeoIPServiceLocator().getGeoIPServiceSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getCountryNameByISO2(new java.lang.String());
        // TBD - validate results
    }

}
