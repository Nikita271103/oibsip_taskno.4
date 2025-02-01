import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class showall extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        PrintWriter out=response.getWriter();
        out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='abc.css'/>");
		out.println("</head>");
                out.println("<body>");
                out.println("<nav>"); 
                out.println("<div class='logo'><span>O</span>nline<span>E</span>xamination</div>");
		out.println("<div id='mymenu'>");
		out.println("<ul><li>Home</li><li><a href='login.html'>login</a></li><li><a href='regis.html'>Registration</a></li><li><a href='showall'>showall</a></li><li><a href='update1.html'>update</a></li><li><li>about</li><li>Contact</li></ul></div>");
                out.println("</nav>");
                try
       {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql:///exam?allowPublicKeyRetrieval=true&useSSL=false","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from regis"); 
			out.println("<div id='mydata'>");
                                
			out.println("<table cellpadding='12'>");
			out.println("<tr>");
			out.println("<th>id</th>");
			out.println("<th>Name</th>");
			out.println("<th>Password</th>");
			out.println("<th>cn</th>");
			out.println("</tr>");
			while(rs.next())
			{
			out.println("<tr>");
			out.println("<th>"+rs.getString(1)+"</th>");
			out.println("<th>"+rs.getString(2)+"</th>");
			out.println("<th>"+rs.getString(3)+"</th>");
			out.println("<th>"+rs.getString(4)+"</th>");
			out.println("</tr>");
			
			}
			out.println("</table>");
                        out.println("</div>");
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
