package OurTestDatabase;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Test2 {

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
			// -------------------------------------------------------------//

			String tableCreationHolder = "CREATE TABLE Hotels (" + "id INT  , " + "hotel_name VARCHAR(255) NOT NULL, "
					+ "hotel_location VARCHAR(255), " + "created_date DATE NOT NULL, " + "updated_date DATE, "
					+ "is_active INT NOT NULL, " + "PRIMARY KEY (id)" + ");"

					+ "CREATE TABLE Room_Type (" + "id INT NOT NULL , " + "room_type_name VARCHAR(255) NOT NULL, "
					+ "created_date DATE, " + "updated_date DATE, " + "is_active int NOT NULL, " + "PRIMARY KEY (id)"
					+ ");"

					+ "CREATE TABLE Rooms (" + "id INT NOT NULL , " + "room_type_id INT NOT NULL, "
					+ "hotel_id INT NOT NULL, " + "created_date DATE NOT NULL, " + "updated_date DATE, "
					+ "is_active int NOT NULL, " + "PRIMARY KEY (id), "
					+ "FOREIGN KEY (room_type_id) REFERENCES Room_Type(id), "
					+ "FOREIGN KEY (hotel_id) REFERENCES Hotels(id)" + ");"

					+ "CREATE TABLE Employee_Type (" + "id INT PRIMARY KEY,"
					+ "employee_type_name VARCHAR(255) NOT NULL," + "created_date DATE NOT NULL," + "updated_date DATE,"
					+ "is_active int NOT NULL" + ");" + "CREATE TABLE Guests (" + "id INT PRIMARY KEY,"
					+ "guest_name VARCHAR(255) NOT NULL," + "guest_phone VARCHAR(255) NOT NULL,"
					+ "guest_accompanying_members INT NOT NULL," + "guest_payment_amount INT NOT NULL," + "room_id INT,"
					+ "hotel_id INT," + "created_date DATE NOT NULL," + "updated_date DATE,"
					+ "is_Active int NOT NULL);"

					+ "CREATE TABLE Employees (" + "id INT PRIMARY KEY," + "employee_type_id INT NOT NULL,"
					+ "room_id INT NOT NULL," + "created_date DATE NOT NULL," + "updated_date DATE,"
					+ "is_active int NOT NULL," + "FOREIGN KEY (employee_type_id) REFERENCES Employee_Type(id),"
					+ "FOREIGN KEY (room_id) REFERENCES Rooms(id)" + ")";
			st.execute(tableCreationHolder);
			
			Integer m = st.executeUpdate(tableCreationHolder);
			if (m >= 1) {
				System.out.println("inserted successfully : " + tableCreationHolder);
			} else {
				System.out.println("insertion failed");
			}

			// ------------------------------------------------------------------//

			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
}
