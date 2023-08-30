package Test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		UserBean ub = new UserBean(); // 1000X
		ub.setUname(req.getParameter("s1"));
		ub.setPword(req.getParameter("s2"));
		ub.setFname(req.getParameter("s3"));
		ub.setLname(req.getParameter("s4"));
		ub.setAddr(req.getParameter("s5"));
		ub.setMailId(req.getParameter("s6"));
		ub.setPhno(Long.parseLong(req.getParameter("s7")));
		
		int k = new RegisterDAO().register(ub);
		if(k>0)
		{
			pw.println("<h3>Register Successfull</h3>");
			req.getRequestDispatcher("Login.html").include(req, res);
		}
		else
		{
			pw.println("Something Went Wrong");
			req.getRequestDispatcher("Login.html").include(req, res);
		}
	}

}
