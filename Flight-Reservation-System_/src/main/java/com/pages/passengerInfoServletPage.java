package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.IFlightsDao;
import com.dao.IPassengersDao;
import com.pojos.flights;
import com.pojos.users;


@WebServlet("/passengerDetails")
public class passengerInfoServletPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println(request.getParameter("fid"));
		String airlineId = request.getParameter("fid");
		
		HttpSession session = request.getSession();
		try(PrintWriter pw = response.getWriter()){
			session.setAttribute("airlineId", airlineId);
			IFlightsDao flightsdao = (IFlightsDao)session.getAttribute("flightsdao");
			IPassengersDao passengerdao = (IPassengersDao)session.getAttribute("passengerdao");
			flights flightDetails = flightsdao.getFlightDetails(Integer.parseInt(airlineId));
			System.out.println(airlineId);
	
			
//			System.out.println(airlineId);
			users userDetails = (users)session.getAttribute("user_info");
			
				pw.print("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <title>Passenger Details</title>\r\n"
						+ "    <style>\r\n"
						+ "        /* Gradient background styling */\r\n"
						+ "        body {\r\n"
						+ "            display: flex;\r\n"
						+ "            justify-content: center;\r\n"
						+ "            align-items: center;\r\n"
						+ "            height: 100vh;\r\n"
						+ "            margin: 0;\r\n"
						+ "            font-family: 'Times New Roman', Times, serif; /* Font change */\r\n"
						+ "            background: linear-gradient(to right, #005AA7, #FFFDE4); /* Gradient */\r\n"
						+ "            color: #333;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        /* Form container with soft shadows and slight transparency */\r\n"
						+ "        .form-container {\r\n"
						+ "            background: rgba(255, 255, 255, 0.85); /* Semi-transparent background */\r\n"
						+ "            backdrop-filter: blur(10px); /* Blurred backdrop */\r\n"
						+ "            padding: 40px;\r\n"
						+ "            border-radius: 12px;\r\n"
						+ "            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2); /* Softer shadow */\r\n"
						+ "            text-align: center;\r\n"
						+ "            width: 100%;\r\n"
						+ "            max-width: 400px;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        /* Styled header */\r\n"
						+ "        h2 {\r\n"
						+ "            color: #005AA7;\r\n"
						+ "            font-size: 1.8rem;\r\n"
						+ "            margin-bottom: 20px;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        /* Flight details style */\r\n"
						+ "        .flight-details {\r\n"
						+ "            text-align: left;\r\n"
						+ "            margin-bottom: 20px;\r\n"
						+ "            font-size: 1.1rem;\r\n"
						+ "            color: #555;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        .flight-details strong {\r\n"
						+ "            color: #005AA7;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        /* Label and input styling */\r\n"
						+ "        label {\r\n"
						+ "            display: block;\r\n"
						+ "            margin: 10px 0 5px;\r\n"
						+ "            font-weight: bold;\r\n"
						+ "            text-align: left;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        input[type=\"text\"], input[type=\"email\"] {\r\n"
						+ "            width: 100%;\r\n"
						+ "            padding: 10px;\r\n"
						+ "            margin: 5px 0 20px;\r\n"
						+ "            border: 1px solid #ddd;\r\n"
						+ "            border-radius: 4px;\r\n"
						+ "            font-size: 1rem;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        /* Submit button styling */\r\n"
						+ "        input[type=\"submit\"] {\r\n"
						+ "            background: linear-gradient(135deg, #005AA7, #00C6FF); /* Blue gradient */\r\n"
						+ "            color: #fff;\r\n"
						+ "            border: none;\r\n"
						+ "            padding: 12px 20px;\r\n"
						+ "            border-radius: 8px;\r\n"
						+ "            cursor: pointer;\r\n"
						+ "            font-size: 1.1rem;\r\n"
						+ "            font-weight: bold;\r\n"
						+ "            transition: all 0.3s ease;\r\n"
						+ "            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        /* Hover effect for submit button */\r\n"
						+ "        input[type=\"submit\"]:hover {\r\n"
						+ "            background: linear-gradient(135deg, #004080, #0099FF);\r\n"
						+ "            box-shadow: 0px 6px 15px rgba(0, 0, 0, 0.4);\r\n"
						+ "        }\r\n"
						+ "    </style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <div class=\"form-container\">\r\n"
					    + "			<h2>Hello,"+userDetails.getFirstName()+" "+userDetails.getLastName()+"</h2>\r\n"
						+ "        <div class=\"flight-details\">\r\n"
						+ "            <p><strong>Flight Number:</strong>"+flightDetails.getAirlineNumber()+" </p>\r\n"
						+ "            <p><strong>Airline:</strong>"+flightDetails.getAirlineName()+"</p>\r\n"
						+ "            <p><strong>Departure City:</strong>"+flightDetails.getDepartureCity()+"</p>\r\n"
						+ "            <p><strong>Arrival City:</strong>"+flightDetails.getArrrivalCity()+"</p>\r\n"
						+ "            <p><strong>Departure Date:</strong>"+flightDetails.getDepartureDate()+"</p>\r\n"
						+ "        </div>\r\n"
						+ "\r\n"
						+ ""
						+ "        <h2>Passenger Details</h2>\n"
						+ "        <form action=\"gateway\" method=\"post\">\n"
						+ "            <label for=\"name\">Enter Name</label>\n"
						+ "            <input type=\"text\" id=\"name\" name=\"name\" required />\n"
						+ "\n"
						+ "            <label for=\"email\">Enter Email</label>\n"
						+ "            <input type=\"email\" id=\"email\" name=\"email\" required />\n"
						+ "\n"
						+ "            <label for=\"phone\">Enter Phone</label>\n"
						+ "            <input type=\"text\" id=\"phone\" name=\"phone\" required />\n"
						+ "\n"
						+ "            <input type=\"submit\" value=\"Proceed to Checkout\" />\n"
						+ "        </form>\n"
						+ "    </div>\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "");
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
}

