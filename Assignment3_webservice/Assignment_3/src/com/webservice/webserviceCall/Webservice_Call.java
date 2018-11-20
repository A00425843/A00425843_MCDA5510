package com.webservice.webserviceCall;

import java.io.IOException;
import java.util.Scanner;

import com.webservice.operation.*;
import com.webservice.transaction.Transaction;

public class Webservice_Call {
	
	public String createTransaction(int ID, String NameOnCard,String CardNumber,double UnitPrice,int Quantity, String ExpDate) throws InstantiationException, IllegalAccessException, SecurityException, IOException {
				
		Transaction txn = new Transaction();
	
		txn.setID(ID);
		  if (NameOnCard.contains(";") || NameOnCard.contains(":") ||NameOnCard.contains("!") || NameOnCard.contains("@") || NameOnCard.contains("#") 
			        || NameOnCard.contains("$") || NameOnCard.contains("%") || NameOnCard.contains("^") || NameOnCard.contains("*") || NameOnCard.contains("+") ||NameOnCard.contains("?") || NameOnCard.contains("<") || NameOnCard.contains(">"))
			        {
			        	return "Contains Special Character";
			        }
		txn.setNameOnCard(NameOnCard);
		if (CardNumber.contains(";") || CardNumber.contains(":") ||CardNumber.contains("!") || CardNumber.contains("@") || CardNumber.contains("#") 
		        || CardNumber.contains("$") || CardNumber.contains("%") || CardNumber.contains("^") || CardNumber.contains("*") || CardNumber.contains("+") ||CardNumber.contains("?") || CardNumber.contains("<") || CardNumber.contains(">"))
		        {
		        	return "Contains Special Character";
		        }
		txn.setCardNumber(CardNumber);
		txn.setUnitPrice(UnitPrice);
		txn.setQuantity(Quantity);
		if (ExpDate.contains(";") || ExpDate.contains(":") ||ExpDate.contains("!") || ExpDate.contains("@") || ExpDate.contains("#") 
		        || ExpDate.contains("$") || ExpDate.contains("%") || ExpDate.contains("^") || ExpDate.contains("*") || ExpDate.contains("+") ||ExpDate.contains("?") || ExpDate.contains("<") || ExpDate.contains(">"))
		        {
		        	return "Contains Special Character";
		        }
		txn.setExpDate(ExpDate);
			
		Mysql_Access insert=new Mysql_Access();
		boolean temp=insert.insert_ID(txn);
		if (temp==true)
		{

			return "ID Inserted";
		}else
			return "ID not Inserted";
	}
	
	public String updateTransaction(int ID, String NameOnCard,String CardNumber,double UnitPrice,int Quantity, String ExpDate) throws InstantiationException, IllegalAccessException, SecurityException, IOException {
		
		Transaction txn = new Transaction();
    
               
				txn.setID(ID);
				 if (NameOnCard.contains(";") || NameOnCard.contains(":") ||NameOnCard.contains("!") || NameOnCard.contains("@") || NameOnCard.contains("#") 
					        || NameOnCard.contains("$") || NameOnCard.contains("%") || NameOnCard.contains("^") || NameOnCard.contains("*") || NameOnCard.contains("+") ||NameOnCard.contains("?") || NameOnCard.contains("<") || NameOnCard.contains(">"))
					        {
					        	return "Contains Special Character";
					        }
         		txn.setNameOnCard(NameOnCard);
         		if (CardNumber.contains(";") || CardNumber.contains(":") ||CardNumber.contains("!") || CardNumber.contains("@") || CardNumber.contains("#") 
        		        || CardNumber.contains("$") || CardNumber.contains("%") || CardNumber.contains("^") || CardNumber.contains("*") || CardNumber.contains("+") ||CardNumber.contains("?") || CardNumber.contains("<") || CardNumber.contains(">"))
        		        {
        		        	return "Contains Special Character";
        		        }
         		txn.setCardNumber(CardNumber);
         		txn.setUnitPrice(UnitPrice);
         		txn.setQuantity(Quantity);
         		if (ExpDate.contains(";") || ExpDate.contains(":") ||ExpDate.contains("!") || ExpDate.contains("@") || ExpDate.contains("#") 
        		        || ExpDate.contains("$") || ExpDate.contains("%") || ExpDate.contains("^") || ExpDate.contains("*") || ExpDate.contains("+") ||ExpDate.contains("?") || ExpDate.contains("<") || ExpDate.contains(">"))
        		        {
        		        	return "Contains Special Character";
        		        }
         		txn.setExpDate(ExpDate);
         		Mysql_Access update=new Mysql_Access();
         		boolean temp=update.Update_ID(txn);
         			
         			if (temp==true)
         			{

         				return "ID Updated Successfully";
         			}else
         				return "Update Failed";
         		}
         		
         
public String deleteTransaction(int ID) throws InstantiationException, IllegalAccessException, SecurityException, IOException {
	
	Transaction txn = new Transaction();
          
			txn.setID(ID);
     		
     		Mysql_Access delete=new Mysql_Access();
     		boolean temp = delete.Delete_Transaction(txn);
     		if (temp==true)
 			{

 				return "ID Deleted Successfully";
 			}else
 				return "Delete Failed";
 		}
 		
public String get_Transaction(int ID) throws InstantiationException, IllegalAccessException, SecurityException, IOException {
	
	Transaction txn = new Transaction();
          
			txn.setID(ID);   		
     		Mysql_Access get=new Mysql_Access();
     		Transaction temp = get.get_Transaction(txn);
     		return temp.toString();
     }
	}


