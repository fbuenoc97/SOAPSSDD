/**
 * PeriodicoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package linux.axis.services.Periodico;

public class PeriodicoServiceLocator extends org.apache.axis.client.Service implements linux.axis.services.Periodico.PeriodicoService {

    public PeriodicoServiceLocator() {
    }


    public PeriodicoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PeriodicoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Periodico
    private java.lang.String Periodico_address = "http://linux:8888/axis/services/Periodico";

    public java.lang.String getPeriodicoAddress() {
        return Periodico_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PeriodicoWSDDServiceName = "Periodico";

    public java.lang.String getPeriodicoWSDDServiceName() {
        return PeriodicoWSDDServiceName;
    }

    public void setPeriodicoWSDDServiceName(java.lang.String name) {
        PeriodicoWSDDServiceName = name;
    }

    public linux.axis.services.Periodico.Periodico getPeriodico() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Periodico_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPeriodico(endpoint);
    }

    public linux.axis.services.Periodico.Periodico getPeriodico(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            linux.axis.services.Periodico.PeriodicoSoapBindingStub _stub = new linux.axis.services.Periodico.PeriodicoSoapBindingStub(portAddress, this);
            _stub.setPortName(getPeriodicoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPeriodicoEndpointAddress(java.lang.String address) {
        Periodico_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (linux.axis.services.Periodico.Periodico.class.isAssignableFrom(serviceEndpointInterface)) {
                linux.axis.services.Periodico.PeriodicoSoapBindingStub _stub = new linux.axis.services.Periodico.PeriodicoSoapBindingStub(new java.net.URL(Periodico_address), this);
                _stub.setPortName(getPeriodicoWSDDServiceName());
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
        if ("Periodico".equals(inputPortName)) {
            return getPeriodico();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://linux:8888/axis/services/Periodico", "PeriodicoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://linux:8888/axis/services/Periodico", "Periodico"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Periodico".equals(portName)) {
            setPeriodicoEndpointAddress(address);
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
