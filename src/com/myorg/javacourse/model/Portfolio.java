package com.myorg.javacourse.model;


/**
 * instance of this class represents a Portfolio of stocks
 * @author tali
 * @since 25/01/2015
 * */
public class Portfolio {
	private static final int MAX_PORTFOLIO_SIZE = 5;
	
	private String title;
	private Stock [] stocks;
	private int portfolioSize;
	
	/**
	 * create a new portfolio
	 * */
	public Portfolio() {
		this("default portfolio name");
	}
	
	/**
	 * create a new portfolio with a name
	 * */
	public Portfolio(String title) {
		this.title = title;
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		portfolioSize = 0;
	}
	/**
	 * create a new portfolio, deep copied of the given portfolio
	 * @param portfolio to copy
	 * */
	public Portfolio(Portfolio portfolio) {
		this(portfolio.title);

		//deep copy of stocks array
		for(int i=0; i < portfolio.stocks.length && i<portfolio.portfolioSize; i++){
			this.addStock(portfolio.stocks[i]);
		}
	}
	
	/**
	 * add a new stock to the portfolio
	 * @param stock - the stock to add
	 * */
	public void addStock(Stock stock){
		if(portfolioSize < MAX_PORTFOLIO_SIZE -1 ){
			
			this.stocks[this.portfolioSize] = new Stock(stock);
			this.portfolioSize++;
		}
	}
	
	/**
	 * remove a stock from a specific location in the portfolio
	 * @param location - index of stock to remove in the stock array
	 * */
	public void removeStock(int location){
		Stock last = new Stock( this.stocks[this.portfolioSize-1]);
		
		this.stocks[location] = last;
		this.stocks[this.stocks.length-1] = null;
		this.portfolioSize--;
	}
	
	
	/**
	 * change a bid of a stock in a spesific location in the stock array
	 * @param location - index of stock to change in the stock array
	 * @param bid - new bid to set to the stock
	 * */
	public void changeStockBid(int location, float bid){
		if(location <= this.portfolioSize){
			this.stocks[location].setBid(bid);
		}
		
	}
	public Stock[] getStocks(){
		return this.stocks;
	}
	
	public void setTitle(String title ){
		this.title = title;
	}
	
	/**
	 * @return string representation of a portfolio
	 * */
	public String getHtmlString(){
		String portfoiloString = "<h1>"+this.title+"</h1>";
		
		for	(int i = 0; i< this.portfolioSize; i++){
			portfoiloString +="</br>"+ this.stocks[i].getHtmlDescription();
		}
		return portfoiloString;
		
	}

}
