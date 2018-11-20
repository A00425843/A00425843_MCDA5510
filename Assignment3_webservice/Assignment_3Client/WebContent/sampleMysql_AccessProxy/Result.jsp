<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleMysql_AccessProxyid" scope="session" class="com.webservice.operation.Mysql_AccessProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleMysql_AccessProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleMysql_AccessProxyid.getEndpoint();
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
        sampleMysql_AccessProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.webservice.operation.Mysql_Access getMysql_Access10mtemp = sampleMysql_AccessProxyid.getMysql_Access();
if(getMysql_Access10mtemp == null){
%>
<%=getMysql_Access10mtemp %>
<%
}else{
        if(getMysql_Access10mtemp!= null){
        String tempreturnp11 = getMysql_Access10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String createdBy_2id=  request.getParameter("createdBy18");
            java.lang.String createdBy_2idTemp = null;
        if(!createdBy_2id.equals("")){
         createdBy_2idTemp  = createdBy_2id;
        }
        String cardType_3id=  request.getParameter("cardType20");
            java.lang.String cardType_3idTemp = null;
        if(!cardType_3id.equals("")){
         cardType_3idTemp  = cardType_3id;
        }
        String quantity_4id=  request.getParameter("quantity22");
        int quantity_4idTemp  = Integer.parseInt(quantity_4id);
        String iD_5id=  request.getParameter("iD24");
        int iD_5idTemp  = Integer.parseInt(iD_5id);
        String expDate_6id=  request.getParameter("expDate26");
            java.lang.String expDate_6idTemp = null;
        if(!expDate_6id.equals("")){
         expDate_6idTemp  = expDate_6id;
        }
        String nameOnCard_7id=  request.getParameter("nameOnCard28");
            java.lang.String nameOnCard_7idTemp = null;
        if(!nameOnCard_7id.equals("")){
         nameOnCard_7idTemp  = nameOnCard_7id;
        }
        String unitPrice_8id=  request.getParameter("unitPrice30");
        double unitPrice_8idTemp  = Double.parseDouble(unitPrice_8id);
        String totalPrice_9id=  request.getParameter("totalPrice32");
        double totalPrice_9idTemp  = Double.parseDouble(totalPrice_9id);
        String createdOn_10id=  request.getParameter("createdOn34");
            java.util.Calendar createdOn_10idTemp = null;
        if(!createdOn_10id.equals("")){
        java.text.DateFormat dateFormatcreatedOn34 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempcreatedOn34  = dateFormatcreatedOn34.parse(createdOn_10id);
         createdOn_10idTemp = new java.util.GregorianCalendar();
        createdOn_10idTemp.setTime(dateTempcreatedOn34);
        }
        String cardNumber_11id=  request.getParameter("cardNumber36");
            java.lang.String cardNumber_11idTemp = null;
        if(!cardNumber_11id.equals("")){
         cardNumber_11idTemp  = cardNumber_11id;
        }
        %>
        <jsp:useBean id="com1webservice1transaction1Transaction_1id" scope="session" class="com.webservice.transaction.Transaction" />
        <%
        com1webservice1transaction1Transaction_1id.setCreatedBy(createdBy_2idTemp);
        com1webservice1transaction1Transaction_1id.setCardType(cardType_3idTemp);
        com1webservice1transaction1Transaction_1id.setQuantity(quantity_4idTemp);
        com1webservice1transaction1Transaction_1id.setID(iD_5idTemp);
        com1webservice1transaction1Transaction_1id.setExpDate(expDate_6idTemp);
        com1webservice1transaction1Transaction_1id.setNameOnCard(nameOnCard_7idTemp);
        com1webservice1transaction1Transaction_1id.setUnitPrice(unitPrice_8idTemp);
        com1webservice1transaction1Transaction_1id.setTotalPrice(totalPrice_9idTemp);
        com1webservice1transaction1Transaction_1id.setCreatedOn(createdOn_10idTemp);
        com1webservice1transaction1Transaction_1id.setCardNumber(cardNumber_11idTemp);
        boolean insert_ID13mtemp = sampleMysql_AccessProxyid.insert_ID(com1webservice1transaction1Transaction_1id);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insert_ID13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 38:
        gotMethod = true;
        String createdBy_13id=  request.getParameter("createdBy43");
            java.lang.String createdBy_13idTemp = null;
        if(!createdBy_13id.equals("")){
         createdBy_13idTemp  = createdBy_13id;
        }
        String cardType_14id=  request.getParameter("cardType45");
            java.lang.String cardType_14idTemp = null;
        if(!cardType_14id.equals("")){
         cardType_14idTemp  = cardType_14id;
        }
        String quantity_15id=  request.getParameter("quantity47");
        int quantity_15idTemp  = Integer.parseInt(quantity_15id);
        String iD_16id=  request.getParameter("iD49");
        int iD_16idTemp  = Integer.parseInt(iD_16id);
        String expDate_17id=  request.getParameter("expDate51");
            java.lang.String expDate_17idTemp = null;
        if(!expDate_17id.equals("")){
         expDate_17idTemp  = expDate_17id;
        }
        String nameOnCard_18id=  request.getParameter("nameOnCard53");
            java.lang.String nameOnCard_18idTemp = null;
        if(!nameOnCard_18id.equals("")){
         nameOnCard_18idTemp  = nameOnCard_18id;
        }
        String unitPrice_19id=  request.getParameter("unitPrice55");
        double unitPrice_19idTemp  = Double.parseDouble(unitPrice_19id);
        String totalPrice_20id=  request.getParameter("totalPrice57");
        double totalPrice_20idTemp  = Double.parseDouble(totalPrice_20id);
        String createdOn_21id=  request.getParameter("createdOn59");
            java.util.Calendar createdOn_21idTemp = null;
        if(!createdOn_21id.equals("")){
        java.text.DateFormat dateFormatcreatedOn59 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempcreatedOn59  = dateFormatcreatedOn59.parse(createdOn_21id);
         createdOn_21idTemp = new java.util.GregorianCalendar();
        createdOn_21idTemp.setTime(dateTempcreatedOn59);
        }
        String cardNumber_22id=  request.getParameter("cardNumber61");
            java.lang.String cardNumber_22idTemp = null;
        if(!cardNumber_22id.equals("")){
         cardNumber_22idTemp  = cardNumber_22id;
        }
        %>
        <jsp:useBean id="com1webservice1transaction1Transaction_12id" scope="session" class="com.webservice.transaction.Transaction" />
        <%
        com1webservice1transaction1Transaction_12id.setCreatedBy(createdBy_13idTemp);
        com1webservice1transaction1Transaction_12id.setCardType(cardType_14idTemp);
        com1webservice1transaction1Transaction_12id.setQuantity(quantity_15idTemp);
        com1webservice1transaction1Transaction_12id.setID(iD_16idTemp);
        com1webservice1transaction1Transaction_12id.setExpDate(expDate_17idTemp);
        com1webservice1transaction1Transaction_12id.setNameOnCard(nameOnCard_18idTemp);
        com1webservice1transaction1Transaction_12id.setUnitPrice(unitPrice_19idTemp);
        com1webservice1transaction1Transaction_12id.setTotalPrice(totalPrice_20idTemp);
        com1webservice1transaction1Transaction_12id.setCreatedOn(createdOn_21idTemp);
        com1webservice1transaction1Transaction_12id.setCardNumber(cardNumber_22idTemp);
        boolean update_ID38mtemp = sampleMysql_AccessProxyid.update_ID(com1webservice1transaction1Transaction_12id);
        String tempResultreturnp39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(update_ID38mtemp));
        %>
        <%= tempResultreturnp39 %>
        <%
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