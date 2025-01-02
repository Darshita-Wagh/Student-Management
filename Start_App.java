package student_management;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;

public class Start_App {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("*********Welcome to Student Management System*******");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("1.Insert Student Records");
			System.out.println("2.Delete Student Records");
			System.out.println("3.Display Student Records");
			System.out.println("4.Create Student Table");
			System.out.println("5.Update Student Records application");
			System.out.println("6.Exit application");
			
			System.out.println("Select Operation : ");
			int op = Integer.parseInt(br.readLine());
			if(op==1) {
				
				System.out.println("Enter student name : ");
				String name = br.readLine();
				
				System.out.println("Enter student phone : ");
				String phone = br.readLine();
				
				System.out.println("Enter student City : ");
				String city = br.readLine();
				
				Student st = new Student(name, phone, city);
				boolean answer = Student_deo.insertRecord(st);
				
				if(answer) {
					System.out.println("Student record added successfully");
				}
				else {
					System.out.println("Student record not added");
				}
				
				System.out.println(st);
			}
			else if(op==2) {
				
				System.out.println("Enter the id to be delete : ");
				int id = Integer.parseInt(br.readLine());
				
				boolean ans = Student_deo.deleteRecord(id);
				
				if(ans==true) {
					System.out.println("Deleted...");
				}
				else {
					System.out.println("Something went wrong...");
				}
				
				
			}
			else if(op==3) {
				
				Student_deo.displayRecord();
			}
			else if (op==4) {

				boolean ans = Student_deo.createRecords();
				
				if(ans==true) {
					System.out.println("Created successfully");
				}
				else {
					System.out.println("Something went wrong...");
				}
			}
			else if(op==5) {
				
				System.out.println("Enter id to be update : ");
				int uid = Integer.parseInt(br.readLine());
				System.out.println("Enter name to be update : ");
				String name = br.readLine();
				System.out.println("Enter city to be update : ");
				String city = br.readLine();
				
				boolean f = Student_deo.updateRecord(uid, name, city);
				if(f) {
					System.out.println("Record updated successfully");
				}
				else {
					System.out.println("Something went wrong...");
				}
			}
			else {
				System.out.println("Exit from application");
				System.exit(0);
			}
			System.out.println("Thank you using CRUD operation");
		}
	}
}
