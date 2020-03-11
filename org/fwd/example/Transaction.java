package org.fwd.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Transaction {

	public Date date;
	public String productID;
	public int quantity;
	
	public Transaction(String sqlDate, String id, int quantity) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		this.date = sdf.parse(sqlDate);
		this.productID = id;
		this.quantity = quantity;		
	}
}
