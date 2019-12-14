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
public class PlacementAdmin {
	
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
        
        public static void enterCompanyDetails()
        {
                try
                {		
                		System.out.println("Enter Companyid (num) - ");
                		int Company_id=sc.nextInt();
                		System.out.println("Enter Company_Name - ");
                		String Company_Name=sc.next();
                		System.out.println("Enter Job Category - ");
                		String Job_Category=sc.next();
                		System.out.println("Enter Job_Title - ");
                		String Job_Title=sc.next();
                		System.out.println("Enter Salary  - ");
                		String Salary=sc.next();
                		System.out.println(" Location - ");
                		String Location=sc.next();
                		System.out.println("Enter no of Positions - ");
                        String Positions=sc.next();
                       	PreparedStatement preparedStatement=con.prepareStatement("insert into company values('"+Company_id+"','"+Company_Name+"','"+Job_Category+"','"+Job_Title+"','"+Salary+"','"+Location+"','"+Positions+"')");
                       	if (preparedStatement.execute())
                        {
                       		System.out.println("\n\n  detials successfully updated \n");
                        }
                                
                }catch(Exception e){
                        e.printStackTrace();
                }
        }
        	
        public static void viewCompanyDetails()
            {
                    try
                    {	
                    	System.out.println("Enter Companyid (num) - ");
                		int Company_id=sc.nextInt();
                    	Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from company where Company_id='"+Company_id+"' ");
                        while(rs.next())
                        {
                                System.out.println("\n"+rs.getString(1)+"\n"+rs.getString(2)+"\n"+rs.getString(3)+"\n"+rs.getString(4)+"\n"+rs.getString(5)+"\n"+rs.getString(6)+"\n"+rs.getString(7));
                        }
                }catch(Exception e){
                        e.printStackTrace();
                }
        }
        
        public static void addPlacementOffer()
        {
                try
                {		
                		System.out.println("Enter Company_id (num) - ");
                		int Company_id=sc.nextInt();
                        System.out.println("Enter Student_Login_id (num) - ");
                        int Student_Login_id=sc.nextInt();
                       	PreparedStatement preparedStatement=con.prepareStatement("insert into student_company values('"+Student_Login_id+"','"+Company_id+"')");
                       	if (preparedStatement.execute())
                        {
                       		System.out.println("\n\n  detials successfully updated \n");
                        }
                                
                }catch(Exception e){
                        e.printStackTrace();
                }
        }
        
        public static void Login() {
        	try
            {		
        			getConnection();
        			System.out.println("Enter Admin ID - ");
            		String Admin_id=sc.next();
            		System.out.println("Enter Admin Password - ");
            		String Admin_Password=sc.next();
                    if(Admin_id.equals("admin") && Admin_Password.equals("admin")) {
                    		System.out.println("\n\n\n 1) View Comapany Details \n 2) Enter Company Details \n 3) Assign Placement Offer");
                        	int ch=sc.nextInt();
                            switch(ch)
                            {
                                case(1):viewCompanyDetails();
                                		break;
                                case(2):enterCompanyDetails();
                                		break;
                                case(3):addPlacementOffer();
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
