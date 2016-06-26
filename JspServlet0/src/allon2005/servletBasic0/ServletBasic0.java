package allon2005.servletBasic0;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletBasic1
 */
@WebServlet(description = "servlet basic0", urlPatterns = { "/ServletBasic1" }) // this class is annotated as "WebServlet" automatically. The "urlPatterns" is created during the class creation.
                                                              // so, if the url request is: localHost:8080/JspServlet0/ServletBasic1, this class (servlet) will be called.
public class ServletBasic0 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("this is doGet(..) from ServletBasic1");  //this will print the content to the console, not to the webpage (http://localhost:8080/JspServlet0/ServletBasic1 will be blank)
		response.getWriter().println("hello from JspServlet0 doGet(..)"); // using response.getWriter is to add the info to the response, which will be published to the webpage
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}*/

}

/*1. doGet(...) and doPost(..) take two parameters: request and response. We can extract info from request and put requested content to response, and then send 
 * back to the client
 * 
 * 2. url segment mapping: 
 *  2.1: localHost:8080: get the tomcat instance start
 *  2.2: localHost:8080/JspServlet0: tomcat access the project root. If there is a default file (defined in web.xml) existing for this web application, will return that default file
 *  2.3: localHost:8080/JspServlet0/ServletBasic1: this url maps to a specific servlet inside the JspServlet web application. Insdie the servlet, the url pattern defines the access. Tomcat will call this servlet and send the response hjcontent from
 *       this servlet to the client. 
 * 
 */
