package com.webservice.operation;

public class Mysql_AccessProxy implements com.webservice.operation.Mysql_Access {
  private String _endpoint = null;
  private com.webservice.operation.Mysql_Access mysql_Access = null;
  
  public Mysql_AccessProxy() {
    _initMysql_AccessProxy();
  }
  
  public Mysql_AccessProxy(String endpoint) {
    _endpoint = endpoint;
    _initMysql_AccessProxy();
  }
  
  private void _initMysql_AccessProxy() {
    try {
      mysql_Access = (new com.webservice.operation.Mysql_AccessServiceLocator()).getMysql_Access();
      if (mysql_Access != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mysql_Access)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mysql_Access)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mysql_Access != null)
      ((javax.xml.rpc.Stub)mysql_Access)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.webservice.operation.Mysql_Access getMysql_Access() {
    if (mysql_Access == null)
      _initMysql_AccessProxy();
    return mysql_Access;
  }
  
  public boolean insert_ID(com.webservice.transaction.Transaction trs) throws java.rmi.RemoteException{
    if (mysql_Access == null)
      _initMysql_AccessProxy();
    return mysql_Access.insert_ID(trs);
  }
  
  public boolean update_ID(com.webservice.transaction.Transaction txn) throws java.rmi.RemoteException{
    if (mysql_Access == null)
      _initMysql_AccessProxy();
    return mysql_Access.update_ID(txn);
  }
  
  
}