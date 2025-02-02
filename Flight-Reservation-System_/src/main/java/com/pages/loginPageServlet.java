package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.utils.DbUtils.*;

import com.dao.IFlightsDao;
import com.dao.IPassengersDao;
import com.dao.IReservationDao;
import com.dao.IUsserDao;
import com.dao.PassengerDaoImpl;
import com.dao.ReservationDaoImpl;
import com.dao.UserDaoImpl;
import com.dao.flightsDaoImpl;
import com.pojos.flights;
import com.pojos.users;

@WebServlet("/login")
public class loginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUsserDao userdao;
	IFlightsDao flightsdao;
	IPassengersDao passengerdao;
	IReservationDao reservationdao;
	users user;

	// INIT
	public void init(ServletConfig config) throws ServletException {
		try {
			openConnection();
			userdao = new UserDaoImpl();
			flightsdao = new flightsDaoImpl();
			passengerdao = new PassengerDaoImpl();
			reservationdao = new ReservationDaoImpl();

			
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException("error in do-post" + getClass(), e);
		}
	}

	// DO-POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter()){
			
			String email = request.getParameter("email");
			System.out.println(email);
			String pass = request.getParameter("password");
			System.out.println(pass);
			
			user = userdao.login(email, pass);
			System.out.println(user);
			if(user==null) {
				pw.print("<h2>Invalid Email or Password. <a href = 'login.html'>Retry</a></h2>");
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("user_info", user);
				if(flightsdao == null)
					System.out.println("null");
				
				session.setAttribute("flightsdao", flightsdao);
				session.setAttribute("userdao", userdao);
				session.setAttribute("passengerdao", passengerdao);
				session.setAttribute("reservationdao", reservationdao);
				
				// adding doa's under scope
				users userDetails = (users)session.getAttribute("user_info");
				System.out.println("loged In successfully");
//				response.sendRedirect("flightSearch.html");
				pw.print("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <title>Flight Search</title>\r\n"
						+ "    <style>\r\n"
						+ "        /* Gradient background styling */\r\n"
						+ "        body {\r\n"
						+ "            display: flex;\r\n"
						+ "            justify-content: center;\r\n"
						+ "            align-items: center;\r\n"
						+ "            height: 100vh;\r\n"
						+ "            margin: 0;\r\n"
						+ "            font-family: 'Times New Roman', Times, serif;\r\n"
						+ "            background: linear-gradient(to right, #005AA7, #FFFDE4); /* Blue to light yellow gradient */\r\n"
						+ "            color: #333;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        /* Form container styling */\r\n"
						+ "        .form-container {\r\n"
						+ "            background: rgba(255, 255, 255, 0.85);\r\n"
						+ "            backdrop-filter: blur(10px);\r\n"
						+ "            padding: 40px;\r\n"
						+ "            border-radius: 12px;\r\n"
						+ "            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);\r\n"
						+ "            width: 100%;\r\n"
						+ "            max-width: 400px;\r\n"
						+ "            text-align: center;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        /* Header styling with gradient */\r\n"
						+ "        h1 {\r\n"
						+ "            background: linear-gradient(to right, #005AA7, #00C6FF);\r\n"
						+ "            -webkit-background-clip: text;\r\n"
						+ "            -webkit-text-fill-color: transparent;\r\n"
						+ "            font-size: 2rem;\r\n"
						+ "            margin-bottom: 20px;\r\n"
						+ "        }\r\n"
						+ "        \r\n"
						+ "        h2 {\r\n"
						+ "            color: #005AA7;\r\n"
						+ "            font-size: 1.5rem;\r\n"
						+ "            margin-bottom: 20px;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        /* Table and input fields styling */\r\n"
						+ "        table {\r\n"
						+ "            width: 100%;\r\n"
						+ "        }\r\n"
						+ "        \r\n"
						+ "        td {\r\n"
						+ "            padding: 8px;\r\n"
						+ "            text-align: left;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        input[type=\"text\"], input[type=\"date\"] {\r\n"
						+ "            width: 100%;\r\n"
						+ "            padding: 8px;\r\n"
						+ "            margin: 4px 0;\r\n"
						+ "            border: 1px solid #ccc;\r\n"
						+ "            border-radius: 4px;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        /* Submit button styling */\r\n"
						+ "        input[type=\"submit\"] {\r\n"
						+ "            width: 100%;\r\n"
						+ "            background: linear-gradient(135deg, #005AA7, #00C6FF);\r\n"
						+ "            color: #fff;\r\n"
						+ "            padding: 10px;\r\n"
						+ "            border: none;\r\n"
						+ "            border-radius: 4px;\r\n"
						+ "            cursor: pointer;\r\n"
						+ "            font-size: 16px;\r\n"
						+ "            font-weight: bold;\r\n"
						+ "            transition: all 0.3s ease;\r\n"
						+ "            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        /* Button hover effect */\r\n"
						+ "        input[type=\"submit\"]:hover {\r\n"
						+ "            background: linear-gradient(135deg, #004080, #0099FF);\r\n"
						+ "            box-shadow: 0px 6px 15px rgba(0, 0, 0, 0.4);\r\n"
						+ "            transform: translateY(-2px);\r\n"
						+ "        }\r\n"
						+ "    </style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <div class=\"form-container\">\r\n"
						+ "        <h1>Flight Search Form</h1>\r\n"
						+ "        <h2>Hello,"+user.getFirstName()+" "+user.getLastName()+"</h2>\r\n"
						+ "        <form action=\"flightSearch\" method=\"post\">\r\n"
						+ "            <table>\r\n"
						+ "                <tr>\r\n"
						+ "                    <td><label for=\"deptcity\">Departure City:</label></td>\r\n"
						+ "                    <td><input type=\"text\" id=\"deptcity\" name=\"deptcity\" placeholder=\"Enter departure city\" required /></td>\r\n"
						+ "                </tr>\r\n"
						+ "                <tr>\r\n"
						+ "                    <td><label for=\"destcity\">Destination City:</label></td>\r\n"
						+ "                    <td><input type=\"text\" id=\"destcity\" name=\"destcity\" placeholder=\"Enter destination city\" required /></td>\r\n"
						+ "                </tr>\r\n"
						+ "                <tr>\r\n"
						+ "                    <td><label for=\"departuredate\">Departure Date:</label></td>\r\n"
						+ "                    <td><input type=\"date\" id=\"departuredate\" name=\"departuredate\" required /></td>\r\n"
						+ "                </tr>\r\n"
						+ "                <tr>\r\n"
						+ "                    <td colspan=\"2\"><input type=\"submit\" value=\"Search Flights\" /></td>\r\n"
						+ "                </tr>\r\n"
						+ "            </table>\r\n"
						+ "        </form>\r\n"
						+ "    </div>\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "");
			}
	
		}catch (Exception e) {
			// TODO: handle exception
			throw new ServletException("err in do-post"+getClass(),e);
		}
	}

}
