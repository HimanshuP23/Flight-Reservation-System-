package com.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.utils.DbUtils.*;
import com.dao.IUsserDao;
import com.dao.UserDaoImpl;


@WebServlet("/SignUp")
public class signUpServletPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUsserDao userdao;
	
	public void init(ServletConfig config) throws ServletException {
		// we will be call the openConnection method inside init method
		try{
			openConnection();
			userdao = new UserDaoImpl();
			
		}catch (Exception e) {
			// TODO: handle exception
			throw new ServletException("Error inside init"+getClass(),e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setting the content type to text html 
		response.setContentType("text/html");
		// create the instance of printwritter
		try(PrintWriter pw = response.getWriter()){
			String fname = request.getParameter("fn");
			String lname = request.getParameter("ln");
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			Date dob = Date.valueOf(request.getParameter("dob"));
			String res = userdao.signUp(fname, lname, email, password, dob);
			if(res.equals("success")) {
				pw.print("<div style='text-align: center; margin-top: 20px; font-family: Times New Roman, Times, serif;'>"
				           + "    <h3 style='color: #005AA7; font-size: 2rem; background: linear-gradient(to right, #005AA7, #00C6FF); -webkit-background-clip: text; -webkit-text-fill-color: transparent;'>User registered successfully!</h3>"
				           + "    <h4 style='font-size: 1.2rem; margin-top: 15px;'>"
				           + "        <a href='login.html' style='color: #fff; background: linear-gradient(135deg, #005AA7, #00C6FF); text-decoration: none; padding: 12px 20px; border-radius: 8px; transition: background-color 0.3s ease; box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3); display: inline-block;'>"
				           + "            Sign In"
				           + "        </a>"
				           + "    </h4>"
				           + "</div>");


			}
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		
	}

}
