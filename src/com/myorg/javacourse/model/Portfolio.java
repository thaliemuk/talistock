package com.myorg.javacourse.model;

import java.util.Date;


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
	private float balance;
	//returns the sock index in the stocks array, by the symbol
	private int getStockIndexBySymbol(String symbol){
		
		for(int i = 0; i < this.portfolioSize; i++){
			if(this.stocks[i] != null && this.stocks[i].getSymbol().equals(symbol)){
				return i;
			}
		}
		return -1;
	}
	
	public enum ALGO_RECOMMENDATION{
		
		BUY(0), SELL(1), REMOVE(2), HOLD(3);
	    private int value;

	   private ALGO_RECOMMENDATION(int value) {
		   this.value = value;
	   }
	}; 
	
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
		this.portfolioSize = 0;
	}
	/**
	 * create a new portfolio, deep copied of the given portfolio
	 * @param portfolio to copy
	 * */
	public Portfolio(Portfolio portfolio) {
		this(portfolio.title);

		//deep copy of stocks array
		for(int i = 0; i < portfolio.portfolioSize; i++){
			this.addStock(portfolio.stocks[i]);
		}
	}
	
	/**
	 * add a new stock to the portfolio
	 * @param stock - the stock to add
	 * */
	public int addStock(Stock stock){
		int insertedStockIndex =-1; 
		int stockIndex = getStockIndexBySymbol(stock.getSymbol());
		if(stockIndex == -1){
			if(this.portfolioSize < MAX_PORTFOLIO_SIZE  ){
				insertedStockIndex = this.portfolioSize;
				this.stocks[insertedStockIndex] = new Stock(stock);
				this.portfolioSize++;
			}
			else{
				System.out.print("Can’t add new stock, portfolio can have only "+ MAX_PORTFOLIO_SIZE+" stocks");
			}
		}else{
			return stockIndex;
		}
		return insertedStockIndex;
	}
	
	/**
	 * remove a stock from a specific location in the portfolio
	 * @param location - index of stock to remove in the stock array
	 * */
	public boolean removeStock(int location){
		if(location < MAX_PORTFOLIO_SIZE){
			int lastIndex = this.portfolioSize-1;
		
			this.stocks[location] = new Stock( this.stocks[lastIndex]);
			this.stocks[lastIndex] = null;
			this.portfolioSize--;
			return true;
		}
		return false;
	}
	/**
	 * removes a stock from the potfolio.
	 * this action sells the stock first
	 * @param symbol - the stock symbol to remove
	 * */
	public boolean removeStock(String symbol){
		int stockIndex = getStockIndexBySymbol(symbol);
		if(stockIndex != -1 &&
			this.sellStock(symbol, -1) &&
				this.removeStock(stockIndex)){
			
			return true;
		}
		return false;
	}
	/**
	 * sell all the quantity of a certain stock
	 * @param symbol - the stock symbol to sell
	 * */
	public boolean sellStock(String symbol){
		return this.sellStock(symbol, -1);
	}
	
	/**
	 * sell a stock in a defined quantity
	 * @param symbol - the stock symbol to sell
	 * */
	public boolean sellStock(String symbol, int quantity){
		int stockIndex = this.getStockIndexBySymbol(symbol);
		if(stockIndex != -1){
			Stock toSell = this.stocks[stockIndex];
			int currentQuantity = toSell.getStockQuantity();
			if(quantity == -1){
				quantity = currentQuantity;
			}
			if(currentQuantity < quantity){
				System.out.print("Not enough stocks to sell");
				return false;
			}else{
				
				toSell.setStockQuantity(currentQuantity - quantity);
				this.updateBalance(quantity * toSell.getBid());
				return true;
			}
		}
		return false;
		
	}
	/**
	 * buy as many stock as possible : according to balance and stock quantity the quantity of a certain stock
	 * @param symbol - the stock symbol to buy
	 * */
	public boolean buyStock(Stock stock){
		return this.buyStock(stock, -1);
	}
	/**
	 * buy a stock in a specific quantity (as much as the balance will allow 
	 * @param symbol - the stock symbol to buy
	 * */
	public boolean buyStock(Stock stock, int quantity){
		
		int stockIndex = this.getStockIndexBySymbol(stock.getSymbol());
		if(stockIndex == -1){
			//add the stock to the portfolio but without a quantity
			stockIndex =  this.addStock( new Stock( stock.getSymbol(),stock.getAsk(), stock.getBid(), stock.getDate()) );
		}
		Stock toBuy = this.stocks[stockIndex];
		int currentQuantity = stock.getStockQuantity();
		if(quantity == -1){
			quantity = Math.min((int)(this.balance / toBuy.getAsk()), currentQuantity);
		}
		if(this.updateBalance(- (quantity * stock.getAsk()))){
			toBuy.setStockQuantity(quantity);
			return true;
		}
		
		return false;
	}
	/**
	 * portfolio stock value
	 * @return the total value of the stocks ask in the portfolio
	 * */
	public int getStocksValue(){
		int sum = 0;
		for(int i = 0; i < this.portfolioSize; i++){
			if(this.stocks[i] != null){
				sum += this.stocks[i].getAsk() * this.stocks[i].getStockQuantity();
			}
		}
		return sum;
	}
	/**
	 * portfolio balance
	 * @return the total amount of money in the portfolio
	 * */
	public float getBalance(){
		return this.balance;
	}
	/**
	 * portfolio total value
	 * @return the total amount of money in the portfolio and the value of the stocks
	 * */
	public float getTotalValue(){
		return this.getBalance() + this.getStocksValue();
	}
	
	/**
	 * change a bid of a stock in a spesific location in the stock array
	 * @param location - index of stock to change in the stock array
	 * @param bid - new bid to set to the stock
	 * */
	public void changeStockBid(int location, float bid){
		if(location < this.portfolioSize){
			this.stocks[location].setBid(bid);
		}
	}
	/**
	 * change the portfolio title
	 * @param title - new title to set
	 * */
	public void setTitle(String title ){
		this.title = title;
	}
	
	/**
	 * @return string representation of a portfolio
	 * */
	public String getHtmlString(){
		String portfoiloString = "<h1>"+this.title+"</h1></br>";
		portfoiloString += "Total Portfolio Value: " + this.getTotalValue() + " $</br>";
		portfoiloString += "Total Stocks value: " + this.getStocksValue() + " $</br>";
		portfoiloString += "Balance: " + this.getBalance() + " $</br>";
		
		for	(int i = 0; i< this.portfolioSize; i++){
			portfoiloString +="</br>"+ this.stocks[i].getHtmlDescription();
		}
		return portfoiloString;
		
	}
	
	public boolean updateBalance(float amount){
		if(this.balance + amount >= 0){
			this.balance += amount;
			return true;
		}else{
			System.out.print("Not enough balance to complete purchase.");
			return false;
		}
		
	}



}
