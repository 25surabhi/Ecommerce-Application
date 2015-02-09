package authpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import org.apache.catalina.connector.Response;
import org.bson.types.ObjectId; //import javax.servlet.*;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.sql.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.io.PrintStream;

/**
 * Servlet implementation class userAuth
 */
public class userAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public userAuth() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		//System.out.println("logout page");
		
		String DB_URL = "jdbc:mysql://localhost:3306/shop";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String prodid = request.getParameter("id");
		MessageDigest msgDigest = null;
		String hashValue = null;
		//int len = prodid.length();
		//System.out.println(len);
		/*if (prodid != null) { 
			prodid = request.getParameter("id");
		}*/

		System.out.println(prodid);
		System.out.println(username);
		System.out.println(password);

		// to get details on browser
		PrintWriter out = response.getWriter();

		Connection conn = null;
		Statement stmt = null;
		try {
			System.out.println("u r in database");
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, "root", "tiny");

			// STEP 4: Execute a query
			if (conn != null) {
				System.out.println("Creating statement...");
			}

			stmt = conn.createStatement();

			String sql;
			sql = "SELECT user_id,user_name,password from userauth where user_name= '"
					+ username + "'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			int user_id = 0;
			//int price = 0;
			
			msgDigest = MessageDigest.getInstance("SHA-1");
            msgDigest.update(password.getBytes("UTF-16"));
            byte rawByte[] = msgDigest.digest();
            hashValue = (new BASE64Encoder()).encode(rawByte);
			
			
			
			while (rs.next()) {
				if (rs.getString("password").equalsIgnoreCase(hashValue)) {
					System.out.println("hello user");
					user_id = rs.getInt("user_id");
					
					Cookie loginCookie = new Cookie("user", username);
					loginCookie.setMaxAge(30*60);
					response.addCookie(loginCookie);
					System.out.println(loginCookie);
			
				} else {
					out.println("<font color=red>Either User name or password is wrong.</font>");
					response.sendRedirect("index.jsp");
				}
				
			}

			if (prodid.equals("null")) {
				response.sendRedirect("odetail?user_id="+user_id);
			} else{
				// To connect to mongodb server
				MongoClient mongoClient = new MongoClient("localhost", 27017);
				// Now connect to your databases
				DB db = mongoClient.getDB("shopping");
				System.out.println("Connect to database successfully");
				// boolean auth = db.authenticate(myUserName, myPassword);
				// System.out.println("Authentication: "+auth);
				DBCollection coll = db.getCollection("shop");
				System.out.println("Collection shop selected successfully");

				// DBObject myDoc = coll.findOne();
				// out.println(myDoc);
				BasicDBObject query = new BasicDBObject().append("_id",
						new ObjectId(prodid));
				DBCursor cursor = coll.find(query);

				DateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				// Date date1[] = new Date[5];
				Date start_date = null;
				Date end_date = null;
				System.out.println(dateFormat.format(date));

				DBObject oj = cursor.next();
				end_date = (Date) oj.get("end_date");
				start_date = (Date) oj.get("start_date");
			    float price = (Float.valueOf((String)oj.get("Price"))).floatValue();
				String desc = (String)oj.get("Description");
				System.out.println(desc);
				System.out.println(start_date);
				System.out.println(end_date);
				System.out.println(price);
				/*
				 * int i=0; start_date= (Date)cursor.next().get("start_date");
				 * System.out.println(date1[i]); i++;
				 */

				int comparison = date.compareTo(start_date);
				int comparison1 = date.compareTo(end_date);
				System.out.println("Date " + comparison);
				// System.out.println("Date "+comparison1);

				String qty;
				int qty_cnt = 0;

				// to check the quantity of product
				qty = "SELECT qty from product where prod_id= '" + prodid + "'";
				System.out.println(qty);
				ResultSet rs_qty = stmt.executeQuery(qty);

				rs_qty.next();
				qty_cnt = rs_qty.getInt("qty");

				// to check if date is between the start and end date as well
				// the item is in stock
				if (comparison == 1 && comparison1 == -1 && qty_cnt > 0) 
				{
					response.sendRedirect("buy.jsp?prodid=" + prodid
							+ "&price=" + price + "&user_id=" + user_id + "&desc=" + desc + "&qty=" + qty_cnt);
				} else if(qty_cnt == 0) 
				{
					out.println("This item is OUT OF STOCK");
				} else {
					out.println("This product was available upto "+ end_date +" !! Check back after few days");
				}
			}
			/*else
			{
				response.sendRedirect("order_details.jsp");
			}*/
			
		}

		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
