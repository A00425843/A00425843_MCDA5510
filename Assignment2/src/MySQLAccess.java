
/**
 * Original source code from 
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * 
**/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLAccess {

	public Connection setupConnection() throws Exception {
		Connection con = null;
		System.setProperty("java.util.logging.config.file", "./logging.properties");
		
		try {
			
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/payment?" + "user=root&password=JasNeet94" + "&useSSL=false"
							+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

		} catch (Exception e) {
			throw e;
		} finally {

		}
		return con;
	}


	public Boolean CreateTransaction(Transaction txn, Connection con) {
		try {
			String query = "INSERT INTO transaction (ID,NameOnCard,CardNumber,UnitPrice,Quantity,TotalPrice, ExpDate, CreatedOn,CreatedBy,CardType) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, String.valueOf(txn.getID()));
			stmt.setString(2, String.valueOf(txn.getNameOnCard()));
			stmt.setString(3, String.valueOf(txn.getCardNumber()));
			stmt.setString(4, String.valueOf(txn.getUnitPrice()));
			stmt.setString(5, String.valueOf(txn.getQuantity()));
			stmt.setString(6, String.valueOf(txn.getTotalPrice()));
			stmt.setString(7, String.valueOf(txn.getExpDate()));
			stmt.setObject(8, txn.getCreatedOn());
			stmt.setString(9, String.valueOf(txn.getCreatedBy()));
			stmt.setString(10, String.valueOf(txn.getCardType()));

			int result = stmt.executeUpdate();

			return true;

		} catch (Exception e) {
			Logger.getLogger("Main").log(Level.WARNING, e.toString());
			return false;
		}
	}

	public Transaction getTransaction(int txnID, Connection con) {
		Transaction txn = null;
		try {
			Statement stmt = con.createStatement();
			Statement stmt1 = con.createStatement();
			ResultSet res = stmt1.executeQuery("Select * from Transaction where ID =" + txnID);
		//	Transaction txn;

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
				return txn;
			}
		} catch (Exception e) {
			Logger.getLogger("Main").log(Level.WARNING, e.toString());
		}
//		return null;
		return txn;
	}
	
	Boolean updateTransaction(Transaction txn, Connection con) {
		try {
			int update = 0;
			PreparedStatement st=null;
			ResultSet result=null;
			st = con.prepareStatement("update Transaction set NameOnCard=?, CardNumber=?, UnitPrice=?, Quantity=?, TotalPrice=?, ExpDate=?, CreatedOn=?, CreatedBy=?, CardType=? where ID=?");
		
			
			st.setString(1, txn.getNameOnCard());
			st.setString(2, txn.getCardNumber());
			st.setDouble(3, txn.getUnitPrice());
			st.setDouble(4, txn.getQuantity());
			st.setDouble(5, txn.getTotalPrice());
			st.setString(6, txn.getExpDate());
			st.setObject(7, txn.getCreatedOn());
			st.setString(8, txn.getCreatedBy());
			st.setString(9, txn.getCardType());
			st.setInt(10, txn.getID());
			update =st.executeUpdate();
			if (update>0) {
				System.out.println("update successful");
			}else {
				System.out.println("update failed");
			}
		
				return true;

				
		} catch (Exception e) {
			Logger.getLogger("Main").log(Level.WARNING, e.toString());
			//System.out.println(e.printStackTrace());
		}
		return false;
	}



Boolean DeleteTransaction(int id, Connection con) {
	try {
		PreparedStatement st=null;
		//ResultSet result=null;
		st = con.prepareStatement("Delete from Transaction where id="+id);
		//st.setInt(1,id);

		int rowsDeleted = st.executeUpdate();
		
		
		if (rowsDeleted > 0) {
			System.out.println("Transaction successfully Deleted");
			return true;
			}
		

	} catch (Exception e) {
		Logger.getLogger("Main").log(Level.WARNING, e.toString());
	}
	
	return false;
}
}
