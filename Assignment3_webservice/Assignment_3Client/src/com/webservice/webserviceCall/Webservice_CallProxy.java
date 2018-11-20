package com.webservice.webserviceCall;

public class Webservice_CallProxy implements com.webservice.webserviceCall.Webservice_Call {
  private String _endpoint = null;
  private com.webservice.webserviceCall.Webservice_Call webservice_Call = null;
  
  public Webservice_CallProxy() {
    _initWebservice_CallProxy();
  }
  
  public Webservice_CallProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebservice_CallProxy();
  }
  
  private void _initWebservice_CallProxy() {
    try {
      webservice_Call = (new com.webservice.webserviceCall.Webservice_CallServiceLocator()).getWebservice_Call();
      if (webservice_Call != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webservice_Call)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webservice_Call)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webservice_Call != null)
      ((javax.xml.rpc.Stub)webservice_Call)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.webservice.webserviceCall.Webservice_Call getWebservice_Call() {
    if (webservice_Call == null)
      _initWebservice_CallProxy();
    return webservice_Call;
  }
  
  public java.lang.String get_Transaction(int ID) throws java.rmi.RemoteException{
    if (webservice_Call == null)
      _initWebservice_CallProxy();
    return webservice_Call.get_Transaction(ID);
  }
  
  public java.lang.String deleteTransaction(int ID) throws java.rmi.RemoteException{
    if (webservice_Call == null)
      _initWebservice_CallProxy();
    return webservice_Call.deleteTransaction(ID);
  }
  
  public java.lang.String updateTransaction(int ID, java.lang.String nameOnCard, java.lang.String cardNumber, double unitPrice, int quantity, java.lang.String expDate) throws java.rmi.RemoteException{
    if (webservice_Call == null)
      _initWebservice_CallProxy();
    return webservice_Call.updateTransaction(ID, nameOnCard, cardNumber, unitPrice, quantity, expDate);
  }
  
  public java.lang.String createTransaction(int ID, java.lang.String nameOnCard, java.lang.String cardNumber, double unitPrice, int quantity, java.lang.String expDate) throws java.rmi.RemoteException{
    if (webservice_Call == null)
      _initWebservice_CallProxy();
    return webservice_Call.createTransaction(ID, nameOnCard, cardNumber, unitPrice, quantity, expDate);
  }
  
  
}