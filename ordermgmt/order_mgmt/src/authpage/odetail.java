package authpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.o_details.bean.orderdetails;

/**
 * Servlet implementation class odetail
 */
public class odetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public odetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String DB_URL = "jdbc:mysql://localhost:3306/shop";
		String userid = request.getParameter("user_id");
		
		PrintWriter out = response.getWriter();
		
		
		//declare new object and arraylist for bean class
		ArrayList<orderdetails> od = new ArrayList<orderdetails>();  
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			System.out.println("u r in database");
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, "root", "tiny");
		
			if (conn != null) {
				System.out.println("Creating statement...");
			}

			stmt = conn.createStatement();
			
			//fetching data from order table 
			String sql;
			sql = "SELECT order_id,user_id,prod_id,price,order_date,address,ostatus from `order` where user_id= "+ userid;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			ArrayList<Integer> arrlst = new ArrayList<Integer>();
			int index = 0;
			
			while(rs.next())
			{
				Date order_date = rs.getDate(5);
				Date curr_date = new Date();
			
			
			try{
				//getting date time in milliseconds
				long datediff = curr_date.getTime() - order_date.getTime();
				 System.out.println(datediff);
				 
				 //display date in terms of no. of days 
				 long diffDays = datediff / (24 * 60 * 60 * 1000);
				 System.out.println(diffDays);
				
				 if(diffDays>3)
					{
						System.out.println("inside if");
						arrlst.add(rs.getInt(1));
						index++;
					}
					else
					{
						
					}
					System.out.print(diffDays + " days, ");
					if(arrlst.size()>0)
					{
					System.out.println("id to updated "+arrlst.get(index-1));
					}
				
				 
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println(e);
			}
			}
			
			String update_status;
			
			for(int i=0;i<arrlst.size();i++)
			{
				update_status = "UPDATE `order` SET ostatus = 'Delivered' WHERE order_id = "+arrlst.get(i);
				System.out.println(update_status);
				pstmt = conn.prepareStatement(update_status);
				pstmt.executeUpdate();
			}
			
			String update_q = "SELECT order_id,user_id,prod_id,price,order_date,address,ostatus from `order` where user_id= "+ userid;
			
			System.out.println(update_q);
			ResultSet rs1 = stmt.executeQuery(update_q);
			//System.out.println(sqlSelect);
			
			while (rs1.next()) {
				//System.out.println(rs.getInt(1));
				orderdetails o_detail = new orderdetails();
				o_detail.setOrder_id(rs1.getInt(1));
				o_detail.setUser_id(rs1.getInt(2));
				o_detail.setProd_id(rs1.getString(3));
				o_detail.setPrice(rs1.getFloat(4));
				System.out.println(rs1.getFloat(4));
				o_detail.setOrder_date(rs1.getDate(5));
				o_detail.setAddress(rs1.getString(6));
				o_detail.setOstatus(rs1.getString(7));
				//o_detail.setDesc(rs.getString(8));
				//to add database objects in the arraylist
				od.add(o_detail);
			}
			
			request.setAttribute("details", od);
			
			//to send data from arraylist to view/jsp page
			RequestDispatcher rd = request.getRequestDispatcher("order_details.jsp");
			rd.forward(request, response);
			
		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
