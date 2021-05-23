package com.example.healthitdata.domain;

public class BasicEhrNotesUsage {

	private String stateName;
	private Double percentage;
	
	public BasicEhrNotesUsage(String stateName, Double percentage) {
		super();
		this.stateName = stateName;
		this.percentage = percentage;
	}
	
	public BasicEhrNotesUsage() {
	}

	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public void print() {
		System.out.println(stateName + ":" + percentage);		
	}
	
}
