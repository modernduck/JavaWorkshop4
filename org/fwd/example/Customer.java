package org.fwd.example;

import java.util.ArrayList;
import java.util.List;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XYChart;



public class Customer {

	public	int age;
	public int salary
	;
	
	public Customer(int age, int salary){
		this.age = age;
		this.salary = salary;
	}
	
	public static XYChart getCustomerGraph(List<Customer> customers) {
		GraphData customerData = Customer.getCustomerGraphData(customers);
	    XYChart chart = QuickChart.getChart("Sample Chart", "Age", "Salary", "y(x)",customerData.x  , customerData.y);
	    return chart;
	}
	
	public static GraphData getCustomerGraphData(List<Customer> customers) {
		
		
		GraphData answer = new GraphData();
		answer.x = new double[customers.size()];
		answer.y = new double[customers.size()];
		
		for(int i = 0; i < customers.size(); i++) {
			answer.x[i] = customers.get(i).age;
			answer.y[i] = customers.get(i).salary;
		}
		/*ArrayList<Double> x = new ArrayList<Double>();
		ArrayList<Double> y = new ArrayList<Double>();
		customers.forEach(customer -> {
			
			x.add((double) customer.age);
			y.add((double) customer.salary);
		});
		GraphData answer = new GraphData();
		answer.x = x.toArray(new Double[x.size()]);
		answer.y = y.toArray(new Double[y.size()]);
		*/
		return answer;
	}
}
