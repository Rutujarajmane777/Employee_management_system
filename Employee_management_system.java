package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Employee_management_system {
	
	Scanner sc=new Scanner(System.in);
	
	public void createtable()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/codenera", "root", "admin@123");
			
			String sql = "create table if not exists project(id int,name varchar(255), address varchar(255),phone varchar(10),salary int, joining_date  varchar(155))";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
	}
	
	public void insert()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/codenera", "root", "admin@123");
			
			System.out.println("Enter your id: ");
			int id=sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Enter your name: ");
			String name=sc.nextLine();
			
			System.out.println("Enter your address: ");
			String address=sc.nextLine();
			
			System.out.println("Enter your phone no: ");
			String phone=sc.nextLine();
			
			System.out.println("Enter your salary: ");
			int salary=sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Enter your joining date: ");
			String date =sc.nextLine();
			
			String sql="insert into project values (?,?,?,?,?,?)";
			
            PreparedStatement ps=con.prepareStatement(sql);
			
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, phone);
			ps.setInt(5, salary);
			ps.setString(6,date);
			
			int stutus=ps.executeUpdate();
			
			if (stutus>0)
			{
				System.out.println("your data has been sucessfully inserted ");
				
			}
			else
			{
				System.out.println("your data has not been sucessfully inserted please try again... ");

			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void fetch()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/codenera", "root", "admin@123");
			
			String sql = " select * from project";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String address=rs.getString("address");
				String phone=rs.getString("phone");
				int salary=rs.getInt("salary");
				String date=rs.getString("joining_date");
				

				System.out.println("ID IS : "+id);
				System.out.println("NAME IS :"+name);
				System.out.println("ADDRESS IS : "+address);
				System.out.println("PHONE IS :"+phone);
				System.out.println(" JOINING DATE IS :"+date);
				System.out.println();
				
				System.out.println();
				
	
			}
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

		
	
	public void update()
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/codenera", "root", "admin@123");
			
			
			String sql = "update project set name=?,address=?, phone=?, salary=?, joining_date=? WHERE id=?";
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter your new name : ");
			String newname=sc.nextLine();
			
			System.out.println("Enter your new address : ");
			String newaddress=sc.nextLine();
			

			System.out.println("Enter your new phone : ");
			String newphone=sc.nextLine();
			
			System.out.println("Enter new salary : ");
			int newsalary=sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Enter your joining date : ");
			String newdate=sc.nextLine();
			
			
			System.out.println("Enter id which you want to update: ");
			int id=sc.nextInt();

			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, newname);
			ps.setString(2,newaddress);
			ps.setString(3,newphone);
			ps.setInt(4, newsalary);
			ps.setString(5,newdate);
			ps.setInt(6, id);
			
			
			
			int st=ps.executeUpdate();
			
			if (st>0)
			{
				System.out.println("data has been updated successfully");
			}
			else
			{
				System.out.println("data has not been updated");
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public void delete()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/codenera", "root", "admin@123");
			
			String sql="delete from project where id=?";
			
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter id which you want to delete : ");
			int id = sc.nextInt();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			
			int status = ps.executeUpdate();

			if (status > 0) {
				System.out.println("Data has been deleted Succesfully");
			} else {
				System.out.println("Data has not been deleted");
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		
	}
	public void search()
	{
	     try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/codenera", "root", "admin@123");
				
	            Scanner sc = new Scanner(System.in);
	            
	            System.out.println("Enter the ID you want to search:");
	            int id = sc.nextInt();

	            String sql = "SELECT * FROM project WHERE id = ?";

	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) 
	            {
	                int id1 = rs.getInt("id");
	                String name = rs.getString("name");
	                String address = rs.getString("address");
	                String phone = rs.getString("phone");
	                int salary = rs.getInt("salary");
	                String date = rs.getString("joining_date");

	               
	                System.out.println();
	                System.out.println("ID IS: " + id1);
	                System.out.println("NAME IS: " + name);
	                System.out.println("ADDRESS IS: " + address);
	                System.out.println("PHONE IS: " + phone);
	                System.out.println("SALARY IS: " + salary);
	                System.out.println("JOINING_DATE IS: " + date);
	                System.out.println();
	            }
	            
	        } 
	     catch (Exception e) 
	     {
	            e.printStackTrace();
	        }
	  }
		
	
	

	public static void main(String[] args) {
		
		
		
		Scanner sc=new Scanner(System.in);
		Employee_management_system ob=new Employee_management_system();
		ob.createtable();
		
		  System.out.println("************Menu************");
		  System.out.println("1.insertion");
		  System.out.println("2.fetch_data");
		  System.out.println("3.Update");
		  System.out.println("4.Delete");
		  System.out.println("5.Search");
		  System.out.println("6.Exit");
		  
		  System.out.println("Enter your choice : ");
		  int choice=sc.nextInt();
		  
		  switch (choice) {
		  
		case 1:
			
			ob.insert();
			break;
        case 2:
			
			ob.fetch();
			break;
		case 3:
				
			ob.update();
			break;
	     case 4:
				
			ob.delete();
			break;
	     case 5:
				
			ob.search();
			break;	
			
		default:
			break;
		}
		  
		 
	}

	

}
