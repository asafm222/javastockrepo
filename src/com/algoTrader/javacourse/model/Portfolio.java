package com.algoTrader.javacourse.model;
/**
class Portfolio have arr of stocks max 5 stock

created by asaf mashiah!! 
 */


public class Portfolio {

	String title = new String();
	final static int MAX_PORTFOLIO_SIZE = 5;
	public Stock[] stocks;
	public int portfolioSize;
	
	public Portfolio()
	{
		this.title = "asaf portfolio";
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0;
	}
	public Portfolio(String title,int portfolioSize)
	{
		this.title = title;
		this.portfolioSize = portfolioSize;
		this.stocks = new Stock[portfolioSize];
	}
	public Portfolio(Portfolio portfolio)
	{
		this(new String(portfolio.getTitle()),portfolio.portfolioSize);
		
		//this.portfolioSize = portfolio.portfolioSize;
		//this.title = new String(portfolio.getTitle());
		
		Stock[] coppy = portfolio.getStocks();
		for (int i = 0; i < portfolio.portfolioSize; i++) 
		{
			this.stocks[i] = new Stock(coppy[i]); 
		}
	}
	
	/**
	add stock to the arr

	created by asaf mashiah!! 
	 */
	public void addStock(Stock stock)
	{	
		if(stock != null && portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			stocks[portfolioSize] = stock;
			portfolioSize++;
		}
	}
	
	/**
	remove stock from the arr

	created by asaf mashiah!! 
	 */
	public void removeStock(Stock stock)
	{
		for (int i = 0; i < this.portfolioSize; i++) 
		{
			if(this.stocks[i].getSymbol().equals(stock.getSymbol())); 
			{
				this.stocks[i] = this.stocks[this.portfolioSize -1];
				this.stocks[this.portfolioSize -1] = null;
				this.portfolioSize--;
				break;
			}
		}
		
	}
	
	/**
	return arr of stocks

	created by asaf mashiah!! 
	 */
	public Stock[] getStocks()
	{
		return stocks;
	}
	
	/**
	return str with all details about all the stocks in the porfolio

	created by asaf mashiah!! 
	 */
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
