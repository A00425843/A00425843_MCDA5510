/**
 * Webservice_Call.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.webservice.webserviceCall;

public interface Webservice_Call extends java.rmi.Remote {
    public java.lang.String get_Transaction(int ID) throws java.rmi.RemoteException;
    public java.lang.String createTransaction(int ID, java.lang.String nameOnCard, java.lang.String cardNumber, double unitPrice, int quantity, java.lang.String expDate) throws java.rmi.RemoteException;
    public java.lang.String updateTransaction(int ID, java.lang.String nameOnCard, java.lang.String cardNumber, double unitPrice, int quantity, java.lang.String expDate) throws java.rmi.RemoteException;
    public java.lang.String deleteTransaction(int ID) throws java.rmi.RemoteException;
}
