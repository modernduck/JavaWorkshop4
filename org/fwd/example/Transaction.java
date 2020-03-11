package org.fwd.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Transaction {

	public Date date;
	public String productID;
	public double saleAmount;
	
	public Transaction(String sqlDate, String id, double saleAmount) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		this.date = sdf.parse(sqlDate);
		this.productID = id;
		this.saleAmount = saleAmount;		
	}
	
	public static List<Transaction> create(List<String[]> data){
		List<Transaction> answer = new ArrayList<Transaction>();
		return answer;
	}
}
