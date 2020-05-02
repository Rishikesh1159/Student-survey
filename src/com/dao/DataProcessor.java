/*Rishikesh pasham*/

package com.dao;
import com.bean.DataBean;


public class DataProcessor {
	private String data;
	
	public DataBean calculate(String d)
	{
		DataBean dbean = new DataBean();
		this.data = d; 
		dbean.setStd(std());
		dbean.setMean(mean());
		return dbean;
	}
	
	  
	 // this method calculates the standard deviation 
	  public double std()
	    {
		  double sum = 0.0; 
		  double length = 10.0;
		  double standardDeviation = 0.0;
	
		  String[] tokens = data.split(",");
		    for (String token : tokens) {
			      Double num = Double.parseDouble(token);
			      sum += num;      
		    }

	        double mean = sum/length;
		    for (String token : tokens) {
			      Double num = Double.parseDouble(token);
			      standardDeviation += Math.pow(num - mean, 2);  
		    }

	        return Math.sqrt(standardDeviation/length);
	    }
	  // this method calculates the mean
	  public float mean()
	  {
	    String[] tokens = data.split(",");
	    float sum = 0.0F;
	    for(int i=0;i<tokens.length;i++)
	    {
	    	sum+=Integer.parseInt(tokens[i]);
	    }
	     return sum / tokens.length;
	  }
	

}
