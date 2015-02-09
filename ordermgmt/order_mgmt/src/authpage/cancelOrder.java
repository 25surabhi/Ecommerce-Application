package authpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class cancelOrder
 */
public class cancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancelOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	System.out.println("Hello");
	
	int orderid = Integer.parseInt(request.getParameter("orderid"));
	
	String DB_URL = "jdbc:mysql://localhost:3306/shop";
	//to get details on browser
	PrintWriter out = response.getWriter();
	
	Connection conn = null;
	   //Statement stmt = null;
	Statement stmt = null;
	//PreparedStatement up_pst = null;

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
			stmt = conn.createStatement();
			String sql = "DELETE FROM `order` where order_id= '" + orderid + "'";
			
			
			System.out.println(sql);
			//to execute insert query
			stmt.executeUpdate(sql);
			out.println("Order: "+ orderid + " Deleted");
			//response.sendRedirect("order_details.jsp");
						
			
	   }
	   catch(Exception e){
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		  }
	   
	   finally
	   {
		   try {
			stmt.close();
			//up_pst.close();
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
