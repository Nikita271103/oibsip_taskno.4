import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class delete1 extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
            
        out.println("<html>");
        out.println("<body>");
        
        String s1=request.getParameter("u1");   
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con= DriverManager.getConnection("jdbc:mysql:///exam?allowPublicKeyRetrieval=true&useSSL=false","root","root");
       	    Statement st=con.createStatement(); 
            st.executeUpdate("delete from HTML where id='"+s1+"'");
            response.sendRedirect("HTML");
  
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
