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
import com.dao.PassengerDaoImpl;
import com.pojos.passengers;

/**
 * Servlet implementation class passengerGatewayPage
 */
@WebServlet("/gateway")
public class passengerGatewayPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		try(PrintWriter pw = response.getWriter()){
			String passengerName = request.getParameter("name");
			String email = request.getParameter("email");
			String phoneNumber = request.getParameter("phone");
			
			passengers psngr  = new passengers(passengerName, email, phoneNumber);
			session.setAttribute("passenger_details", psngr);
			response.sendRedirect("payment.html");
			
//			IPassengersDao passengersDao = new PassengerDaoImpl();
//			int passengerId = passengersDao.addPassenger(passengerName, email, phoneNumber);
//			// Set passenger details and ID in session if insertion was successful
//			System.out.println(passengerId);
//			if (passengerId > 0) {
//				passengers psg = new passengers(passengerId, passengerName, email, phoneNumber);
//				session.setAttribute("passengers_details", psg);
//				session.setAttribute("passenger_id", passengerId);
//				response.sendRedirect("payment.html");
//			} else {
//				pw.print("<h4>Failed to add passenger. Please try again.</h4>");
//			}
			
		}
	}

	

}
