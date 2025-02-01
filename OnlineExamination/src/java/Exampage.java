import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Exampage extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel='stylesheet' href='abcc.css'/>");
        out.println("<script>");
        out.println("var timeLeft = 60; // 5 minutes");
        out.println("function countdown() {");
        out.println("  var timer = document.getElementById('timer');");
        out.println("  var minutes = Math.floor(timeLeft / 60);");
        out.println("  var seconds = timeLeft % 60;");
        out.println("  if (seconds < 10) seconds = '0' + seconds;");
        out.println("  timer.innerHTML = minutes + ':' + seconds;");
        out.println("  if (timeLeft <= 0) {");
        out.println("    document.getElementById('examForm').submit();");
        out.println("  } else {");
        out.println("    timeLeft--;");
        out.println("    setTimeout(countdown, 1000);");
        out.println("  }");
        out.println("}");
        out.println("window.onload = countdown;");
        out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<nav>");
        out.println("<div class='logo'><span>O</span>nline<span>E</span>xamination</div>");
        out.println("<div id='timer' style='font-size: 20px; font-weight: bold; color: red;'></div>");
        out.println("</nav>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///exam?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from questions");

            out.println("<form id='examForm' method='post' action='Exampage'>");
            while (rs.next()) {
                String id = rs.getString(1);
                String question = rs.getString(2);
                String option1 = rs.getString(3);
                String option2 = rs.getString(4);
                String option3 = rs.getString(5);
                String option4 = rs.getString(6);

                out.println("<div>");
                out.println("<p><b>" + id + ". " + question + "</b></p>");
                out.println("<input type='radio' name='r" + id + "' value='" + option1 + "'> " + option1 + "<br>");
                out.println("<input type='radio' name='r" + id + "' value='" + option2 + "'> " + option2 + "<br>");
                out.println("<input type='radio' name='r" + id + "' value='" + option3 + "'> " + option3 + "<br>");
                out.println("<input type='radio' name='r" + id + "' value='" + option4 + "'> " + option4 + "<br>");
                out.println("</div><hr>");
            }
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
            con.close();
        } catch (Exception e1) {
            out.println(e1);
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        int score = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///exam?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from questions");

            while (rs.next()) {
                String id = rs.getString(1);
                String selectedAnswer = request.getParameter("r" + id);
                if (selectedAnswer != null && selectedAnswer.equals(rs.getString(7))) {
                    score++;
                }
            }

            out.println("<html>");
            out.println("<body>");
            out.println("<h1>Your Score: " + score + "</h1>");
            out.println("</body>");
            out.println("</html>");
            con.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
        out.close();
    }
}
