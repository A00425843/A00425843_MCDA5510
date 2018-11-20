/**
 * Mysql_Access.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.webservice.operation;

public interface Mysql_Access extends java.rmi.Remote {
    public boolean insert_ID(com.webservice.transaction.Transaction trs) throws java.rmi.RemoteException;
    public boolean update_ID(com.webservice.transaction.Transaction txn) throws java.rmi.RemoteException;
}
