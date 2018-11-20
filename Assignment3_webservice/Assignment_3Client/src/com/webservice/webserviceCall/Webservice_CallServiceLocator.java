/**
 * Webservice_CallServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.webservice.webserviceCall;

public class Webservice_CallServiceLocator extends org.apache.axis.client.Service implements com.webservice.webserviceCall.Webservice_CallService {

    public Webservice_CallServiceLocator() {
    }


    public Webservice_CallServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Webservice_CallServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Webservice_Call
    private java.lang.String Webservice_Call_address = "http://localhost:8080/Assignment_3/services/Webservice_Call";

    public java.lang.String getWebservice_CallAddress() {
        return Webservice_Call_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Webservice_CallWSDDServiceName = "Webservice_Call";

    public java.lang.String getWebservice_CallWSDDServiceName() {
        return Webservice_CallWSDDServiceName;
    }

    public void setWebservice_CallWSDDServiceName(java.lang.String name) {
        Webservice_CallWSDDServiceName = name;
    }

    public com.webservice.webserviceCall.Webservice_Call getWebservice_Call() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Webservice_Call_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebservice_Call(endpoint);
    }

    public com.webservice.webserviceCall.Webservice_Call getWebservice_Call(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.webservice.webserviceCall.Webservice_CallSoapBindingStub _stub = new com.webservice.webserviceCall.Webservice_CallSoapBindingStub(portAddress, this);
            _stub.setPortName(getWebservice_CallWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebservice_CallEndpointAddress(java.lang.String address) {
        Webservice_Call_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.webservice.webserviceCall.Webservice_Call.class.isAssignableFrom(serviceEndpointInterface)) {
                com.webservice.webserviceCall.Webservice_CallSoapBindingStub _stub = new com.webservice.webserviceCall.Webservice_CallSoapBindingStub(new java.net.URL(Webservice_Call_address), this);
                _stub.setPortName(getWebservice_CallWSDDServiceName());
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
        if ("Webservice_Call".equals(inputPortName)) {
            return getWebservice_Call();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webserviceCall.webservice.com", "Webservice_CallService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webserviceCall.webservice.com", "Webservice_Call"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Webservice_Call".equals(portName)) {
            setWebservice_CallEndpointAddress(address);
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
