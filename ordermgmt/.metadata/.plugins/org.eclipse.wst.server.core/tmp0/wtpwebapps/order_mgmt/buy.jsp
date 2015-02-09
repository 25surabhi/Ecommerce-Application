<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy Here</title>
</head>
<body>
	<form method="get" action="order">
		<table align="center">
			<tr> 
				<td>Description:</td> 
				<td><input type="text" value="<%=request.getParameter("desc")%>" name="desc"  disabled></td>
			</tr>
			<tr> 
				<td>Price:</td> 
				<td><input type="text" value=<%=request.getParameter("price")%> name="price" disabled></input></td>
			</tr>
			<tr> 
				<td>Quantity to Buy:</td> 
				<td><select name="qnty" id="qnty" value="">
					<% 
						int qnty = Integer.parseInt(request.getParameter("qty"));
						for(int i = 0;i<qnty;i++)
						{
					%>
						<option><%= i+1 %></option>
					<% } %>
				
				</select></td>
			</tr>
			<tr> 
				<td>Card Number:</td> 
				<td><input type="text" name="cardnumber" id="cardnumber"></input></td> 
			</tr>
			<tr> 
				<td>Name (as in card):</td> 
				<td><input type="text" name="namecard" id="namecard"></input></td> 
			</tr>
			<tr> 
				<td>Shipping Address:</td> 
				<td><input type="text" name="address" id="address"></input></td> 
			</tr>
		
		</table>
		
		<input type="hidden" value=<%=request.getParameter("prodid")%> name="id"></input>
		<input type="hidden" value=<%=request.getParameter("price")%> name="price"></input>
		<input type="hidden" value=<%=request.getParameter("user_id")%> name="user_id"></input>

		<div style="text-align:center">
		<input type="submit" value="Check Out">
		</div>
	</form>
</body>
</html>