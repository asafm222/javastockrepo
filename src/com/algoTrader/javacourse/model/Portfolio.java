package com.algoTrader.javacourse.model;

/**
class Portfolio have arr of stocks max 5 stock

created by asaf mashiah!! 
 */
public class Portfolio {
	
	public enum ALGO_RECOMMENDATION
	{
		BUY,SELL,REMOVE,HOLD
	}
	
	String title = new String();
	final static int MAX_PORTFOLIO_SIZE = 5;
	public Stock[] stocks;
	public int portfolioSize;
	private float balance;
	
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
		boolean stockExist = false;
		
		if(stock != null && portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			for (int i = 0; i < this.portfolioSize; i++)
			{
				if(stocks[i].getSymbol().equals(stock.getSymbol()))
				{
					stockExist = true;
				}
			}
			if(stockExist == false)
			{
				stocks[portfolioSize] = stock;
				portfolioSize++;
			}
		}
		else if(portfolioSize >= MAX_PORTFOLIO_SIZE)
		{
			System.out.println("Can’t add new stock, portfolio can have only"+ MAX_PORTFOLIO_SIZE+ "stocks");
		}
	}
	
	/**
	sell the all quantity from this stock and remove stock from the portfolio

	created by asaf mashiah!! 
	 */
	public boolean removeStock(Stock stock)
	{
		boolean sellSucceeded = true;
		
		for (int i = 0; i < this.portfolioSize; i++) 
		{
			if(this.stocks[i].getSymbol().equals(stock.getSymbol())) 
			{
				sellSucceeded = sellStock(stock.getSymbol(),-1);
				if(sellSucceeded == true)
				{
					this.stocks[i] = this.stocks[this.portfolioSize -1];
					this.stocks[this.portfolioSize -1] = null;
					this.portfolioSize--;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	sell the quantity in the parameter.
	if the quantity = -1 sell the all quantity.
	return true if the sell succeeded or false if failed

	created by asaf mashiah!! 
	 */
	public boolean sellStock(String symbol,int quantity)
	{
		for (int i = 0; i < this.portfolioSize; i++)
		{
			if(this.stocks[i].getSymbol().equals(symbol)) 
			{
				if(stocks[i].stockQuantity >= quantity)
				{
					if(quantity == -1)
					{
						this.balance += (stocks[i].stockQuantity * stocks[i].getBid());
						stocks[i].stockQuantity = 0;
						return true;
					}
					else
					{
						this.balance += (quantity * stocks[i].getBid());
						stocks[i].stockQuantity -= quantity;
						return true;
					}
				}
				else
				{
					System.out.println("Not enough stocks to sell");
				}
			}
		}
		return false;
	}
	
	/**
	buy the quantity in the parameter from this stock.
	if the quantity = -1 buy the all quantity possible.
	if the stock is not exist it add it to the portfolio
	return true if the buy succeeded or false if failed

	created by asaf mashiah!! 
	 */
	public boolean buyStock(Stock stock,int quantity)
	{
		float purchase = quantity * stock.getAsk();
		boolean stockExist = false;
		int stockIndex = 0;
		
		if(purchase <= this.balance)
		{
			for (int i = 0; i < this.portfolioSize; i++)
			{
				if(this.stocks[i].getSymbol().equals(stock.getSymbol()))
				{
					stockExist = true;
					stockIndex = i;
				}
			}
			if(stockExist == false && this.portfolioSize <= MAX_PORTFOLIO_SIZE)
			{
				addStock(stock);
				stockIndex = getPortfolioSize() -1;
			}
			if(quantity >= 0)
			{
				updateBalance(-purchase);
				stocks[stockIndex].setStockQuantity(quantity);
				return true;
			}
			else if(quantity == -1)
			{
				while(quantity * stock.getAsk() <= this.balance)
				{
					stocks[stockIndex].stockQuantity++;
					updateBalance(-purchase);
					quantity--;
				}
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			System.out.println("Not enough balance to complete purchase");
			return false;
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
		str += "Total Portfolio Value " + getTotalValue()+ "$" + "<br>";
		str += "Total Stocks value " + getStocksValue()+ "$" + "<br>";
		str += "Balance " + getBalance()+ "$" + "<br>";
		return str;
	}
	
	/**
	update the value of the balance

	created by asaf mashiah!! 
	 */
	public void updateBalance(float amount)
	{
		if(this.balance + amount >= 0)
		{
			this.balance += amount;
		}
	}
	
	/**
	return the stocks value in the portfolio

	created by asaf mashiah!! 
	 */
	public float getStocksValue()
	{
		float stocksValue = 0;
		for (int i = 0; i < this.portfolioSize; i++)
		{
			stocksValue += (stocks[i].getBid() * stocks[i].getStockQuantity());
		}
		return stocksValue;
	}
	
	/**
	return the stock value in the portfolio + the value of the balance

	created by asaf mashiah!! 
	 */
	public float getTotalValue()
	{
		return getStocksValue() + getBalance();
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
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
