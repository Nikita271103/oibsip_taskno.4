import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class insert1 extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
       	String s1=request.getParameter("u1");		
        String s2=request.getParameter("u2");	
        String s3=request.getParameter("u3");
        String s4=request.getParameter("u4");	
        String s5=request.getParameter("u5");
        String s6=request.getParameter("u6");
        String s7=request.getParameter("u7");

		
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<body>");
       try
       {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql:///exam?allowPublicKeyRetrieval=true&useSSL=false","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("insert into HTML (que_text,option_a,option_b,option_c,option_d,correct_option) values('"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')"); 
			   response.sendRedirect("HTML");	
			con.close();
			
        }
		catch(Exception e1)
		{
		    out.println(e1);
		}
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
