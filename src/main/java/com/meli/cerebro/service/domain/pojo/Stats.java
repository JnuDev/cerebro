package com.meli.cerebro.service.domain.pojo;


public class Stats {
	
	private int mutans;
	
	private int human;
	
	private double ratio;
	
	/*
	 * 
	 * 
	 */
	public Stats(int mutans, int human) {
		super();
		this.mutans = mutans;
		this.human = human;
		this.ratio = (mutans > 0.0)?Math.round((mutans / human)* 10.0)/10.0 :0.0;;
	}
	

	public int getMutansCount() {
		return mutans;
	}



	public int getHumanCount() {
		return human;
	}



	public double getRatio() {
		return ratio;
	}
		
}
