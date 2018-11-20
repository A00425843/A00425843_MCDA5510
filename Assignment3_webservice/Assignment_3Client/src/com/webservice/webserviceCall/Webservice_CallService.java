/**
 * Webservice_CallService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.webservice.webserviceCall;

public interface Webservice_CallService extends javax.xml.rpc.Service {
    public java.lang.String getWebservice_CallAddress();

    public com.webservice.webserviceCall.Webservice_Call getWebservice_Call() throws javax.xml.rpc.ServiceException;

    public com.webservice.webserviceCall.Webservice_Call getWebservice_Call(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
