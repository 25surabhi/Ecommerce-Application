package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class buy_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Buy Here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form method=\"get\" action=\"order\">\r\n");
      out.write("\t\t<table align=\"center\">\r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<td>Description:</td> \r\n");
      out.write("\t\t\t\t<td><input type=\"text\" value=\"");
      out.print(request.getParameter("desc"));
      out.write("\" name=\"desc\"  disabled></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<td>Price:</td> \r\n");
      out.write("\t\t\t\t<td><input type=\"text\" value=");
      out.print(request.getParameter("price"));
      out.write(" name=\"price\" disabled></input></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<td>Quantity to Buy:</td> \r\n");
      out.write("\t\t\t\t<td><select name=\"qnty\" id=\"qnty\" value=\"\">\r\n");
      out.write("\t\t\t\t\t");
 
						int qnty = Integer.parseInt(request.getParameter("qty"));
						for(int i = 0;i<qnty;i++)
						{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option>");
      out.print( i+1 );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<td>Card Number:</td> \r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"cardnumber\" id=\"cardnumber\"></input></td> \r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<td>Name (as in card):</td> \r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"namecard\" id=\"namecard\"></input></td> \r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<td>Shipping Address:</td> \r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"address\" id=\"address\"></input></td> \r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" value=");
      out.print(request.getParameter("prodid"));
      out.write(" name=\"id\"></input>\r\n");
      out.write("\t\t<input type=\"hidden\" value=");
      out.print(request.getParameter("price"));
      out.write(" name=\"price\"></input>\r\n");
      out.write("\t\t<input type=\"hidden\" value=");
      out.print(request.getParameter("user_id"));
      out.write(" name=\"user_id\"></input>\r\n");
      out.write("\r\n");
      out.write("\t\t<div style=\"text-align:center\">\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Check Out\">\r\n");
      out.write("\t\t</div>\r\n");
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
