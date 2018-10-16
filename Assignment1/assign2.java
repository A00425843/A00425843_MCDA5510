import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class transaction {
	
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	
		public static void main(String[] args) {
	try {
		//Driver Registration
	Class.forName(DATABASE_DRIVER);
		//establishing connection
	Connection con = DriverManager
			.getConnection("jdbc:mysql://localhost/samplecompany?"   //DTP I spelled transactoins wrong oops 
	             + "user=root&password=JasNeet94"   //Creds
	             +"&useSSL=false"                  // b/c localhost
			     +"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");  // timezone
		//select query
		Statement stmt=con.createStatement();
		ResultSet result=stmt.executeQuery("Select * from customer");
		while(result.next()) {
			String FirstName = result.getString(3);
			String LastName = result.getString(5);
	System.out.println(FirstName+""+LastName);
		}
		con.close();
		
	}
			catch(Exception e) {
				System.out.println(e);
			}

			}

}