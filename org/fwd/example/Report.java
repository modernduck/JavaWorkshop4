package org.fwd.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Report {
	
	public List<Transaction> transactions;
	
	public Report(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	private TransactionSummaryRecord getSummary() {
		TransactionSummaryRecord answer = new TransactionSummaryRecord();
		// 1 ---- find distinct dates
		List<Date> distinctDates = new ArrayList<Date>();
		this.transactions.forEach(ts -> {

			if(distinctDates.size() == 0)
				distinctDates.add(ts.date);
			else {
				//check if ts.date in distinctDates
				boolean isDistinct = true;
				for(int i = 0; i < distinctDates.size(); i ++)
					if(distinctDates.get(i).compareTo(ts.date) == 0)
						isDistinct = false;
				;
				if(isDistinct)
					distinctDates.add(ts.date);
			}
		});
		//
		return null;
		
	}
	
}
