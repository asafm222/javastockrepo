package com.algoTrader.javacourse.model;

import java.util.Date;

/**
class stock

created by asaf mashiah!! 
 */
public class Stock {

	public enum action
	{
		BUY,SELL,REMOVE,HOLD
	}
	
	private String symbol;
	private float ask;
	private float bid;
	private java.util.Date date;
	int recommendation;
	int stockQuantity;
	
	public Stock(String symbol,float ask,float bid,java.util.Date date){
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = date;
	}
	
	public Stock(Stock stock)
	{
		//this(new String(stock.getSymbol()),stock.ask,stock.bid,new Date(stock.getDate().getTime()));
		this.symbol = new String(stock.getSymbol());
		this.ask = stock.ask;
		this.bid = stock.bid;
		this.date = new Date(stock.getDate().getTime());
	}
	
	public String getSymbol() {
		return symbol;
	}	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask; 
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	
	/**
	return string of all the stock details

	created by asaf mashiah!! 
	 */
	public String getHtmlDescription(){
		String stockDetail = new String("<b>Stock symbol</b>:"+getSymbol()+" <b>ask</b>:"
				+getAsk()+" <b>bid</b>:"+getBid()+" <b>date</b>:"+getDate().getDate()+ "/"
				+getDate().getMonth()+ "/" + getDate().getYear());
		return stockDetail;
	}

}
