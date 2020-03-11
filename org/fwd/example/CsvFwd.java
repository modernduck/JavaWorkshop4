package org.fwd.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFwd {

	public String path;
	public CsvFwd(String path) {
		this.path = path;
	}
	
	public List<String[]> getData(){
		List<String[]> answer = new ArrayList<String[]>();
		 BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(this.path));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] record = line.split(cvsSplitBy);
                answer.add(record);
               

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return answer;
	}
	
}
