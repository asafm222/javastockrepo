package com.algoTrader.javacourse;


public class Stock {

	public static int BUY = 0;
	public static int SELL = 1;
	public static int REMOVE = 2;
	public static int HOLD = 3;
	
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
	
	
	
	public String getHtmlDescription(){
		String stockDetail = new String("<b>Stock symbol</b>:"+getSymbol()+" <b>ask</b>:"
				+getAsk()+" <b>bid</b>:"+getBid()+" <b>date</b>:"+getDate().getDate()+ "/"
				+getDate().getMonth()+ "/" + getDate().getYear());
		return stockDetail;
	}

}
