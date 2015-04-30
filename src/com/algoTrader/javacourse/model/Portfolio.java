package com.algoTrader.javacourse.model;

import com.algoTrader.javacourse.Stock;

public class Portfolio {
	
	String title = new String();
	final static int MAX_PORTFOLIO_SIZE = 5;
	Stock[] stocks;
	int portfolioSize;
	
	public Portfolio()
	{
		title = "asaf portfolio";
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		portfolioSize = 0;
	}
	public void addStock(Stock stock)
	{	
		if(stock != null && portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			stocks[portfolioSize] = stock;
			portfolioSize++;
		}
	}
	public Stock getStocks()
	{
		return stocks[0];
	}
	public String getHtmlString()
	{
		String str = new String("<h1>" + getTitle() + "</h1>");
		for (int i = 0; i < portfolioSize; i++)
		{
			str += stocks[i].getHtmlDescription();
			str += "<br>";
		}
		return str;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPortfolioSize() {
		return portfolioSize;
	}
	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}
	public static int getMaxPortfolioSize() {
		return MAX_PORTFOLIO_SIZE;
	}
	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	
}
