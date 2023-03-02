package OurTestDatabase;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=JDBCDatabase;" + "encrypt=true;"
				+ "trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
		//----------------------------------------------------------//	
			
		    String sql = "INSERT INTO Hotels VALUES (1, 'ZaraHotel', 'NewYork', 18,19-09-1998,19-11-1998,01)";
	        st.executeUpdate(sql);
		        
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		//-----------------------------------------------------------//	
		      con.close();
		} catch (Exception ex) {
		System.err.println(ex);
		}

	}

}
