import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	

		public static void main(String[] args) {
			System.setProperty("java.util.logging.config.file", "./logging.properties");
			Scanner scn = new Scanner(System.in);
			MySQLAccess dao = new MySQLAccess();

			 String Option = "What do you want to do? (enter corresponding integer)\n" +
		                "1 -> Create new transaction\n" +
		                "2 -> Update transaction\n" +
		                "3 -> Delete transaction\n" +
		                "4 -> Print transaction\n" +
		                "0 -> Exit";
			 
			
		try {
			 int Select=-1;
			Connection con = dao.setupConnection();
		
		       while(Select!=0) {

		            System.out.println(Option);

		            try {
		            	Select = scn.nextInt();
		            } catch (Exception e) {
		            	
		  		          System.out.println("Please Try again with Valid Option");
		  		        Logger.getLogger("Main").log(Level.SEVERE,e.getMessage());
		            }

		            switch (Select) {
		                case 1:
							try {
								System.out.print("ENTER TRANSACTION ID ");
								int ID =0;
								//int temp;
								//Logger.getLogger("Main").log(Level.SEVERE,"hello");
							/*	while(true) {
									temp = scn.nextInt();
									Transaction trnx = dao.getTransaction(temp, con	);
									if(trnx==null)
										{
										ID=temp;
										break;
										}
									else
										System.out.println("ID Already taken!!!!Re-Enter ID");
									
								}*/
								
								
								ID = scn.nextInt();								
								scn.nextLine();
						        System.out.print("ENTER NAME ON THE CARD ");
						        String NameOnCard = scn.nextLine();
						                
						        if (NameOnCard.contains(";") || NameOnCard.contains(":") ||NameOnCard.contains("!") || NameOnCard.contains("@") || NameOnCard.contains("#") 
						        || NameOnCard.contains("$") || NameOnCard.contains("%") || NameOnCard.contains("^") || NameOnCard.contains("*") || NameOnCard.contains("+") ||NameOnCard.contains("?") || NameOnCard.contains("<") || NameOnCard.contains(">"))
						        {
						        	System.out.println("Name cannot contain special characters.");
						        	break;
						        }

						        System.out.print("ENTER CARD NUMBER ");
						        String CardNumber = scn.nextLine();
						        if (CardNumber.contains(";") || CardNumber.contains(":") ||CardNumber.contains("!") || CardNumber.contains("@") || CardNumber.contains("#") 
								        || CardNumber.contains("$") || CardNumber.contains("%") || CardNumber.contains("^") || CardNumber.contains("*") || CardNumber.contains("+") ||CardNumber.contains("?") || CardNumber.contains("<") || CardNumber.contains(">"))
								        {
								        	System.out.println("Card Number cannot contain special characters.");
								        	break;
								        }
						        if (CardNumber.length()<15 || CardNumber.length()>17) 	
						        {
						        	System.out.println("Card Number should have 15 or 16 digits.");
						        	break;
						        	
						        }
						        System.out.print("ENTER THE UNIT PRICE ");
						        double UnitPrice=Double.parseDouble(scn.nextLine());
						        
						        System.out.print("ENTER QUANTITY ");
						        int Quantity=Integer.parseInt(scn.nextLine());
						        
						        double TotalPrice = UnitPrice*Quantity;
						        System.out.println("Total Price is" +TotalPrice);
						        
						        System.out.print("ENTER THE EXPIRE DATE ");
						        String ExpDate = scn.nextLine();
						        if (ExpDate.contains(";") || ExpDate.contains(":") ||ExpDate.contains("!") || ExpDate.contains("@") || ExpDate.contains("#") 
								        || ExpDate.contains("$") || ExpDate.contains("%") || ExpDate.contains("^") || ExpDate.contains("*") || ExpDate.contains("+") ||ExpDate.contains("?") || ExpDate.contains("<") || ExpDate.contains(">"))
								        {
								        	System.out.println("Card Number cannot contain special characters.");
								        	break;
								        }
						        
						       
						        Date CreatedOn  = new Date();				        
						        System.out.println("CREATED DATE:" +CreatedOn);
						        
						        String CreatedBy=System.getProperty("user.name");
						        System.out.println("Created by :" +CreatedBy);
						        if (CreatedBy.contains(";") || CreatedBy.contains(":") ||CreatedBy.contains("!") || CreatedBy.contains("@") || CreatedBy.contains("#") 
								        || CreatedBy.contains("$") || CreatedBy.contains("%") || CreatedBy.contains("^") || CreatedBy.contains("*") || CreatedBy.contains("+") ||CreatedBy.contains("?") || CreatedBy.contains("<") || CreatedBy.contains(">"))
								        {
								        	System.out.println("Card Number cannot contain special characters.");
								        	break;
								        }
						        String CardType = "";
						         
						        Transaction txn = new Transaction();
						        txn.setID(ID);
						        txn.setNameOnCard(NameOnCard);
						        txn.setCardNumber(CardNumber);
						        txn.setUnitPrice(UnitPrice);
						        txn.setQuantity(Quantity);
						        txn.setTotalPrice(TotalPrice);
						        txn.setExpDate(ExpDate);
						        txn.setCreatedOn(CreatedOn);
						        txn.setCreatedBy(CreatedBy);
						        txn.setCardType(CardType);
						        
						        // Create Transaction
						        if (dao.CreateTransaction(txn, con)) {
						        	System.out.println("Transaction was successfully created! "+ txn.toString());
						        } else {
						        	System.out.println("Transaction already exist, you can update it ");
						        }
							} 	catch(Exception e) {
								//System.out.println(e);
								Logger.getLogger("Main").log(Level.SEVERE,e.getMessage());
							}
		                    break;
		                case 2:
		                	try {
		                		 // Update Transaction
		                        System.out.println("Enter the id of the transaction you want to update.");
		                       int id = scn.nextInt();
		                     //  Transaction trnx = dao.getTransaction(Integer.parseInt(scn.nextLine()), con);
		                       Transaction trnx = dao.getTransaction(id, con);
		                       // Transaction trnx = new Transaction();
		                       System.out.println("Which value you want to update? Choose the options below :" +
		                                "1 -> id (" + trnx.getID() + ")" +
		                                "2 -> nameOnCard (" + trnx.getNameOnCard() + ")" +
		                                "3 -> cardNumber (" + trnx.getCardNumber() + ")" +
		                                "4 -> unitPrice (" + trnx.getUnitPrice() + ")" +
		                                "5 -> quantity (" + trnx.getQuantity() + ")" +
		                                "6 -> totalPrice (" + trnx.getTotalPrice() + ")" +
		                                "7 -> expDate (" + trnx.getExpDate() + ")" +
		                        		"8 -> CardType (" + trnx.getCardType() + ")");
		                       id = scn.nextInt();
		                       scn.nextLine();
		                        switch (id) {
		                            case 1:
		                                System.out.print("Enter new id: ");
		                                trnx.setID(Integer.parseInt(scn.nextLine()));
		                                break;
		                            case 2:
		                                System.out.print("Enter new nameOnCard: ");
		                                String name=scn.nextLine() ; 
		                                trnx.setNameOnCard(name);
		                                
		                                break;
		                            case 3:
		                                System.out.print("Enter new cardNumber: ");
		                                trnx.setCardNumber(scn.nextLine());
		                                break;
		                            case 4:
		                                System.out.print("Enter new unitPrice: ");
		                                trnx.setUnitPrice(Double.parseDouble(scn.nextLine()));
		                                break;
		                            case 5:
		                                System.out.print("Enter new quantity: ");
		                                trnx.setQuantity(Integer.parseInt(scn.nextLine()));
		                                ;
		                                break;
		                            case 6:
		                                System.out.print("Enter new totalPrice: ");
		                                trnx.setTotalPrice(Double.parseDouble(scn.nextLine()));
		                                ;
		                                break;
		                            case 7:
		                                System.out.print("Enter new expDate: ");
		                                trnx.setExpDate(scn.nextLine());
		                                break;
		                            
		                            case 8:
		                                System.out.print("Enter new expDate: ");
		                                trnx.setExpDate(scn.nextLine());
		                                break;
		                            default:
		                                System.out.print("Invalid input, please try again");
		                        }

		                        dao.updateTransaction(trnx, con);
		                	
		                		
		                	} 	catch(Exception e) {
		                		System.out.println(e);
		                		
		                	}
		                    break;
		                case 3:
		                	try {  
		                    	//DELETE Transaction
		                		
		                		System.out.println("Enter the id of the transaction you want to Delete.");
		                        dao.DeleteTransaction(Integer.parseInt(scn.next()), con);
		                		
		                	} 	catch(Exception e) {
		                		System.out.println(e);
		                		Logger.getLogger("Main").log(Level.SEVERE,e.getMessage());
		                	}
		                    break;
		                case 4:
		                	try {
		                		  // Get Transaction
		                        System.out.print("Enter the id of the transaction you want to print.");
		                        int id = scn.nextInt();
		                        System.out.println("Printing...");
		                        System.out.println(dao.getTransaction(id, con).toString());
		                		
		                	} 	catch(Exception e) {
		                		System.out.println(e);
		                	}
		                    break;
		                case 0: System.out.println("**** THANK YOU! HAVE A GREAT DAY ****"); break;
		                default:
		                    System.out.print("Please Enter Valid Information.");
		                    break;
		            } 	
		       }
	} catch(Exception e) {
		System.out.println(e);
		Logger.getLogger("Main").log(Level.SEVERE,e.getMessage());
	}
		
		}
	
}
			
			
        
	
