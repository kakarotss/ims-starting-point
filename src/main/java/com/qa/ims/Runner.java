package com.qa.ims;

import org.apache.log4j.Logger;

public class Runner {

	public static final Logger LOGGER = Logger.getLogger(Runner.class);
	
	public static void main(String[] args) {
		
//	int [][] orderInfo = new int[10][2];
//	orderInfo[0][0]= 11;
//	orderInfo[0][1]= 12;
//	orderInfo[1][0]= 13;
//	orderInfo[1][1]= 14;
//	orderInfo[2][0]= 15;
//	
//	
//	for (int i = 0; i < orderInfo[0].length; i++) {
//	System.out.println(i);
//	}
		
		Ims ims = new Ims();
		ims.imsSystem();
	}

}
