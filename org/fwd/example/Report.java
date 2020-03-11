package org.fwd.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Report {
	
	public List<Transaction> transactions;
	
	public Report(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	private List<Date> getDistinctDates(){
		// 1 ---- find distinct dates
		List<Date> distinctDates = new ArrayList<Date>();
		this.transactions.forEach(ts -> {

			if(distinctDates.size() == 0)
				distinctDates.add(ts.date);
			else {
				//check if ts.date in distinctDates
				boolean isDistinct = true;
				for(int i = 0; i < distinctDates.size(); i ++)
					if(distinctDates.get(i).compareTo(ts.date) == 0) {
						isDistinct = false;
						break;
					}
				if(isDistinct)
					distinctDates.add(ts.date);
			}
		});
		return distinctDates;
	}
	
	private TransactionSummaryRecord getSummary() {
		TransactionSummaryRecord answer = new TransactionSummaryRecord();
		// 1 ---- find distinct dates
		List<Date> distinctDates = this.getDistinctDates();
		//2. find sum sales in any date in distinct date
		//List<Double> SalesTotal = new ArrayList<Double>();
		Double[] salesTotal = new Double[distinctDates.size()];
		for(int i = 0; i < distinctDates.size();i++) 
			salesTotal[i] = 0.0;
		this.transactions.forEach(ts -> {
			int distinctIndex = 0;
			for(int i = 0; i < distinctDates.size();i++) {
				if(distinctDates.get(i).compareTo(ts.date) == 0){
					//ถ้าวันใน transaction ตรงกับ distinct date
					salesTotal[i] += ts.saleAmount;
				}
				
			}
		});
		List<Double> yData =  Arrays.asList(salesTotal);
		
		answer.xData = distinctDates;
		answer.yData = yData;
		
		return answer;
		
	}
	
}
