package authpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class order
 */
public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	System.out.println("hello order here!");
	
	int qnty = Integer.parseInt(request.getParameter("qnty"));
	String cardnumber = request.getParameter("cardnumber");
	String address = request.getParameter("address");
	String prodid = request.getParameter("id");
	float price = (Float.valueOf(request.getParameter("price"))).floatValue();
	String desc = request.getParameter("desc");
	int user_id = Integer.parseInt(request.getParameter("user_id"));
	
	java.util.Date date = new java.util.Date();
	java.sql.Date sdate = new java.sql.Date(date.getTime());
	
	String DB_URL = "jdbc:mysql://localhost:3306/shop";
	//to get details on browser
	PrintWriter out = response.getWriter();
	
	Connection conn = null;
	   //Statement stmt = null;
	PreparedStatement pst = null;
	PreparedStatement up_pst = null;

	   try {
		   System.out.println("u r in database");
		Class.forName("com.mysql.jdbc.Driver");
	

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      
			conn = DriverManager.getConnection(DB_URL,"root","tiny");
			
			//STEP 4: Execute a query
			if(conn != null)
			{
		      System.out.println("Creating statement...");
			}
		     
				//stmt = conn.createStatement();25
			String stmt = "INSERT INTO `order`(order_id,user_id,prod_id,quantity,price,order_date,address,ostatus) VALUES (?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(stmt);
			pst.setInt(1,0);
			pst.setInt(2, user_id);
			pst.setString(3, prodid);
			pst.setInt(4, qnty);
			pst.setFloat(5, price*qnty);
			pst.setDate(6, sdate);
			pst.setString(7, address);
			pst.setString(8, "Pending");
			//pst.setString(9, desc);
			
			System.out.println(pst);
			//to execute insert query
			int update = pst.executeUpdate();
			out.println("Order Placed !! Whoohoo !!");
			int o_detail = 0;
			
			if(update == 1)
			{
				String upstmt = "UPDATE product SET qty=qty - "+qnty+" WHERE prod_id = '"+prodid+"'";
				up_pst = conn.prepareStatement(upstmt);
				o_detail = up_pst.executeUpdate();
				System.out.println(o_detail);
				System.out.println("Product quantity updated successfully");
			}
			
			if(update == 1 && o_detail == 1)
			{
				response.sendRedirect("odetail?user_id="+user_id);
			}
	   }
	   catch(Exception e){
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		  }
	   
	   finally
	   {
		   try {
			pst.close();
			up_pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
