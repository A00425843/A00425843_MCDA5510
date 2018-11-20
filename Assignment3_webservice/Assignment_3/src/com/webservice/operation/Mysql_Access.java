package com.webservice.operation;

import java.io.IOException;
import java.sql.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.webservice.connection.Connection_Mysql;
import com.webservice.transaction.Transaction;

public class Mysql_Access {
	public static Logger logger;
	public Mysql_Access() throws SecurityException, IOException {
		logger = Logger.getLogger("Main");  
	    FileHandler fh;  
	    // This block configure the logger with handler and formatter  
	    fh = new FileHandler("/home/student_2018_fall/j_kour/A00425843_MCDA5510/Assignment_3/log/log.log");  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  
	}
	
	public boolean insert_ID(Transaction trs) throws InstantiationException, IllegalAccessException
	{
			Connection_Mysql my_Conn;
			try {
				my_Conn = Connection_Mysql.getInstance();
				Connection con=Connection_Mysql.getDBConnection();
				
				String query = "INSERT INTO transaction (ID,NameOnCard,CardNumber,UnitPrice,Quantity,TotalPrice,ExpDate,CreatedOn,CreatedBy,CardType) values (?,?,?,?,?,?,?,NOW(),?,?)";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, String.valueOf(trs.getID()));
				stmt.setString(2, trs.getNameOnCard());
				stmt.setString(3,trs.getCardNumber());
				stmt.setString(4, String.valueOf(trs.getUnitPrice()));
				stmt.setString(5, String.valueOf(trs.getQuantity()));
				stmt.setDouble(6, (trs.getUnitPrice()*trs.getQuantity()));
				stmt.setString(7, trs.getExpDate());
				stmt.setString(8, System.getProperty("user.name"));
				
				stmt.setString(9, String.valueOf(trs.getCardType()));

				int result = stmt.executeUpdate();
				logger.info("insert successfully");
			return true;

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
				
	}
	
	public boolean Update_ID(Transaction txn) throws InstantiationException, IllegalAccessException
	{
		Connection_Mysql my_Conn;
		try {
			
			my_Conn = Connection_Mysql.getInstance();
			Connection con=Connection_Mysql.getDBConnection();
			
			int update = 0;
			PreparedStatement st = null;
			st = con.prepareStatement("UPDATE transaction set NameOnCard=?, CardNumber=?, UnitPrice=?, Quantity=?,TotalPrice=?, ExpDate=? WHERE ID=?");
		
			
			st.setString(1, txn.getNameOnCard());
			st.setString(2, txn.getCardNumber());
			st.setString(3, String.valueOf(txn.getUnitPrice()));
			st.setString(4, String.valueOf(txn.getQuantity()));
			st.setDouble(5, (txn.getUnitPrice()*txn.getQuantity()));
			st.setString(6, txn.getExpDate());
			st.setString(7, String.valueOf(txn.getID()));
			System.out.println(st.toString());
			update =st.executeUpdate();
			logger.info("update successfully");

			if (update>0) {
				System.out.println("update successful");
			}else {
				System.out.println("update failed");
			}
			
				return true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
			

	}

	

	public boolean Delete_Transaction(Transaction txn) throws InstantiationException, IllegalAccessException
	{
		Connection_Mysql my_Conn;
		try {
			
			my_Conn = Connection_Mysql.getInstance();
			Connection con=Connection_Mysql.getDBConnection();
			
			PreparedStatement st=null;
			st = con.prepareStatement("Delete from transaction where ID="+txn.getID());
	

			int rowsDeleted = st.executeUpdate();
			
			
			if (rowsDeleted > 0) {
				System.out.println("Transaction successfully Deleted");
				logger.info("Transaction successfully Deleted");
				return true;
				}
			

		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
		
		return false;
	}
	
	public Transaction get_Transaction(Transaction txn) throws InstantiationException, IllegalAccessException
	{
		Connection_Mysql my_Conn;
		try {
			
			my_Conn = Connection_Mysql.getInstance();
			Connection con=Connection_Mysql.getDBConnection();
			
			Statement stmt = con.createStatement();
			Statement stmt1 = con.createStatement();
			ResultSet res = stmt1.executeQuery("Select * from transaction where ID =" +txn.getID());
	

			while (res.next()) {
				txn = new Transaction();
				txn.setID(res.getInt(1));
				txn.setNameOnCard(res.getString(2));
				txn.setCardNumber(res.getString(3));
				txn.setUnitPrice(res.getDouble(4));
				txn.setQuantity(res.getInt(5));
				txn.setTotalPrice(res.getDouble(6));
				txn.setExpDate(res.getString(7));
				txn.setCreatedOn(res.getDate(8));
				txn.setCreatedBy(res.getString(9));
				txn.setCardType(res.getString(10));
				System.out.println(txn.toString());
				logger.info(txn.toString());
				return txn;
				
			}
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}

		return txn;
}
}
	

