package com.algoTrader.javacourse.service;

import java.util.Calendar;

import com.algoTrader.javacourse.model.Portfolio;
import com.algoTrader.javacourse.model.Stock;

/**
create a new portfolio with the some values 

created by asaf mashiah!! 
 */
public class PortfolioManager {
	
	public Portfolio getPortfolio()
	{
		Portfolio myPortfolio = new Portfolio();
		myPortfolio.setTitle("Exercise 7 portfolio");
		myPortfolio.setBalance(10000);
	
		java.util.Date date1 = new java.util.Date();
		java.util.Date date2 = new java.util.Date();
		java.util.Date date3 = new java.util.Date();
		
		Calendar cal = Calendar.getInstance();
		cal.set(3914,11,15);
		date1 = cal.getTime();
		date2 = cal.getTime();
		date3 = cal.getTime();
		
		Stock stock1 = new Stock("PIH",(float)10.0 ,(float) 8.5 ,date1);
		Stock stock2 = new Stock("AAL",(float)30.0 ,(float) 25.5 ,date2);
		Stock stock3 = new Stock("CAAS",(float)20.0,(float)15.5,date3);		
		
		myPortfolio.buyStock(stock1, 20);
		myPortfolio.buyStock(stock2, 30);
		myPortfolio.buyStock(stock3, 40);
		
		myPortfolio.sellStock(stock2.getSymbol(),-1);
		myPortfolio.removeStock(stock3);
		
		return myPortfolio;
	}
}
