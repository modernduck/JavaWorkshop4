import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.fwd.*;
import org.fwd.example.CsvFwd;
import org.fwd.example.Customer;
import org.fwd.example.GraphData;
import org.fwd.example.Transaction;

public class Example {

	public static void main(String[] args) throws IOException, NumberFormatException, ParseException {
		// TODO Auto-generated method stub
		
		String path = "/Users/sompopkulapalanont/eclipse-workspace/My Chart/test.csv";
		CsvFwd saleCsv = new CsvFwd(path);
		List<String[]> data = saleCsv.getData();
		List<Transaction> transactions = Transaction.getTransactionsFromCsv(data);
		
		//XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)",xData, yData);
		XYChart chart = new XYChartBuilder().width(800).height(600).title("LineChart03").xAxisTitle("Date").yAxisTitle("Y").build();
		  // generates linear data
	    List<Date> xData = new ArrayList<Date>();
	    List<Double> yData = new ArrayList<Double>();

	    DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	    Date date = null;
	    for (int i = 1; i <= 10; i++) {

	      try {
	        date = sdf.parse(i + ".10.2008");
	      } catch (ParseException e) {
	        e.printStackTrace();
	      }
	      xData.add(date);
	      yData.add(Math.random() * i);
	    }

	    // Series
	    XYSeries series = chart.addSeries("Fake Data", xData, yData);
	    series.setLineColor(XChartSeriesColors.BLUE);
	    series.setMarkerColor(Color.ORANGE);
	    series.setMarker(SeriesMarkers.CIRCLE);
	    series.setLineStyle(SeriesLines.SOLID);
	    new SwingWrapper(chart).displayChart();
	    //return chart;
		//System.out.println(data.get(0)[0]);
		/* double[] xData = new double[] { 0.0, 1.0, 2.0 };
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
	    BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);*/
	}

}
