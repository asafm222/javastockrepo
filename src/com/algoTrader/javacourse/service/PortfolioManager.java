package com.algoTrader.javacourse.service;

import java.util.Calendar;

import com.algoTrader.javacourse.Stock;
import com.algoTrader.javacourse.model.Portfolio;


public class PortfolioManager {
	
	public Portfolio getPortfolio()
	{
		Portfolio currPortfolio = new Portfolio();
		
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
		
		currPortfolio.addStock(stock1);
		currPortfolio.addStock(stock2);
		currPortfolio.addStock(stock3);
		
		return currPortfolio;
	}
}
