//Venue.java

import java.util.*;
import java.io.Serializable;

public class Venue implements Serializable{
	private String City;
	private String Name;
	private String Phone;
	private String URL;
	private String Capacity;
	private ArrayList<String> Style = new ArrayList<String>();

	public Venue(){
		City = null;
		Name = null;
		Phone = null;
		URL = null;
		Capacity = null;
	}//end constuctor

	public void setCity(String city){
		City = city;
	}//end setCity

	public void setName(String name){
		Name = name;
	}//end setName

	public void setPhone(String phone){
		Phone = phone;
	}//end setPhone

	public void setURL(String url){
		URL = url;
	}//end setURL

	public void setCapacity(String capacity){
		Capacity = capacity;
	}//end csetCapacity

	public void setStyle(String style){
		Style.add(style);
	}//end setStyle
	
	public String getCity(){
		return(City);
	}//end getCity

	public String getName(){
		return(Name);
	}//end getName

	public String getPhone(){
		return(Phone);
	}//end getPhone
	
	public String getURL(){
		return(URL);
	}//end getURL

	public String getCapacity(){
		return(Capacity);
	}//end getCapacity

	public ArrayList<String> getStyle(){
		return(Style);
	}//end getStyle

	public void printVenue(){
		System.out.println("---" + Name + "---");
		System.out.println("City: " + City);
		System.out.println("Phone: " + Phone);
		System.out.println("Website: " + URL);
		System.out.println("Capacity: " + Capacity);
		System.out.print("Genre: ");
		for(String i : Style){
			System.out.print(i + ", ");
		}//end for
		System.out.println();
		//System.out.print("--------------------");
		//System.out.println();
	}//end printVenue
}//end class
