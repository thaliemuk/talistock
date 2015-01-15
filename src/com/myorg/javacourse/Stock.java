package com.myorg.javacourse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	private int recommendation;
	private int stockQuantity;
	private static final int BUY = 0;
	private static final int SELL = 1;
	private static final int REMOVE = 2;
	private static final int HOLD = 3;
	
	public Stock(){
		this("",0,0,new Date(),0,0);
	}
	public Stock(String symbol, float ask,	float bid, Date date){
		this.symbol  = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = new Date(date.getTime());
	}
	public Stock(String symbol, float ask,	float bid, Date date, int recommendation, int stockQuantity){
		this(symbol,ask,bid,date);
		this.recommendation = recommendation;
		this.stockQuantity = stockQuantity;
	}
	
	public Stock(Stock other){
		this.symbol = other.symbol;
		this.ask = other.ask;
		this.bid = other.bid;
		this.date = new Date(other.date.getTime());
		this.recommendation = other.recommendation;
		this.stockQuantity = other. stockQuantity;
		
	}
	public String getHtmlDescription(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		
		return "<b> Stock Symbol: </b> "+this.getSymbol() +
				", <b> Ask: </b> "+this.getAsk()+
				", <b> bid: </b> " + this.getBid()+
				", <b> date: </b> " + dateFormat.format(this.getDate());
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = new Date(date.getTime());
	}
	
	

}
