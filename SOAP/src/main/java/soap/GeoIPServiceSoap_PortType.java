/**
 * GeoIPServiceSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soap;

public interface GeoIPServiceSoap_PortType extends java.rmi.Remote {

    /**
     * <br/>Get Country and State XML String for a given ip address
     * in x.x.x.x format<br/><br/>Parameter:GetIpAddress address &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b><br/><br/>Return:format
     * in XML < GeoIP >< Country >US< /Country >< State >PA< /State >< /GeoIP
     * > &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b>
     */
    public java.lang.String getIpLocation(java.lang.String sIp) throws java.rmi.RemoteException;

    /**
     * <br/>Get Country and State XML String for a given ip address
     * in x.x.x.x format<br/><br/>Parameter:GetIpAddress address &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b><br/><br/>Return:format
     * in XML < GeoIP >< Country >US< /Country >< State >PA< /State >< /GeoIP
     * > &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b> or <b>string empty</b>
     */
    public java.lang.String getIpLocation_2_0(java.lang.String sIp) throws java.rmi.RemoteException;

    /**
     * <br/>Get Country and State XML String for a given ip address
     * in x.x.x.x format<br/><br/>Parameter:GetIpAddress address &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b><br/><br/>Return:format
     * in XML < GeoIP >< Country >US< /Country >< State >PA< /State >< /GeoIP
     * > &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b>
     */
    public java.lang.String getLocation() throws java.rmi.RemoteException;

    /**
     * <br/>Get Country ISO2 code by Country Name<br/>Paramater:Country
     * Name &nbsp;&nbsp;<b>Type:String<b/>
     */
    public java.lang.String getCountryISO2ByName(java.lang.String countryName) throws java.rmi.RemoteException;

    /**
     * <br/>Get Country Name by Country ISO2 code<br/>Paramater:Country
     * Code &nbsp;&nbsp;<b>Type:String<b/><br/>Country code  format is ALPHA-2
     * (CA - for Canada)
     */
    public java.lang.String getCountryNameByISO2(java.lang.String iso2Code) throws java.rmi.RemoteException;
}
