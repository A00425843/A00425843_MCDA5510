<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleWebservice_CallProxyid" scope="session" class="com.webservice.webserviceCall.Webservice_CallProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleWebservice_CallProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleWebservice_CallProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleWebservice_CallProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.webservice.webserviceCall.Webservice_Call getWebservice_Call10mtemp = sampleWebservice_CallProxyid.getWebservice_Call();
if(getWebservice_Call10mtemp == null){
%>
<%=getWebservice_Call10mtemp %>
<%
}else{
        if(getWebservice_Call10mtemp!= null){
        String tempreturnp11 = getWebservice_Call10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String ID_1id=  request.getParameter("ID16");
        int ID_1idTemp  = Integer.parseInt(ID_1id);
        java.lang.String get_Transaction13mtemp = sampleWebservice_CallProxyid.get_Transaction(ID_1idTemp);
if(get_Transaction13mtemp == null){
%>
<%=get_Transaction13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(get_Transaction13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 18:
        gotMethod = true;
        String ID_2id=  request.getParameter("ID21");
        int ID_2idTemp  = Integer.parseInt(ID_2id);
        java.lang.String deleteTransaction18mtemp = sampleWebservice_CallProxyid.deleteTransaction(ID_2idTemp);
if(deleteTransaction18mtemp == null){
%>
<%=deleteTransaction18mtemp %>
<%
}else{
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteTransaction18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
}
break;
case 23:
        gotMethod = true;
        String ID_3id=  request.getParameter("ID26");
        int ID_3idTemp  = Integer.parseInt(ID_3id);
        String nameOnCard_4id=  request.getParameter("nameOnCard28");
            java.lang.String nameOnCard_4idTemp = null;
        if(!nameOnCard_4id.equals("")){
         nameOnCard_4idTemp  = nameOnCard_4id;
        }
        String cardNumber_5id=  request.getParameter("cardNumber30");
            java.lang.String cardNumber_5idTemp = null;
        if(!cardNumber_5id.equals("")){
         cardNumber_5idTemp  = cardNumber_5id;
        }
        String unitPrice_6id=  request.getParameter("unitPrice32");
        double unitPrice_6idTemp  = Double.parseDouble(unitPrice_6id);
        String quantity_7id=  request.getParameter("quantity34");
        int quantity_7idTemp  = Integer.parseInt(quantity_7id);
        String expDate_8id=  request.getParameter("expDate36");
            java.lang.String expDate_8idTemp = null;
        if(!expDate_8id.equals("")){
         expDate_8idTemp  = expDate_8id;
        }
        java.lang.String updateTransaction23mtemp = sampleWebservice_CallProxyid.updateTransaction(ID_3idTemp,nameOnCard_4idTemp,cardNumber_5idTemp,unitPrice_6idTemp,quantity_7idTemp,expDate_8idTemp);
if(updateTransaction23mtemp == null){
%>
<%=updateTransaction23mtemp %>
<%
}else{
        String tempResultreturnp24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateTransaction23mtemp));
        %>
        <%= tempResultreturnp24 %>
        <%
}
break;
case 38:
        gotMethod = true;
        String ID_9id=  request.getParameter("ID41");
        int ID_9idTemp  = Integer.parseInt(ID_9id);
        String nameOnCard_10id=  request.getParameter("nameOnCard43");
            java.lang.String nameOnCard_10idTemp = null;
        if(!nameOnCard_10id.equals("")){
         nameOnCard_10idTemp  = nameOnCard_10id;
        }
        String cardNumber_11id=  request.getParameter("cardNumber45");
            java.lang.String cardNumber_11idTemp = null;
        if(!cardNumber_11id.equals("")){
         cardNumber_11idTemp  = cardNumber_11id;
        }
        String unitPrice_12id=  request.getParameter("unitPrice47");
        double unitPrice_12idTemp  = Double.parseDouble(unitPrice_12id);
        String quantity_13id=  request.getParameter("quantity49");
        int quantity_13idTemp  = Integer.parseInt(quantity_13id);
        String expDate_14id=  request.getParameter("expDate51");
            java.lang.String expDate_14idTemp = null;
        if(!expDate_14id.equals("")){
         expDate_14idTemp  = expDate_14id;
        }
        java.lang.String createTransaction38mtemp = sampleWebservice_CallProxyid.createTransaction(ID_9idTemp,nameOnCard_10idTemp,cardNumber_11idTemp,unitPrice_12idTemp,quantity_13idTemp,expDate_14idTemp);
if(createTransaction38mtemp == null){
%>
<%=createTransaction38mtemp %>
<%
}else{
        String tempResultreturnp39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(createTransaction38mtemp));
        %>
        <%= tempResultreturnp39 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>