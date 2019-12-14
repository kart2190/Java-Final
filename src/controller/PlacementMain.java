package controller;

import java.util.Scanner;

public class PlacementMain {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String args[])
	{
		System.out.println("Welcome Placement Management System\n\n");
		while(true)
		{
			try
			{
				System.out.println("1.Admin login\t2.Student login \n");
				int option=sc.nextInt();
				if(option==1)
				{
					PlacementAdmin.Login();
				}
				else if(option==2)
				{
					PlacementStudent.Login();
				}
				else if(option==3)
				{
					break;
				}
				else
				{
					System.out.println("\n\n Enter the provided option \n\n");
				}
			}
			catch(Exception E)
			{
				System.out.println("Error in the system, please try again"+E.getMessage());
			}
		}
		
	}
	
}