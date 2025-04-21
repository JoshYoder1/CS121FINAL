//Program.java
import java.util.*;
import java.io.*;

public class Program{
	private ArrayList<Venue> Venues = new ArrayList();

	public static void main(String[] args){
		Program x = Program();
	}//end main
	
	public Program(){
		System.out.println("Running Program");
		readCSV();
	}//end Program

	public void readCSV(){
		String filePath = "venues.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
			String line;

			while((line = br.readLine()) != null) {
				String [] values = line.split(",");
				if(values.length >= 5){
					Venue x = new Venue();
					x.setCity(values[0]);
					x.setName(values[1]);
					x.setPhone(values[2]);
					x.setURL(values[3]);
					x.setCapacity(values[4]);

					for(int i = 5; i < values.length; i++){
						x.setStyle(values[i]);
					}//end for
				}//end if
			Venues.add(x);
			}//end while
		} catch (IOException e){
			e.printStackTrace();
		}//end try
	}//end readCSV	
}//end class
