import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class login1 extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        String s1=request.getParameter("u1");	
        String s2=request.getParameter("u2");	
      
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<body>");
       try
       {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql:///exam?allowPublicKeyRetrieval=true&useSSL=false","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from regis1 where UNAME='"+s1+"'AND UPASS='"+s2+"'");
			if(rs.next())
			{
                            HttpSession session=request.getSession();
                            session.setAttribute("u1",s1);
			    response.sendRedirect("Menu1");
			}
			else
			{
			    out.println("Invalid user name and password");
			}
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