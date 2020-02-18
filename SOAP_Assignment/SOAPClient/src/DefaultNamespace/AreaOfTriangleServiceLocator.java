/**
 * AreaOfTriangleServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class AreaOfTriangleServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.AreaOfTriangleService {

    public AreaOfTriangleServiceLocator() {
    }


    public AreaOfTriangleServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AreaOfTriangleServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AreaOfTriangle
    private java.lang.String AreaOfTriangle_address = "http://localhost:8080/SOAP/services/AreaOfTriangle";

    public java.lang.String getAreaOfTriangleAddress() {
        return AreaOfTriangle_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AreaOfTriangleWSDDServiceName = "AreaOfTriangle";

    public java.lang.String getAreaOfTriangleWSDDServiceName() {
        return AreaOfTriangleWSDDServiceName;
    }

    public void setAreaOfTriangleWSDDServiceName(java.lang.String name) {
        AreaOfTriangleWSDDServiceName = name;
    }

    public DefaultNamespace.AreaOfTriangle getAreaOfTriangle() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AreaOfTriangle_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAreaOfTriangle(endpoint);
    }

    public DefaultNamespace.AreaOfTriangle getAreaOfTriangle(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.AreaOfTriangleSoapBindingStub _stub = new DefaultNamespace.AreaOfTriangleSoapBindingStub(portAddress, this);
            _stub.setPortName(getAreaOfTriangleWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAreaOfTriangleEndpointAddress(java.lang.String address) {
        AreaOfTriangle_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.AreaOfTriangle.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.AreaOfTriangleSoapBindingStub _stub = new DefaultNamespace.AreaOfTriangleSoapBindingStub(new java.net.URL(AreaOfTriangle_address), this);
                _stub.setPortName(getAreaOfTriangleWSDDServiceName());
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
        if ("AreaOfTriangle".equals(inputPortName)) {
            return getAreaOfTriangle();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "AreaOfTriangleService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "AreaOfTriangle"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AreaOfTriangle".equals(portName)) {
            setAreaOfTriangleEndpointAddress(address);
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
