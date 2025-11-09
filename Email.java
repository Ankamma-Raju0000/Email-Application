package com;

import java.util.Iterator;
import java.util.Scanner;

public class Email
{
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String department;
	private int mailBoxCapacity=500;
	private int defaultpasswordLength=10;
	private String alternativeEmail;
	private String companySuffix="company.com";
	
	
	//constructor to receive the firstname and lastname
	public Email(String firstName, String lastName) 
	{
		
		this.firstName = firstName;
		this.lastName = lastName;
//		System.out.println("EMAIL CREATED :"+this.firstName + "  " + this.lastName);
		
		//call a method asking for the department - return the department
		this.department=	setDepartment();
//		System.out.println("Department :"+this.department);
		
		//call a method that returns random password
		this.password=randomPassword(defaultpasswordLength);
		System.out.println("Your Password is "+this.password);
		
		//combine elements to generate email
		email=firstName.toLowerCase() +  lastName.toLowerCase() + "@" + department + "." + companySuffix;
//        System.out.println("Your Email is :"+email);		
		
	}
	
	//ask for the department
	private String setDepartment()
	{
		System.out.println("DEPARTMENT CODES\n1 Sales\n2 Development\n3 Accounting\n0 None\nEnter Department code:");
		Scanner sc=new Scanner(System.in);
		int deptChoice=sc.nextInt();
		if (deptChoice == 1)
		{
			return "Sales";			
		} 
		else if (deptChoice == 2)
		{
			return "Accounting";
		}
		else if (deptChoice == 3)
		{
			return "Development";
		}
		else
		{
			return "";
		}
	}
	
	//Generate a random password
	private String randomPassword(int length)
	{
		String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
		char[] password=new char[length];
		for (int i = 0; i < length; i++) 
		{
			int random=(int) (Math.random() * passwordSet.length());
			password[i]=passwordSet.charAt(random);			
		}
		return new String(password);
	}
	
	//set the mail box capacity
	public void setMailBoxCapacity(int capacity)
	{
		this.mailBoxCapacity=capacity;
	}
	
	//set the alternative email
	public void setAlternativeEmail(String altEmail)
	{
		this.alternativeEmail=altEmail;
	}
	
	//change the password
	public void changePassword(String password)
	{
		this.password=password;
	}
	
	
	
	public int getMailBoxCapacity()
	{
		return mailBoxCapacity;
	}
	public String getAlternateEmail() 
	{
		return alternativeEmail;
	}
	public String getChangePassword()
	{
		return password;
	}
	
	
	public String showInfo()
	{
		return "DISPLAY NAME :"+ firstName + " " + lastName +
				"\nCOMPANY EMAIL :"+email+
				"\nMAILBOXCAPACITY :"+mailBoxCapacity+"mb";
	}
	

}
