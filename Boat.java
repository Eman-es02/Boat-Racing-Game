
public class Boat extends RiverObject{// Boat is a RiverOject
	
	private String name;
	private static int boatTurn = 0;
	
	
	public Boat(String s, int l, String n) { // constructor for boat
		
		super();
		setSymbol(s);
		setLocation(l);
		setName(n);
	}
	
	public void setName(String n) { //set the name of the boat
		
		name = n;
	}
	
	public String getName() { // returns the name of the boat
		
		return name;
	}
	
	
	
	public static void addTurn() { // increases the boatTurn variable to be used in the game logic
		
		boatTurn++;
	}
	
	public static int getPlayerTurn() { // returns the turn of the player to be used in the game logic 
		
		if (boatTurn % 2 == 0) {
		return 1;
	}
		else return 2;
	}
	
	
	
	
	

}
