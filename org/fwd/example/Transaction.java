package org.fwd.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Transaction {

	public Date date;
	public String productID;
	public double saleAmount;

	//                 "2020-03-01"  , "A",     , 300.0
	public Transaction(String sqlDate, String id, double saleAmount) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		this.date = sdf.parse(sqlDate);
		this.productID = id;
		this.saleAmount = saleAmount;		
	}

	public static List<Transaction> getTransactionsFromCsv(List<String[]> data) throws NumberFormatException, ParseException{
		List<Transaction> answer = new ArrayList<Transaction>();
		//
		for(int i = 0;i < data.size(); i++) {
			String[] record = data.get(i);//{"2020-03-01", "A", "300"
			Transaction transactionRecord = new Transaction(record[0], record[1], Double.parseDouble(record[2]) );
			answer.add(transactionRecord);
		}
		
		return answer;
	}
}
