package myproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sesone")

public class Sessionhttp extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String password=req.getParameter("pwd");
		if(!email.isBlank()&&!password.isBlank()) {
			
			HttpSession session=req.getSession();
			session.setAttribute("email", email);
			req.getRequestDispatcher("sestwo").include(req, resp);
			
		}
		else {
			resp.getWriter().print("login failed");
		}
	}

}
