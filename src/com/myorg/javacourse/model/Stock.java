package com.myorg.javacourse.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * instance of this class represents a Stock
 * @author tali
 * @since 25/01/2015
 * */
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
	
	/**
	 * empty constructor of stock
	 * */
	public Stock(){
		this("",0,0,new Date(),0,0);
	}
	/*
	 * create a new stock with default values
	 * */
	public Stock(String symbol, float ask,	float bid, Date date, int recommendation, int stockQuantity){
		this.symbol  = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = new Date(date.getTime());
		this.recommendation = recommendation;
		this.stockQuantity = stockQuantity;
	}
	/**
	 * create a new stock with default values
	 * */
	public Stock(String symbol, float ask,	float bid, Date date){
		this(symbol, ask, bid, date, 0, 0);	
	}
	
	/**
	 * create a deep copied stock
	 * @param other - the stock from which to create a new copied stock
	 * */
	public Stock(Stock other){
		this(other.symbol, other.ask, other.bid, other.date, other.recommendation, other. stockQuantity );	
	}

	/**
	 * @return a string representation of stock
	 * */
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
