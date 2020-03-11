package org.fwd.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionSummaryRecord {

	List<Date> xData;
	List<Double> yData;
	
	public TransactionSummaryRecord() {
		this.xData = new ArrayList<Date>();
		this.yData = new ArrayList<Double>();
	}
}
