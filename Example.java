import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.fwd.*;
import org.fwd.example.Customer;
import org.fwd.example.GraphData;

public class Example {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 double[] xData = new double[] { 0.0, 1.0, 2.0 };
	    double[] yData = new double[] { 2.0, 1.0, 0.0 };
	 
	    // Create Chart
	    //XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);
	 
	   
	    List<Customer> customers = new ArrayList<Customer>();
	    customers.add(new Customer(20, 20000));
	    customers.add(new Customer(25, 40000));
	    customers.add(new Customer(30, 35000));
	   
	   // GraphData customerData = Customer.getCustomerGraphData(customers);
	   // XYChart chart = QuickChart.getChart("Sample Chart", "Age", "Salary", "y(x)",customerData.x  , customerData.y);
	    
	    //GOAL
	    XYChart chart = Customer.getCustomerGraph(customers);
	    //new SwingWrapper(chart).displayChart();
	    BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);
	}

}
