// Player.java
interface Player{
	protected ArrayList<String> hand = new ArrayList<String>();
	protected int handAmount;
	
	public void hit();
	public void stand();
	public void bust();
	public void blackjack();
}//end interface
