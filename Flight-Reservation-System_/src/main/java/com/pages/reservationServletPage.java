package com.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.IPassengersDao;
import com.dao.IReservationDao;
import com.pojos.cards;
import com.pojos.passengers;
import com.pojos.reservation;
import com.pojos.users;

/**
 * Servlet implementation class reservationServletPage
 */
@WebServlet("/reservationPage")
public class reservationServletPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		System.out.println("_+_+_+_+_+_+_+_+_+_+_+");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();
//			retrieving the passenger form data
			passengers psngr = (passengers) session.getAttribute("passenger_details");
			System.out.println("+NULL+"+psngr);
			
			String name = psngr.getPassengerName();
			System.out.println(name);
			String email = psngr.getEmail();
			System.out.println(email);
			String phone = psngr.getPhone();
			passengers passenger = new passengers(name, email, phone);
//			session.setAttribute("passenger_details", passenger);
			System.out.println(phone);
			
//			retrieving flightid from session
			String fd = (String) session.getAttribute("airlineId");
			System.out.println(fd);
			int fid = Integer.parseInt(fd);
			System.out.println(fid);
			
			//card details adding to database 
			cards card = (cards)session.getAttribute("card_details");
			System.out.println("Card details"+card);
			int paymentid = ((IPassengersDao)session.getAttribute("passengerdao")).makePayment(card);
			System.out.println("pid:"+paymentid);
			
//			adding passenger to passengers table
			int id = ((IPassengersDao)session.getAttribute("passengerdao")).addPassenger(name, email, phone);
			
			//retrieving the user details from session
			users user = (users) session.getAttribute("user_info");
			int uid = user.getUserId();
			System.out.println("psid: "+id+" userid: "+uid);
			
			if(paymentid==0) {
				pw.print("<h3>Payment failed <a href='search.html'>Retry</a></h3>");
			}
