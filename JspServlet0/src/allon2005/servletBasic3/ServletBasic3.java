package allon2005.servletBasic3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletBasic3
 * 
 * init(), destroy()
 */
@WebServlet(description = "Servlet Basic3, on init", urlPatterns = { "/ServletBasic3" }, initParams={@WebInitParam(name="welcome", value="welcome to Mars!") })  //we can also add initial parameter in the annotation
public class ServletBasic3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String initMessage, destroyMessage;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("this is the initial value from annotation : " + this.getInitParameter("welcome"));
		writer.println(initMessage);
		//destroy(); //normally, the destroy() should not be called by programmer. The system will call it automatically.   !!!!===> but, if I do not call it here, I do NOT get the "destroyMessage". ?????????why
		writer.println(destroyMessage);
	}
	
	//init() is empty in GenericServlet. We can add anything here to execute during servlet initialization.
	//no explicity code to call this method. It will be automatically executed 
	public void init() throws ServletException
	{
		initMessage = "this is an override of init().";
	}
	
	public void destroy()
	{
		destroyMessage = "this is an override of destroy();";
	}

}


/*1. The inheritance tree is:   GenericServlet<===HttpServlet<====Servlet(user created)
 * 1.1 GenericServlet has several methods including:
 *  A:  init()#, init(ServletConfig config),destroy()#
 *  B:  getInitParameter(String name), getInitParameterNames()
 *  C: getServletConfig(),getServletContext(), getServletInfo(), getServletName()
 *  D: service(ServletRequest req, ServletResponse res)   ===>this one is to decide what method to call
 *  
 *  many methods listed above are empty. We can overwrite them if needed.
 *  
 *  1.2 HttpServlet has all doXX() methods such as doGet(), doPost(), doPut(), doDelete()....
 *      service(HttpServletRequest req, HttpServletResponse resp) is the one to decide which method to call dependent on the request method
 *  
 *   
 * 
 * 
 */

