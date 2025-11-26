package Lab2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

import java.io.PrintWriter;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if ("logout".equals(action)) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			response.sendRedirect("SessionServlet");
			return;
		}
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			out.println("<html><head><title>Welcome</title></head><body>");
			out.println("<h2>Welcome, " + session.getAttribute("username") + "!</h2>");
			out.println("<p><a href='SessionServlet?action=logout</a></p>");
			out.println("<h3>Session Information:</h3>");
			out.println("<p>Session ID: " + session.getId() + "</p>");
			out.println("<p>Creation Time: " + new Date(session.getCreationTime()) + "</p>");
			out.println("<p>Last Accessed Time: " + new Date(session.getLastAccessedTime()) + "</p>");
			out.println("</body></html>");
		}
		else {
			out.println("<html><head><title>Login</title></head><body>");
			out.println("<h2>Login</h2>");
			out.println("<form method='post' action='SessionServlet'>");
			out.println("Name: <input type='text' name='name'><br><br>");
			out.println("Password: <input type='password' name='password'><br><br>");
			out.println("<input type='submit' value='Submit'>");
			out.println("</form>");
			out.println("</body></html>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
