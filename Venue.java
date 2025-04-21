//Venue.java
public class Venue{
	private String City;
	private String Name;
	private String Phone;
	private String URL;
	private String Capacity;
	private Arraylist<String> Style;

	public Venue(){
		City = null;
		Name = null;
		Phone = null;
		URL = null;
		Capacity = null;
		Style = new Arraylist<String>();
	}//end constuctor

	public void setCity(String city){
		City = city;
	}//end setCity

	public void setName(name){
		Name = name;
	}//end setName

	public void setPhone(phone){
		Phone = phone;
	}//end setPhone

	public void setURL(url){
		URL = url;
	}//end setURL

	public void setCapacity(capacity){
		Capacity = capacity;
	}//end csetCapacity

	public void setStyle(style){
		Style = style;
	}//end setStyle
}//end class
