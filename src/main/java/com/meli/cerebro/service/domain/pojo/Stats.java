package com.meli.cerebro.service.domain.pojo;


public class Stats {
	
	private int mutansCount;
	
	private int humanCount;
	
	private double ratio;
	
	
	public Stats(int mutansCount, int humanCount) {
		super();
		this.mutansCount = mutansCount;
		this.humanCount = humanCount;
		this.ratio = (mutansCount > 0.0)?Math.round((mutansCount / humanCount)* 10.0)/10.0 :0.0;;
	}
	

	public int getMutansCount() {
		return mutansCount;
	}



	public int getHumanCount() {
		return humanCount;
	}



	public double getRatio() {
		return ratio;
	}
		
}