//			making reservation storing in reservation table;
			//get reservation/booking id
			int rid = ((IReservationDao)session.getAttribute("reservationdao")).bookFlight(id, fid,paymentid);
			session.setAttribute("rid", rid);
			System.out.println("rid"+rid);
			reservation reserve = ((IReservationDao)session.getAttribute("reservationdao")).bookingDetails(rid);
			session.invalidate();
			//get the booking details to show customer
			if (reserve == null) {
				
				pw.print("<h2>Booking failed</h2>");
			}
			else {
				pw.print("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Flight Ticket</title>\r\n"
						+ "    <style>\r\n"
						+ "        body {\r\n"
						+ "            display: flex;\r\n"
						+ "            justify-content: center;\r\n"
						+ "            align-items: center;\r\n"
						+ "            height: 100vh;\r\n"
						+ "            margin: 0;\r\n"
						+ "            font-family: 'Times New Roman', Times, serif;\r\n"
						+ "            background: linear-gradient(to right, #005AA7, #FFFDE4);\r\n"
						+ "            color: #333;\r\n"
						+ "        }\r\n"
						+ "        .ticket {\r\n"
						+ "            width: 600px;\r\n"
						+ "            background: rgba(255, 255, 255, 0.85);\r\n"
						+ "            padding: 20px;\r\n"
						+ "            border-radius: 15px;\r\n"
						+ "            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);\r\n"
						+ "            display: flex;\r\n"
						+ "            flex-direction: column;\r\n"
						+ "        }\r\n"
						+ "        .ticket-header, .ticket-footer {\r\n"
						+ "            background-color: #005AA7;\r\n"
						+ "            color: white;\r\n"
						+ "            padding: 15px;\r\n"
						+ "            text-align: center;\r\n"
						+ "            font-weight: bold;\r\n"
						+ "        }\r\n"
						+ "        .ticket-body {\r\n"
						+ "            display: flex;\r\n"
						+ "            justify-content: space-between;\r\n"
						+ "            background-color: #f3f4f6;\r\n"
						+ "            padding: 20px;\r\n"
						+ "        }\r\n"
						+ "        .section {\r\n"
						+ "            margin-bottom: 15px;\r\n"
						+ "            font-size: 1.1rem;\r\n"
						+ "        }\r\n"
						+ "        .info {\r\n"
						+ "            color: #555;\r\n"
						+ "            margin-left: 5px;\r\n"
						+ "        }\r\n"
						+ "        .exit-button {\r\n"
						+ "            display: inline-block;\r\n"
						+ "            padding: 12px 20px;\r\n"
						+ "            background: linear-gradient(135deg, #005AA7, #00C6FF);\r\n"
						+ "            color: #fff;\r\n"
						+ "            text-decoration: none;\r\n"
						+ "            border-radius: 8px;\r\n"
						+ "            margin-top: 20px;\r\n"
						+ "            text-align: center;\r\n"
						+ "            font-weight: bold;\r\n"
						+ "            transition: background-color 0.3s ease;\r\n"
						+ "            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);\r\n"
						+ "        }\r\n"
						+ "        .exit-button:hover {\r\n"
						+ "            background: linear-gradient(135deg, #004080, #0099FF);\r\n"
						+ "            box-shadow: 0px 6px 15px rgba(0, 0, 0, 0.4);\r\n"
						+ "        }\r\n"
						+ "        .barcode {\r\n"
						+ "            height: 40px;\r\n"
						+ "            margin-top: 10px;\r\n"
						+ "            display: flex;\r\n"
						+ "            align-items: flex-end;\r\n"
						+ "        }\r\n"
						+ "        .barcode-line {\r\n"
						+ "            display: inline-block;\r\n"
						+ "            width: 4px;\r\n"
						+ "            height: 100%;\r\n"
						+ "            background-color: white;\r\n"
						+ "            margin-right: 2px;\r\n"
						+ "        }\r\n"
						+ "    </style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <div class=\"ticket\">\r\n"
						+ "        <div class=\"ticket-header\">BOARDING PASS -"+reserve.getAirline()+"</div>\r\n"
						+ "        <div class=\"ticket-body\">\r\n"
						+ "            <div class=\"left-section\">\r\n"
						+ "                <div class=\"section\"><strong>Name of Passenger:</strong><span class=\"info\">"+reserve.getName()+"</span></div>\r\n"
						+ "                <div class=\"section\"><strong>Flight:</strong><span class=\"info\">"+reserve.getFlightNo()+"</span></div>\r\n"
						+ "                <div class=\"section\"><strong>Departure:</strong><span class=\"info\">"+reserve.getFrom()+"</span></div>\r\n"
						+ "                <div class=\"section\"><strong>Arrival:</strong><span class=\"info\">"+reserve.getTo()+"</span></div>\r\n"
						+ "                <div class=\"section\"><strong>Gate:</strong><span class=\"info\">K18</span></div>\r\n"
						+ "            </div>\r\n"
						+ "            <div class=\"right-section\">\r\n"
						+ "                <div class=\"section\"><strong>Boarding Time:</strong><span class=\"info\">08:30 AM</span></div>\r\n"
						+ "                <div class=\"section\"><strong>Departure Date:</strong><span class=\"info\">"+reserve.getDepartureDate()+"</span></div>\r\n"
						+ "                <div class=\"section\"><strong>Departure Time:</strong><span class=\"info\">"+reserve.getDepartureTime()+"</span></div>\r\n"
						+ "                <div class=\"section\"><strong>Seat:</strong><span class=\"info\">"+reserve.getSeatNo()+"</span></div>\r\n"
						+ "            </div>\r\n"
						+ "        </div>\r\n"
						+ "        <div class=\"barcode\">\r\n"
						+ "            <div class=\"barcode-line\"></div>\r\n"
						+ "            <div class=\"barcode-line\"></div>\r\n"
						+ "            <div class=\"barcode-line\"></div>\r\n"
						+ "            <div class=\"barcode-line\"></div>\r\n"
						+ "            <div class=\"barcode-line\"></div>\r\n"
						+ "        </div>\r\n"
						+ "        <div class=\"ticket-footer\">SAFE JOURNEY</div>\r\n"
						+ "    </div>\r\n"
						+ "    <a href=\"register.html\" class=\"exit-button\">Exit</a>\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "");
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
}
