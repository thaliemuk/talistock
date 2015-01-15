package com.myorg.javacourse.service;

import java.util.Date;

import com.myorg.javacourse.Stock;
import com.myorg.javacourse.model.Portfolio;

public class PortfolioManager {
	public Portfolio getPortfolio(){
		Portfolio portfolio = new Portfolio("portfolio");	
		
		Stock PIH = new Stock("PHI",(float)13.1,(float)12.4,new Date());
		portfolio.addStock(PIH);
		
		Stock AAL = new Stock("AAL",(float)5.78,(float)5.5,new Date());
		portfolio.addStock(AAL);
		
		Stock CAAS = new Stock("CAAS",(float)32.2,(float)31.5,new Date());
		portfolio.addStock(CAAS);
		
		return portfolio;

		
	}

}
