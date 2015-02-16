package com.myorg.javacourse.service;

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Stock;

public class PortfolioManager {
	public Portfolio getPortfolio(){
		Portfolio portfolio = new Portfolio();
		portfolio.setTitle("Exercise 7 portfolio");
		portfolio.updateBalance(10000);
		
		Stock PIH = new Stock("PHI", 10f, 8.5f,20);
		
		portfolio.buyStock(PIH);
		
		Stock AAL = new Stock("AAL",30f,25.5f,30);
		portfolio.buyStock(AAL);
		
		Stock CAAS = new Stock("CAAS",20f,15.5f,40);
		portfolio.buyStock(CAAS);
		
		portfolio.sellStock("AAL");
		portfolio.removeStock("CAAS");
		
		
		return portfolio;

		
	}

}
