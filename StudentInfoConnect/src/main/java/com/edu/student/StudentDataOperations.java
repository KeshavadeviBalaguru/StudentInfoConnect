package com.edu.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDataOperations {
	static Connection scon=null;
	static ResultSet rs=null;
	static Statement st=null;

		static Scanner sc=new Scanner(System.in);
		static int sid;
		static String sname;
		static String scourse;


	public static void displayStudentInfo() {
		try
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			String sql="select * from edustudent";
			rs=st.executeQuery(sql);
			System.out.println("ID\tSNAME\tSCOURSE");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
				
			}

		
		
	

	public static void insertStudentInfo() {
		//get the connection
		try {
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("My connection"+scon);
			
			//Input data from user
			System.out.println("Enter id of student");
			sid=sc.nextInt();
			//Check id exists
			String sql="select * from edustudent where sid="+sid;
			rs=st.executeQuery(sql);
			
			if(!rs.next()) {
				System.out.println("Enter student name");
				sname=sc.next();
				System.out.println("Enter student Course name");
				scourse=sc.next();
				
		String ins="insert into edustudent values("+sid+",'"+sname+"','"+scourse+"')";
				int  i =st.executeUpdate(ins);
				if(i>0) {
					System.out.println("Student information is registered");
				}
			}else {
				System.out.println("Id already exists Choose another id");
			}
} catch (Exception e) {
			
			e.printStackTrace();
		}  
		
		
		
	}

	public static void updateStudentInfo() {
		try
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("Enter the update sid");
			int sid=sc.nextInt();
			String sql="select * from edustudent where sid="+sid;
			rs=st.executeQuery(sql);
			
			if(rs.next())
			{    System.out.println("What do want to change?");
			     System.out.println("1.Name");
			     System.out.println("2.Course");
			     System.out.println("3.Both Name and Course");
			     int ch=sc.nextInt();
			  switch(ch)
			  {
			  
			  case 1:
				     System.out.println("Enter the name for update");
				     sname=sc.next();
				     String ins="Update edustudent set sname='"+sname+"' where sid="+sid;
				     int i=st.executeUpdate(ins);
				     if(i>0)
				     {
					    System.out.println("Record updated successfully");
				     }
				 break;
			
			  case 2:
			    	 System.out.println("Enter the course for update");
			    	 scourse=sc.next();
			    	 String sql1="update edustudent set scourse='"+scourse+"' where sid="+sid;
			    	 int j=st.executeUpdate(sql1);
			    	 if(j>0) 
			    	 {
			    		 System.out.println("Recors updated successfully");
			    	 }
			    	 break;
				
			  case 3:	
				     System.out.println("Enter the name for update");
			    	 sname=sc.next();
			    	 System.out.println("Enter the course for update");
			    	 scourse=sc.next();
			    	 String upnc="update edustudent set sname='"+sname+"' , scourse='"+scourse+"' where sid="+sid;
			    	 int i1=st.executeUpdate(upnc);
			    	 if(i1>0)
			    	 {
			    		 System.out.println("Record Updated successfully..");
			    	 }
			    	 
			    	 
			     }
						
			}
			else
			{
				System.out.println("ID not exist");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	public static void deleteStudentInfo() {
		try
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("Enter the id for deletion");
			sid=sc.nextInt();
			String sql="select * from edustudent where sid="+sid;
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				String del="delete from edustudent where sid="+sid;
				int i=st.executeUpdate(del);
				if(i>0)
				{
					System.out.println("Record deleted successfully");
				}
			}
			else
			{
				System.out.println("Id not found");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void selectStudentInfo() {
		try
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			
			System.out.println("Enter the sid");
			sid=sc.nextInt();
			String sql="select * from edustudent where sid="+sid;
			rs=st.executeQuery(sql);
			System.out.println("ID\tNAME\tCOURSE");
			if(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			else
			{
				System.out.println("name not exist");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
