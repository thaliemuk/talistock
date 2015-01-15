package com.myorg.javacourse.model;

import com.myorg.javacourse.Stock;


public class Portfolio {
	private static final int MAX_PORTFOLIO_SIZE = 5;
	
	private String title;
	private Stock [] stocks;
	private int portfolioSize;
	
	public Portfolio() {
		this("default portfolio name");
	}
	public Portfolio(String title) {
		this.title = title;
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		portfolioSize = 0;
	}
	
	public void addStock(Stock stock){
		if(portfolioSize < MAX_PORTFOLIO_SIZE -1 ){
			
			this.stocks[this.portfolioSize] = new Stock(stock);
			this.portfolioSize++;
		}
	}
	public Stock[] getStocks(){
		return this.stocks;
	}
	public String getHtmlString(){
		String portfoiloString = "<h1>"+this.title+"</h1>";
		
		
		for	(int i = 0; i< this.portfolioSize; i++){
			portfoiloString +="</br>"+ this.stocks[i].getHtmlDescription();
		}
		return portfoiloString;
		
	}

}
