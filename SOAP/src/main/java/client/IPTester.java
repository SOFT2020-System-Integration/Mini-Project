package client;

import soap.GeoIPServiceLocator;
import soap.GeoIPServiceSoap_PortType;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class IPTester {
    public static void main(String[] argv) {
        try {
            GeoIPServiceLocator locator = new GeoIPServiceLocator();
            GeoIPServiceSoap_PortType service = locator.getGeoIPServiceSoap();


            String country = service.getIpLocation(argv[0]);
            System.out.println(country);

        } catch (ServiceException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
