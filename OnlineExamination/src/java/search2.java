import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class search2 extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
            PrintWriter out=response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<link rel='stylesheet' href='abc.css'/>");
	    out.println("</head>");
	    out.println("<body>");
            out.println("<div id='mymenu'>");
            out.println("<nav>"); 
                out.println("<div class='logo'><span>O</span>nline<span>E</span>xamination</div>");
	    out.println("<ul><li>Home</li><li><a href='login.html'>login</a></li><li><a href='regis.html'>Registration</a></li><li><a href='update1.html'>Update</a></li><li>About</li><li>Contect</li></ul></div>");
	    out.println("</nav>"); 
            String s1=request.getParameter("u1");
	     try
           {
                Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql:///exam?allowPublicKeyRetrieval=true&useSSL=false","root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from regis where id='"+s1+"'");
		if(rs.next())
		{    out.println("<div id='mydata'>");
		     out.println("<form action='update1'>");
                     
                    out.println("<table cellpadding='12'>");
                    
                    out.println("<tr>");
		    out.println("<th>id</th>");
		    out.println("<th><input type='text' value='"+rs.getString(1)+"' name='n1'></th>");
		    out.println("</tr>");
				                   
		    out.println("<tr>");
		    out.println("<th>Enter Name</th>");
		    out.println("<th><input type='text' value='"+rs.getString(2)+"' name='n2'></th>");
		    out.println("</tr>");
				
		    out.println("<tr>");
		    out.println("<th>Enter password</th>");
		    out.println("<th><input type='text' value='"+rs.getString(3)+"' name='n3'></th>");
	            out.println("</tr>");
				
		    out.println("<tr>");
		    out.println("<th>Enter contect no.</th>");
		    out.println("<th><input type='text' value='"+rs.getString(4)+"' name='n4'></th>");
		    out.println("</tr>");

                    out.println("<tr>");
                    out.println("<th colspan='2'><input type='submit' class='B' value='update!!'></th>");
                    out.println("</tr>");
         
                    out.println("</table>");
                    out.println("</form>");
                    out.println("</div>");
		}
		else
		{
		    out.println("invalid id");
		}
		    con.close();
	    }
            catch(Exception e)
		{
		    out.println(e);
		}		
		out.println("</body>");
		out.println("</html>");
		out.close();		
    }
}