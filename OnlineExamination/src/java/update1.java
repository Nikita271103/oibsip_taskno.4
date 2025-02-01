import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class update1 extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
            
        out.println("<html>");
        out.println("<body>");
        
        String s1=request.getParameter("n1");
        String s2=request.getParameter("n2");
        String s3=request.getParameter("n3");
        String s4=request.getParameter("n4");
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con= DriverManager.getConnection("jdbc:mysql:///exam?allowPublicKeyRetrieval=true&useSSL=false","root","root");
       	    Statement st=con.createStatement(); 
            int x=st.executeUpdate("update regis set UNAME='"+s2+"',UPASS='"+s3+"',cn='"+s4+"' where id='"+s1+"'");
        
            if(x!=0)
            {
               response.sendRedirect("update1.html");
            }
            else
            {
               out.println("data not update..");
            }
            con.close();
        }
        catch(Exception e)
        {
           out.println(e);
        }       
        out.println("</body>");
        out.println("</html>");
    }
}
