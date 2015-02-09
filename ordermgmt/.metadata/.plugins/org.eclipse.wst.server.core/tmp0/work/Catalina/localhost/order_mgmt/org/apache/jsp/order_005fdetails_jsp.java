package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.o_details.bean.*;

public final class order_005fdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Order Detail Page</title>\r\n");
      out.write("\r\n");
 
	response.setHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.

      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table width=100% align=center border=\"None\">\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>Order Id</th>\r\n");
      out.write("\t\t\t<th>User Id</th>\r\n");
      out.write("\t\t\t<th>Product Id</th>\r\n");
      out.write("\t\t\t<th>Price</th>\r\n");
      out.write("\t\t\t<th>Order Date</th>\r\n");
      out.write("\t\t\t<th>Address</th>\r\n");
      out.write("\t\t\t<th>Order Status</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\r\n");
      out.write("\r\n");

	ArrayList<orderdetails> od = new ArrayList<orderdetails>();  
	od = (ArrayList<orderdetails>)request.getAttribute("details");
	System.out.println("Order : "+ od.size());
	
	 int size = od.size();

	 for(int j = 0; j<size;j++)
	 {
		 System.out.println("price : "+ od.get(j).getPrice() );
		 String ostatus = od.get(j).getOstatus(); 

	 
      out.write("\r\n");
      out.write("\t <form action=\"cancelOrder\" method=\"get\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"orderid\" id=\"orderid\" value= \"");
      out.print(od.get(j).getOrder_id());
      out.write("\" readonly></input></td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(od.get(j).getUser_id());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(od.get(j).getProd_id());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(od.get(j).getPrice());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(od.get(j).getOrder_date());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(od.get(j).getAddress());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(od.get(j).getOstatus());
      out.write("</td>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t");

					if(ostatus.equalsIgnoreCase("Pending"))
					{
				
      out.write("\r\n");
      out.write("\t\t\t\t<td><input type=\"submit\" value=\"cancel\" name=\"cancel\"></input></td>\r\n");
      out.write("\t\t\t\t");
 }
				else { 
      out.write("\r\n");
      out.write("\t\t\t\t<td>");
      out.print(ostatus);
      out.write("</td>\r\n");
      out.write("\t\t\t\t");
 }  
      out.write(" \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t</tr>\t\t\r\n");
      out.write(" \t</form>\r\n");
      out.write(" \r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t \r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("\t<form action=\"logout\" method=\"get\">\r\n");
      out.write("\t<input type=\"submit\" value=\"Logout\" >\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
