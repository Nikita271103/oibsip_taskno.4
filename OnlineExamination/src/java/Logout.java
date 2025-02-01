import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Logout extends HttpServlet {

     public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {    
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        session.invalidate();
        response.sendRedirect("login.html");
          
    }
}
