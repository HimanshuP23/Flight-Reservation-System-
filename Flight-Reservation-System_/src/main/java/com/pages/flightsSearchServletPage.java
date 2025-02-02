package com.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.IFlightsDao;
import com.pojos.flights;

/**
 * Servlet implementation class flightsSearchServletPage
 */
@WebServlet("/flightSearch")
public class flightsSearchServletPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// firstly set the content type 
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter()){
			HttpSession session = request.getSession();
			IFlightsDao flightdao = (IFlightsDao)session.getAttribute("flightsdao");
			String from = request.getParameter("deptcity");
			String to = request.getParameter("destcity");
			Date deptdate = Date.valueOf(request.getParameter("departuredate"));
			
			if(flightdao != null) {
				List<flights> flightsList = new ArrayList<>(flightdao.searchFlights(from, to, deptdate));
				pw.print("<style>");
				pw.print("body { font-family: 'Times New Roman', Times, serif; background: linear-gradient(to right, #005AA7, #FFFDE4); color: #333; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
				pw.print("table { width: 80%; max-width: 1000px; margin: 20px auto; border-collapse: collapse; background: rgba(255, 255, 255, 0.85); border-radius: 12px; box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2); overflow: hidden; }");
				pw.print("th, td { padding: 12px 15px; text-align: left; border-bottom: 1px solid #ddd; font-family: 'Times New Roman', Times, serif; }");
				pw.print("th { background: linear-gradient(to right, #005AA7, #00C6FF); color: #fff; text-align: center; font-weight: bold; }");
				pw.print("tr:nth-child(even) { background-color: rgba(245, 245, 245, 0.85); }");
				pw.print("tr:hover { background-color: #e9f0ff; }");
				pw.print("h2 { text-align: center; color: #005AA7; font-size: 1.8rem; margin-top: 0; }");
				pw.print("form { display: inline; }");
				pw.print("input[type='submit'] { background: linear-gradient(135deg, #005AA7, #00C6FF); color: #fff; border: none; padding: 8px 12px; border-radius: 8px; cursor: pointer; transition: all 0.3s ease; font-weight: bold; }");
				pw.print("input[type='submit']:hover { background: linear-gradient(135deg, #004080, #0099FF); box-shadow: 0px 6px 15px rgba(0, 0, 0, 0.4); transform: translateY(-2px); }");
				pw.print("</style>");
				if(flightsList == null || flightsList.isEmpty()) {
					pw.print("No flights are available");
				}
				else {
					 pw.print("<table border='0'>\n"
					            + "    <tr>\n"
					            + "        <th>Airline</th>\n"
					            + "        <th>Departure City</th>\n"
					            + "        <th>Arrival City</th>\n"
					            + "        <th>Departure Date</th>\n"
					            + "        <th>Departure Time</th>\n"
					            + "        <th>Price</th>\n"
					            + "        <th>Available Seats</th>\n"
					            + "        <th>Select</th>\n"
					            + "    </tr>\n");
					 for(flights f : flightsList) {
						 pw.print("    <tr>\n"
					                + "        <td>" + f.getAirlineName() + "</td>\n"
					                + "        <td>" + f.getDepartureCity()+ "</td>\n"
					                + "        <td>" + f.getArrrivalCity() + "</td>\n"
					                + "        <td>" + f.getDepartureDate() + "</td>\n"
					                + "        <td>" + f.getDepartureTime() + "</td>\n"
					                + "        <td>" + f.getPrice() + "</td>\n"
					                + "        <td>" + f.getAvailableSeats() + "</td>\n"
					                + "        <td><form method='post' action='passengerDetails'>"
					                + "            <input type='text' hidden name='fid' value='"+ f.getAirlineId()+"'/>"
					                + "            <input type='submit' value='Select'></form></td>\n"
					                + "    </tr>");
						 
					 }
					 pw.print("</table");
					 
				}
			}else {
				pw.print("<h4>Error<h4>");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			throw new ServletException("error in do post"+getClass(),e);
		}
	}

}
