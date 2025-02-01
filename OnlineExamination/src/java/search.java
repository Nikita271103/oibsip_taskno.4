import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class search extends HttpServlet
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
	    out.println("<ul><li>Home</li><li><a href='insert.html'>Insert</a></li><a href='show.html'>ShowAll</a></li><a href='search.html'>Search</a></li><a href='update.html'>Update</a></li><a href='delete.html'>Delete</a></li><a href='login.html'>LogOut</a></li><li>About</li><li>Contect</li></ul></div>");
	    String s1=request.getParameter("u1");
	     try
           {
                Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql:///exam?allowPublicKeyRetrieval=true&useSSL=false","root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from C where id='"+s1+"'");
		if(rs.next())
		{
		     out.println("<form action='update'>");
                    out.println("<table cellpadding='12'>");
               
		    out.println("<tr>");
		    out.println("<th>id</th>");
		    out.println("<th><input type='text' value='"+rs.getString(1)+"' name='n1'></th>");
		    out.println("</tr>");
				
		    out.println("<tr>");
		    out.println("<th>question</th>");
		    out.println("<th><input type='text' value='"+rs.getString(2)+"' name='n2'></th>");
	            out.println("</tr>");
				
		    out.println("<tr>");
		    out.println("<th>option_a</th>");
		    out.println("<th><input type='text' value='"+rs.getString(3)+"' name='n3'></th>");
		    out.println("</tr>");
				
		    out.println("<tr>");
		    out.println("<th>option_b</th>");
	            out.println("<th><input type='text' value='"+rs.getString(4)+"' name='n4'></th>");
		    out.println("</tr>");
				
		    out.println("<tr>");
	            out.println("<th>option_c</th>");
		    out.println("<th><input type='text' value='"+rs.getString(5)+"' name='n5'></th>");
		    out.println("</tr>");
                    
                    out.println("<tr>");
	            out.println("<th>option_d</th>");
		    out.println("<th><input type='text' value='"+rs.getString(6)+"' name='n6'></th>");
		    out.println("</tr>");
                    
                    out.println("<tr>");
	            out.println("<th>correct_option</th>");
		    out.println("<th><input type='text' value='"+rs.getString(7)+"' name='n7'></th>");
		    out.println("</tr>");
                    
                    out.println("<tr>");
                    out.println("<th colspan='2'><input type='submit' class='B' value='update!!'></th>");
                    out.println("</tr>");
         
                    out.println("</table>");
                    out.println("</form>");
		}
		else
		{
		    out.println("invalid rno.");
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