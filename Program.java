//Program.java
import java.util.*;
import java.io.*;

public class Program{
	private ArrayList<Venue> Venues = new ArrayList();
	private ArrayList<Venue> Filtered = new ArrayList();
	private Scanner input = new Scanner(System.in);

	public static void main(String[] args){
		Program x = new Program();

	}//end main
	
	public Program(){
		System.out.println("Running Program");
		readCSV();
		saveVenues();
		loadVenues();
		/*for(Venue venue : Venues){
			venue.printVenue();
		}//end for
		*/
		start();
	}//end Program

	public void readCSV(){
		String filePath = "venues.csv";	
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
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
					Venues.add(x);
				}//end if
			}//end while
		} catch (IOException e){
			e.printStackTrace();
		}//end try
	}//end readCSV	

	public void saveVenues(){
		try{
			FileOutputStream fo = new FileOutputStream("venues.dat");
			ObjectOutputStream obOut = new ObjectOutputStream(fo);
			obOut.writeObject(Venues);
			obOut.close();
			fo.close();
		}catch(Exception e){
			System.out.println("Save Unsuccessful");
			e.printStackTrace();
		}//end try
	}//end saveVenues

	public void loadVenues(){
		try{
			FileInputStream fIn= new FileInputStream("venues.dat");
			ObjectInputStream obIn = new ObjectInputStream(fIn);
			Venues = (ArrayList<Venue>)obIn.readObject();
			obIn.close();
			fIn.close();
		} catch(Exception e){
			System.out.println("Load Unsuccessful");
			e.printStackTrace();
		}//end try
	}//end loadVenues

	public void menu(int type){
		if(type == 1){
			System.out.println("-----Main Menu-----");
			System.out.println("1) Search for venues");
			System.out.println("2) Set search filters");
			System.out.println("3) View tours");
			System.out.println("4) Info");
			System.out.println("0) Exit");
		}//end if | main menu
		else if(type == 2){
			System.out.println("--------------------");
			System.out.println("1) Next");
			System.out.println("2) Add to tour");
			System.out.println("0) Exit");
		}//end elif
	}//end menu

	public void start(){
		
		boolean keepGoing = true;
		while(keepGoing){
			menu(1);
			System.out.print(">");
			String choice = input.nextLine();

			if(choice.equals("1")){
				search();
			}//end if
			else if(choice.equals("2")){

			}//end elif
			else if(choice.equals("3")){

			}//end elif
			else if(choice.equals("4")){
				System.out.println("-----Info-----");
				System.out.println("Venues are located in Indiana and surrounding big cities.");
			}//end elif
			else if(choice.equals("0")){
				keepGoing = false;
			}//end elif
			else{
				System.out.println("!!!INVALID OPTION!!!");	
			}//end else
		}//end while
	}//end start

	public void setFilter(){};


	public void search(){
		boolean keepGoing = true;
		if(Filtered.size() == 0){
			for(Venue venue : Venues){
				venue.printVenue();
				menu(2);
				System.out.print(">>");
				String choice = input.nextLine();
				if(choice.equals("1")){}//end if
				else if(choice.equals("2")){
					
				}//end elif
				else if(choice.equals("0")){
					break;
				}//end elif
				else{
					System.out.println("!!!INVALID OPTION!!!");
				}//end else
			}//end for
		}//end if	
	}//end search
}//end class
