package com.myorg.javacourse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Exercise3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = 20, num2 =13, radius=50, angleB = 30, Hypotenuse = 50;
		
		//circle
		double circelArea = Math.PI * Math.pow(radius, 2);
		String calculationCircleArea = new String("<h1>Area of circle with radius "+radius+" is: "+circelArea+" square-cm.</h1>");
		
		//length of triangle opposite
		double opposite = Math.sin( Math.toRadians(angleB)) * Hypotenuse;
		String calculationTriangleOpposite = new String("<h1>Length of opposite where angle B is " + angleB+ " degrees and Hypotenuse length is "+Hypotenuse+" cm is: "+ opposite+" cm.</h1>");
		
		double power20_13 = Math.pow(num1,num2);
		String calculatoinPower = new String("<h1>Power of "+num1+" with exp of "+num2+" is "+power20_13+".</h1>");
		
		//total
		String allCalculations = new String( calculationCircleArea +"<br>" + calculationTriangleOpposite +"<br>" + calculatoinPower);
		resp.setContentType("text/html"); 
		resp.getWriter().println(allCalculations);
		
	}

}
