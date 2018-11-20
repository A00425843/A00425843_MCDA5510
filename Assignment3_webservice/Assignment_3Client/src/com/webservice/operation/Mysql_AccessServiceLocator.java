/**
 * Mysql_AccessServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.webservice.operation;

public class Mysql_AccessServiceLocator extends org.apache.axis.client.Service implements com.webservice.operation.Mysql_AccessService {

    public Mysql_AccessServiceLocator() {
    }


    public Mysql_AccessServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Mysql_AccessServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Mysql_Access
    private java.lang.String Mysql_Access_address = "http://localhost:8080/Assignment_3/services/Mysql_Access";

    public java.lang.String getMysql_AccessAddress() {
        return Mysql_Access_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Mysql_AccessWSDDServiceName = "Mysql_Access";

    public java.lang.String getMysql_AccessWSDDServiceName() {
        return Mysql_AccessWSDDServiceName;
    }

    public void setMysql_AccessWSDDServiceName(java.lang.String name) {
        Mysql_AccessWSDDServiceName = name;
    }

    public com.webservice.operation.Mysql_Access getMysql_Access() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Mysql_Access_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMysql_Access(endpoint);
    }

    public com.webservice.operation.Mysql_Access getMysql_Access(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.webservice.operation.Mysql_AccessSoapBindingStub _stub = new com.webservice.operation.Mysql_AccessSoapBindingStub(portAddress, this);
            _stub.setPortName(getMysql_AccessWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMysql_AccessEndpointAddress(java.lang.String address) {
        Mysql_Access_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.webservice.operation.Mysql_Access.class.isAssignableFrom(serviceEndpointInterface)) {
                com.webservice.operation.Mysql_AccessSoapBindingStub _stub = new com.webservice.operation.Mysql_AccessSoapBindingStub(new java.net.URL(Mysql_Access_address), this);
                _stub.setPortName(getMysql_AccessWSDDServiceName());
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
        if ("Mysql_Access".equals(inputPortName)) {
            return getMysql_Access();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://operation.webservice.com", "Mysql_AccessService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://operation.webservice.com", "Mysql_Access"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Mysql_Access".equals(portName)) {
            setMysql_AccessEndpointAddress(address);
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
