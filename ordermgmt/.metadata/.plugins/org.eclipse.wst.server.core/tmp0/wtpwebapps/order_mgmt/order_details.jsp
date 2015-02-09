<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Detail Page</title>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<% 
	response.setHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
%>

</head>
<body>

<%@page import="java.util.ArrayList"%>
<%@page import="com.o_details.bean.*"%>

<%
	String username = null;
	Cookie[] cookies = request.getCookies();
	boolean flag=false;
	if(cookies !=null)
	{
			for(Cookie cookie : cookies)
			{
    			if(cookie.getName().equals("user")) 
    			{
    				System.out.println("test "+cookie.getName());
    				username = cookie.getValue();
					System.out.println("test "+username);
					flag= true;
    			}
    		}
	}
	
	if(!(flag)) 
	{
		response.sendRedirect("index.jsp");
	}
%>


<table width=100% align=center border="None">
	<thead>
		<tr>
			<th>Order Id</th>
			<th>User Id</th>
			<th>Product Id</th>
			<th>Price</th>
			<th>Order Date</th>
			<th>Address</th>
			<th>Order Status</th>
		</tr>
	</thead>


<%
	ArrayList<orderdetails> od = new ArrayList<orderdetails>();  
	od = (ArrayList<orderdetails>)request.getAttribute("details");
	System.out.println("Order : "+ od.size());
	
	 int size = od.size();

	 for(int j = 0; j<size;j++)
	 {
		 System.out.println("price : "+ od.get(j).getPrice() );
		 String ostatus = od.get(j).getOstatus(); 

	 %>
	 <form action="cancelOrder" method="get">
		<tr>
				<td><input type="text" name="orderid" id="orderid" value= "<%=od.get(j).getOrder_id()%>" readonly></input></td>
				<td><%=od.get(j).getUser_id()%></td>
				<td><%=od.get(j).getProd_id()%></td>
				<td><%=od.get(j).getPrice()%></td>
				<td><%=od.get(j).getOrder_date()%></td>
				<td><%=od.get(j).getAddress()%></td>
				<td><%=od.get(j).getOstatus()%></td>
	
				<%
					if(ostatus.equalsIgnoreCase("Pending"))
					{
				%>
				<td><input type="submit" value="cancel" name="cancel"></input></td>
				<% }
				else { %>
				<td><%=ostatus%></td>
				<% }  %> 
				
		</tr>		
 	</form>
 
		<%} %>

	 
	</table>

	<form action="logout" method="get">
	<input type="submit" value="Logout" >
	</form>
</body>
</html>