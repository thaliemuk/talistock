package com.myorg.javacourse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	
	public Stock(){
		this.symbol  = "";
		this.ask = 0;
		this.bid = 0;
		this.date = new Date();
	}
	public Stock(String symbol, float ask,	float bid, Date date){
		this.symbol  = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = new Date(date.getTime());
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
