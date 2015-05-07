package com.algoTrader.javacourse.servlet;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Algo_trader_asafmServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		
		 int num1;
		 int num2;
		 int num3;
		 
		 num1 = 4;
		 num2 = 3;
		 num3 = 7;
		
		 int result = (num1 + num2) * num3;
		 resp.getWriter().println("Result of " + "("+num1 + "+" + num2 +") *"+ num3+ "="+ result);
				 
	}
}
