package com.algoTrader.javacourse.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algoTrader.javacourse.model.Stock;

public class StockDetailsServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");		
		
		java.util.Date date1 = new java.util.Date();
		java.util.Date date2 = new java.util.Date();
		java.util.Date date3 = new java.util.Date();
		
		Calendar cal = Calendar.getInstance();
		cal.set(3914,11,15);
		date1 = cal.getTime();
		date2 = cal.getTime();
		date3 = cal.getTime();
		Stock stock1 = new Stock("PIH",(float) 13.1,(float) 12.4,date1);
		Stock stock2 = new Stock("AAL",(float)5.78,(float) 5.5,date2);
		Stock stock3 = new Stock("CAAS",(float)32.2,(float)31.5,date3);
		
		
		resp.getWriter().println(stock1.getHtmlDescription());
		resp.getWriter().println("<br>");
		resp.getWriter().println(stock2.getHtmlDescription());
		resp.getWriter().println("<br>");
		resp.getWriter().println(stock3.getHtmlDescription());
	}

}
