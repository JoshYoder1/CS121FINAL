//Program.java
import java.util.*;
import java.io.*;

public class Program{
	private ArrayList<Venue> Venues = new ArrayList();
	private ArrayList<Venue> Filtered = new ArrayList();
	private Scanner input = new Scanner(System.in);
	private String cityF;
	private String capacityMax;
	private String capacityMin;
	private String genreF;

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
			System.out.println("-----Options-----");
			System.out.println("1) Next");
			System.out.println("2) Add to tour");
			System.out.println("0) Exit");
		}//end elif | Search
		else if(type == 3){
			System.out.println("-----Filters-----");
			System.out.println("1) City");
			System.out.println("2) Capacity");
			System.out.println("3) Genre");
			System.out.println("4) See current filter");
			System.out.println("0) Exit");
		}//end elif | Filters
		else if(type == 4){
			System.out.println("-----City Filters-----");
			System.out.println("Enter first 1 to 3 letters of city. Ex. Mun");
			System.out.println("Enter 4+ letters to remove filter.");
		}//end elif | City FIlter
		else if(type == 5){
			System.out.println("-----Capacity Filters-----");
			System.out.println("Enter Max Capacity then Enter Minimum Capacity.");
			System.out.println("Enter letters to remove filter.");
		}//end elif | Capacity Filter
		else if(type == 6){
			System.out.println("-----Genre Filters-----");
			System.out.println("Enter any single genre. Ex. HipHop");
			System.out.println("Enter 0 to remove filter");
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
				setFilter();
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

	public void setFilter(){
		boolean keepGoing = true;
		while(keepGoing){
			menu(3);
			System.out.print(">>");
			String choice = input.nextLine();
			if(choice.equals("1")){
				boolean keepCity = true;
				while(keepCity){
					menu(4);
					System.out.print(">>>");
					choice = input.nextLine();
					if(choice.length() <= 3){
						cityF = choice;
					}//end if
					else{
						System.out.println("!!Removing City Filter!!");
						cityF = null;
					}//end else
					keepCity = false;
				}//end while
			}//end if
			else if(choice.equals("2")){
				boolean keepCapa = true;
				while(keepCapa){
					menu(5);
					System.out.print("Max>>>");
					choice = input.nextLine();
					try{
						if(Integer.valueOf(choice) > -99999){
							capacityMax = choice;
						}//end if
						else{
							System.out.println("!!!INVALID OPTION!!!");
							System.out.println("!!Removing Max Filter!!");
							capacityMax = null;
						}//end else
					} catch(Exception e){
						System.out.println("!!Removing Max Filter!!");
						capacityMax = null;
					}//end try
					System.out.print("Min>>>");
					choice = input.nextLine();
					try{
						if(Integer.valueOf(choice) > -99999){
							capacityMin = choice;
						}//end if
						else{
							System.out.println("!!!INVALID OPTION!!!");
							System.out.println("!!Removing Min Filter!!");
							capacityMin = null;
						}//end else
					} catch(Exception e){
						System.out.println("!!Removing Min Filter!!");
						capacityMin = null;
					}//end try
					keepCapa = false;
				}//end while
			}//end elif
			else if(choice.equals("3")){
				menu(6);
				System.out.print(">>>");
				choice = input.nextLine();
				if(choice.equals("0")){
					System.out.println("!!Removing Genre Filter!!");
					genreF = null;
				}//end if
				else{
					genreF = choice;
				}//end else
			}//end elif
			else if(choice.equals("4")){
				System.out.println("-----Filters-----");
				System.out.println("City: " + cityF);
				System.out.println("Max Capacity: " + capacityMax);
				System.out.println("Min Capacity: " + capacityMin);
				System.out.println("Genre: " + genreF);
				System.out.println("--------------------");
				System.out.print("ENTER TO CONTINUE");
				String x = input.nextLine();
			}//end elif
			else if(choice.equals("0")){
				System.out.println("Applying Filters...");
				Filtered.clear();
				if(cityF != null){
					for(Venue venue : Venues){
						if(venue.getCity().toLowerCase().startsWith(cityF.toLowerCase())){
							Filtered.add(venue);
						}//end if
					}//end for
				}//end if
				for(Venue venue : Filtered){
					System.out.println(venue.getCity());
				}//end for
				keepGoing = false;
				if(capacityMax != null){
					if(Filtered.size() == 0){
						for(Venue venue : Venues){
							if(venue.getCapacity().equals("N/A")){}
							else if(Integer.valueOf(venue.getCapacity()) < Integer.valueOf(capacityMax)){
								Filtered.add(venue);
							}//end elif
							else{}
						}//end for
					}//end if
					else{
						int counter = 1;
						for(Venue venue : Filtered){
							if(venue.getCapacity().equals("N/A")){}
								else if(Integer.valueOf(venue.getCapacity()) > Integer.valueOf(capacityMax)){
									Filtered.remove(counter);
								}//end if
							else{}
							counter = counter + 1;
						}//end for
					}//end else
				}//end if
				if(capacityMin != null){
					if(Filtered.size() == 0){
						for(Venue venue : Venues){
							if(venue.getCapacity().equals("N/A")){}
							else if(Integer.valueOf(venue.getCapacity()) < Integer.valueOf(capacityMin)){
								Filtered.add(venue);
							}//end elif
							else{}
						}//end for
					}//end if
					else{
						int counter = 1;
						for(Venue venue : Filtered){
							if(venue.getCapacity().equals("N/A")){}
								else if(Integer.valueOf(venue.getCapacity()) > Integer.valueOf(capacityMin)){
									Filtered.remove(counter);
								}//end elif
							else{}
							counter = counter + 1;
						}//end for
					}//end else
				}//end if
				for(Venue venue : Filtered){
					System.out.println(venue.getCapacity());
				}//end for
			}//end elif
			else{
				System.out.println("!!!INVALID OPTION!!!");
			}//end else
		}//end while
	}//end setFilter

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
