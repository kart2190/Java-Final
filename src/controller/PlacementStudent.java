package controller;
import java.sql.*;
import java.util.*;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class PlacementStudent 
{
	static Scanner sc=new Scanner(System.in);
    static Connection con=null;
        public static void getConnection()
        {
                try
                {
                	Class.forName("com.mysql.jdbc.Driver");
                        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","");
                }catch(SQLException e){
                        e.printStackTrace();
                }catch(ClassNotFoundException e){
                        e.printStackTrace();
                } 
        }
        
        
        public static void display(int Student_Login_Id)
        {
                try
                {
                		
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from students where Student_Login_id='"+Student_Login_Id+"' ");
                        while(rs.next())
                        {
                                System.out.println("\n Student_Logihn_ID "+rs.getString(1)+"\n Student_Password "+rs.getString(2)+"\n First_Name: "+rs.getString(3)+"\n Last_Name: "+rs.getString(8)+"\n Sex "+rs.getString(4)+"\n Age "+rs.getString(5)+"\n Grad_Year "+rs.getString(6)+"\n Percentage "+rs.getString(7));
                        }
                }catch(Exception e){
                        e.printStackTrace();
                }
        }
        
        public static void update(int Student_Login_Id)
        {
                try
                {		
                		System.out.println("Enter Student Login ID - ");
                		int Student_Login_id=sc.nextInt();
                		System.out.println("Enter Student Password - ");
                		String Student_Password=sc.next();
                		System.out.println("Enter Student FirstName - ");
                		String First_Name=sc.next();
                		System.out.println("Enter Student LastName - ");
                		String Last_Name=sc.next();
                		System.out.println("Enter Sex (0/1)  - ");
                		String Sex=sc.next();
                		System.out.println("Age - ");
                		int Age=sc.nextInt();
                		System.out.println("Enter Student Grad Year (YYYY-MM-DD) - ");
                		String Grad_Year=sc.next();
                		System.out.println("Percentage - ");
                		int Percentage=sc.nextInt();
                       	PreparedStatement preparedStatement=con.prepareStatement("update students set Student_Password='"+Student_Password+"',First_Name='"+First_Name+"',Last_Name='"+Last_Name+"',Sex='"+Sex+"',Age='"+Age+"',Grad_Year='"+Grad_Year+"',Percentage='"+Percentage+"' where Student_Login_id='"+Student_Login_id+"'");
                       	if (preparedStatement.execute())
                        {
                       		System.out.println("\n\n Student detials successfully updated \n");
                        }
                                
                }catch(Exception e){
                        e.printStackTrace();
                }
        }
        
        public static void viewPlacementOffer(int Student_Login_id)
        {
                try
                {	
                	Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("select * from student_company,company where student_company.Student_Login_id='"+Student_Login_id+"' and student_company.Company_id=company.Company_id;");
                    while(rs.next())
                    {
                            System.out.println("\n Student Id ="+rs.getString(1)+"\n Company Id ="+rs.getString(2)+"\n Company Id ="+rs.getString(3)+"\n Company Name ="+rs.getString(4)+"\n Job Category ="+rs.getString(5)+"\n Job title ="+rs.getString(6)+"\n Salary ="+rs.getString(7)+"\n Location ="+rs.getString(8)+"\n Position ="+rs.getString(9));
                    }
            }catch(Exception e){
                    e.printStackTrace();
            }
        }
        
        public static void Login() {
        	try
            {		
        			getConnection();
        			System.out.println("Enter Student Login ID - ");
            		int Student_Login_id=sc.nextInt();
            		System.out.println("Enter Student Password - ");
            		String Student_Password=sc.next();
            		Statement stmt=con.createStatement();
                    		ResultSet rs=stmt.executeQuery("select * from students where Student_Login_id='"+Student_Login_id+"' and Student_Password='"+Student_Password+"' ");
                    		while(rs.next())
                    		{
                    			System.out.println("\n\n\n 1) View Details \n 2) Edit Details \n 3) Placement Offer ");
                        		int ch=sc.nextInt();
                                switch(ch)
                                {
                                case(1):display(Student_Login_id);
                                		break;
                                case(2):update(Student_Login_id);
                                		break;
                                case(3):viewPlacementOffer(Student_Login_id);
                                		break;
                                default: System.out.println("Enter proper option");
                        		break;
                    		}
              }
            }
catch(Exception e){
                    System.out.println("Credentials are incorrect");
            }
        	
        }
        
}                                    