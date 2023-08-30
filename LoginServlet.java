package Test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pword");
		UserBean ub = new LoginDAO().login(uname, pass); // null
		if(ub==null)
		{
			pw.println("<h3>User Not Available, Kindly Register</h3>");
			req.getRequestDispatcher("Register.html").include(req, res);
		}
		else
		{
			pw.println("Hello USer : "+ub.getFname());
			req.getRequestDispatcher("Login.html").include(req, res);
		}
		
	}

}

