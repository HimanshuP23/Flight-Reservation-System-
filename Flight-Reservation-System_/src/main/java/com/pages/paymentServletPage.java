package com.pages;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojos.cards;

/**
 * Servlet implementation class paymentServletPage
 */
@WebServlet("/payment")
public class paymentServletPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String cardno = request.getParameter("card-number");
		String name = request.getParameter("name");
		String expiry = request.getParameter("exp-date");
		String cvv = request.getParameter("cvv");
		
		cards card = new cards(cardno, name, Date.valueOf(expiry), Integer.parseInt(cvv));
		session.setAttribute("card_details", card);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		response.sendRedirect("reservationPage");
	}

}
