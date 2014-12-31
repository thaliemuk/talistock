package com.myorg.javacourse;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class StockDetailsServlet  extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// all stocks has the same date, so i will create it only once
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 10, 15, 0, 0);
		Date stocksDate = cal.getTime();
		
		//initialize 3 instances of stock
		Stock PIH = new Stock("PHI",(float)13.1,(float)12.4,stocksDate);
		Stock AAL = new Stock("AAL",(float)5.78,(float)5.5,stocksDate);
		Stock CAAS = new Stock("CAAS",(float)32.2,(float)31.5,stocksDate);
		
		//get the stocks strings		
		String PIHDescription = PIH.getHtmlDescription();
		String AALDescription = AAL.getHtmlDescription();
		String CAASDescription = CAAS.getHtmlDescription();
			
		//print stocks to screen
		resp.setContentType("text/html");
		resp.getWriter().println(PIHDescription +"<br>"+AALDescription + "<br>" + CAASDescription);
	}

}
