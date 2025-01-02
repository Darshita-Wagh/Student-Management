package student_management;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student_deo {
		
	public static boolean insertRecord(Student st) {
		boolean f = false;
		try {
			Connection con = Cp.createC();
			
			String q = "insert into student_app(sname,sphone,scity) values(?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			pstmt.executeUpdate();
			
			f=true;
			
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return(f);	
	}
	
	public static boolean deleteRecord(int userId) {
		boolean f = false;
		try {

			Connection con = Cp.createC();
			String q2 = "delete from student_app where sid=?";
			PreparedStatement pstmt = con.prepareStatement(q2);
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
			f=true;
			con.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
		
	}
	
	public static void displayRecord() {
		boolean f = false;
		try {
			
			Connection con = Cp.createC();
			
			String q = "select * from student_app";
			
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phoneno = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("\nId : " + id + " Name : " + name + " Phone : " + phoneno
				+ " City : " + city);
			}
			
			f=true;
			set.close();
			stmt.close();
			con.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean createRecords() {
		boolean f=false;
		try {
			Connection con = Cp.createC();
			
			String qString = "create table student_app2(sid int primary key auto_increment, sname varchar(40))";
			
			Statement st=con.createStatement();
			st.executeUpdate(qString);
			System.out.println("Succeessfully table created");
			f=true;
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean updateRecord(int id, String name, String city) {
		boolean f= false;
		try {
			Connection con = Cp.createC();
			
			String q3 = "update student_app set sname=?, scity=? where sid=?";
			
			PreparedStatement pstmt = con.prepareStatement(q3);
			
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			pstmt.setInt(3, id);
			
			pstmt.executeUpdate();
			
			f=true;
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	
}