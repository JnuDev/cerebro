package com.meli.cerebro.service.domain.pojo;

public class Stats {
	
	private double mutans;
	
	private double humans;
	
	private double ratio;
	

	public Stats(double mutans, double humans) {
		super();
		
		this.mutans = mutans;
		this.humans = humans;
		
		this.ratio = (humans> 0.0)? Math.round((mutans/humans) * Math.pow(10, 1)) / Math.pow(10, 1): 0.0; 

	}
		
	public double getCount_mutant_dna() {
		return mutans;
	}

	public double getCount_human_dna() {
		return humans;
	}
	
	
	public double getRatio() {
		return ratio;
	}
	
//	@Override
//	public String toString() {
//		return "{count_mutant_dna:" + mutans + ", count_human_dna:" + humans + ", ratio:" + ratio + "}";
//	}
		
}
