import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseConnectivity {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		String username = "root";
		String password = "vatsal";
		String databaseURL = "jdbc:mysql://localhost/bif805";
		String query1 = "Select Prot_id, Prot_name, Prot_type, Num_residues FROM protein";
		String insertquery = "INSERT INTO protein VALUES (6, 'MECP2', 'recepter', 500)"; 
		Connection conn = null;
		Statement stmt = null;
		ResultSet record;
		
		System.out.println("attempting to connect to database: " + databaseURL + "\t" + "Username: "+ username + "\t" + "Password: " + password);
		try {
			conn = DriverManager.getConnection(databaseURL, username, password);
			System.out.println("Database connection established!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(conn != null){
			try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(stmt != null){
				System.out.println("Ready to execute query!!");
				try {
					record = stmt.executeQuery(query1);
					while(record.next()){
						int Prot_id = record.getInt("Prot_id");
						String Prot_name = record.getString("Prot_name");
						String Prot_type = record.getString("Prot_type");
						int num_residues = record.getInt("num_residues");
						System.out.println("Id: " + Prot_id + "Name: " + Prot_name + "Type: " + Prot_type + "Residue: " + num_residues);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("insert a record");
				try {
					stmt.executeUpdate(insertquery);
					System.out.println("update a record");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
