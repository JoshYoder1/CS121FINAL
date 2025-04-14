//Dealer.java
import java.util.*;
public class Dealer{  
	private ArrayList<String> hand = new ArrayList<String>();
	private int handAmount;
	private int soft;

	public static void main(String[] args){
		System.out.println("Testing Dealer");
		try{ 
			Dealer test = new Dealer();
			System.out.println(test.getHand());
			test.hit();
			System.out.println(test.getHand());
		} catch(Exception e){
			System.out.println(e.getMessage());
	}//end main

	public Dealer(){
		hand = new ArrayList<String>();
		handAmount = 0;
		soft = 17;
	}//end constructor
	
	public ArrayList<String> getHand(){
		return(hand);
	}//end getHand

	public void hit(){
		String [] cards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		hand.add(cards[(int)(Math.random() * 14)]);
	}//end hit
}//end class
