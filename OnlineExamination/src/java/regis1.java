import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class regis1 extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        String s1=request.getParameter("un");	
        String s2=request.getParameter("up");	
	String s3=request.getParameter("uc");	
      
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<body>");
       try
       {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql:///exam?allowPublicKeyRetrieval=true&useSSL=false","root","root");
			Statement st=con.createStatement();
			int x=st.executeUpdate("insert into regis1(UNAME,UPASS,cn) values('"+s1+"','"+s2+"','"+s3+"')");
			if(x!=0)
			{
				response.sendRedirect("login1.html");
			}
			else
			{
				out.println("data not insert...");
			} 
			con.close();
			out.println("<h1>data insert</h1>");
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
