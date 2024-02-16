package Task_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TaskInfo 
{
  public static void main(String args[]) throws SQLException
  {
	  Scanner sc=new Scanner(System.in);
		 boolean st=false;
	        TaskInfo obj = new TaskInfo();
	        while(true)
	        {
	        	st=true;
	        	System.out.println("Press 1 for developer");
		        System.out.println("Press 2 for manager");
		        System.out.println("Press 3 for tester");
		        System.out.println("Enter your choice:-");
		        int choice=sc.nextInt();
	        	switch(choice)
	        	{
	        	 case 1:
	        		 obj.Developer();
	        		 break;
	        		 
	        	 case 2:
	        		 obj.Manager();
	        		 break;
	        		 
	        	 case 3:
	        		 obj.Tester();
	        		 break;
	        	 default:
	        		 System.out.println("Wrong Input");
	        		 break;
	        	}
	        	
	        }
	  
  }
  
  public void Developer() throws SQLException 
	{
	    Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name:-");
		String nm=sc.next();
		System.out.println("Enter your task:-");
		String tsk=sc.next();
		System.out.println("Enter the time in days to complete the task:-");
		int tm=sc.nextInt();
		
		String s1="INSERT INTO DEV" +
		        "  (dev_nm,dev_tsk,dev_dys) VALUES " +
		        " (?, ?, ?);";
        try (Connection con = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/test","root","");
        		
        		PreparedStatement prsmt = con.prepareStatement(s1)) 
            {
                
              prsmt.setString(1, nm);
              prsmt.setString(2, tsk);
              prsmt.setInt(3, tm);
              prsmt.executeUpdate();
            }
        catch (SQLException e) {
          System.out.println(e);
        }
	}
	
	public void Manager() throws SQLException 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name:-");
		String nm1=sc.next();
		System.out.println("Enter sprint number:-");
		int numspt=sc.nextInt();
		System.out.println("Enter total ticket of this sprint:-");
		int tltik=sc.nextInt();
		
		String s1="INSERT INTO MANGR" +
		        "  (man_nm,man_numspt,man_tltik) VALUES " +
		        " (?, ?, ?);";
        try (Connection con = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/test","root","");
        		
        		PreparedStatement prsmt = con.prepareStatement(s1)) 
            {
                
              prsmt.setString(1, nm1);
              prsmt.setInt(2, numspt);
              prsmt.setInt(3, tltik);
              prsmt.executeUpdate();
            }
        catch (SQLException e) {
          System.out.println(e);
        }
		
	}
	
	public void Tester() throws SQLException 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name:-");
		String nm2=sc.next();
		System.out.println("Enter your task:-");
		String tsk2=sc.next();
		System.out.println("Enter the time in days to complete the task:-");
		int tm2=sc.nextInt();
		
		String s1="INSERT INTO TESTR" +
		        "  (testr_nm,testr_tsk,testr_tm) VALUES " +
		        " (?, ?, ?);";
		
		try (Connection con = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/test","root","");
	        		
	        		PreparedStatement prsmt = con.prepareStatement(s1)) 
	            {
	                
	              prsmt.setString(1, nm2);
	              prsmt.setString(2, tsk2);
	              prsmt.setInt(3, tm2);
	              prsmt.executeUpdate();
	            }
	        catch (SQLException e) {
	          System.out.println(e);
	        }
	}
}

