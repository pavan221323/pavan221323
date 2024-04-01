package myproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sestwo")
public class sessionhttp2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		String email=(String) session.getAttribute("email");
		if(email!=null) {
			resp.getWriter().print("welcome to homepage");
		}
		else {
			req.getRequestDispatcher("sessionHttp.html").include(req,resp);

		}
	}

}
