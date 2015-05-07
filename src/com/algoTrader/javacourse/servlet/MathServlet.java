package com.algoTrader.javacourse.servlet;

import java.io.IOException;
import java.math.MathContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MathServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		
		double radius = 50;
		double area = Math.PI * Math.PI * radius;
		
		String line1 = new String("calculation 1:Area of circle with radius"+radius+"is:"+area+ "\n");
			
		double angleDegree = 30;
		int hypotenuse = 50;	
		double angleRdiane = Math.toRadians(angleDegree);
		double result = Math.sin(angleRdiane) * hypotenuse;
		
		String line2 = new String("calculation 2:Length of opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is " +result+"\n");
		
		double a = 20;
		double b = 13;
		double resultPow = Math.pow(a, b);
		
		String line3 = new String("calculation 3:Power of 20 with exp of 13 is " + resultPow+"\n");
		
		String resultStr = new String(line1+ "<br>"+ line2+"<br>"+ line3 );
		resp.getWriter().println(resultStr);
	}
	}


