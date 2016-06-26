package allon2005.servletBasic2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class servletBasic2
 * 
 * focus on session and context
 */
@WebServlet(description = "servletBasic2, doGet(..) and session", urlPatterns = { "/servletBasic2" })
public class servletBasic2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");

		HttpSession session = request.getSession();  //this is to get the session from the request. !!! only request can getSession(). response has no such method. ==>reason: request start a session
		if(userName != null && !userName.equals(""))  // if we do NOT check the null, the session will NOT work!!!!!
		{
			session.setAttribute("userName_session", userName);
		}
		writer.println("The parameter from the doGet(..) is: " + userName);
		writer.println("<br>");
		writer.println("The saved session parameter from doGet(..) is: " + (String)session.getAttribute("userName_session"));
		
		//*********** ServletContext : will allow the data to be saved and available across user and session
		
		ServletContext context = request.getServletContext();  //
		
		writer.println("<br>");
		if(userName != null && !userName.equals(""))  // The same as the session, if we do NOT check the null, the context will NOT work!!!!!
		{
			context.setAttribute("userName_context", userName);
		}
		
		writer.println("The saved context parameter from doGet(..) is: " + (String)context.getAttribute("userName_context"));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
*/
}

/*session/context will make the stateless http stateful. However, this will also increase the risk since the information saved in the session is kept until the session is destroyed.
 * 
 * 
 */
