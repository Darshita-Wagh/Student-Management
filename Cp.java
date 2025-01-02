package student_management;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cp {
	
	static Connection con;
	
	public static Connection createC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/student";
			String user = "root";
			String pass = "";
			con = DriverManager.getConnection(url,user,pass);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
