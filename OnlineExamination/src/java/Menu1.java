import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Menu1 extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        PrintWriter out=response.getWriter();
       HttpSession session= request.getSession();
       String s1=(String)session.getAttribute("u1");
        if(s1!=null)
        {
            out.println("<html>");
            out.println("<head>");
	    out.println("<link rel='stylesheet' href='abc.css'/>");
	    out.println("</head>");
            out.println("<body>");
            out.println("<nav>"); 
            out.println("<div class='logo'><span>O</span>nline<span>E</span>xamination</div>");
	    out.println("<div id='mymenu'>");
            out.println("<ul><li>Home</li><li><a href='insert.html'>Insert</a></li><li><a href='update.html'>update</a></li><li><a href='delete.html'>delete</a></li><li><a href='Logout'>Logout</a></li><li>about</li><li>Contact</li></ul></div>");
            out.println("</nav>");
            out.println("</body>");
            out.println("</html>");
        }
        else
        {
            response.sendRedirect("login.html");
        }
            out.close();
    }
}
