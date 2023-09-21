import java.util.Random;

public class Current extends RiverObject{// Current is a RiverObject
	
	private int currentStrength;
	private static int currentCount;
	
	
	public Current() { //creates a Current object
		
		super();
		setSymbol("C");
		setCurrentStrength();
		Random r = new Random();
		setLocation(r.nextInt(98) + 2); // creates current location between 2-99 only 
		
	}
	
	
	public void setCurrentStrength() { // sets the strength of the current
		
		Random r = new Random();
		
		if (Game.getGameMode() ==1) { //creates stronger currents on easy mode
			
		currentStrength = 1 + r.nextInt(5);
		}
		
		else if(Game.getGameMode() == 2) { //creates weaker currents on hard mode
			
			currentStrength = 1 + r.nextInt(3);
		}
	}
	
	public int getCurrentStrength() { //returns the strength of the current
		
		return currentStrength;
	}
	
	public static void setCurrentCount() { // sets the number of currents in the game based on the game mode
		
		Random r = new Random();
		
		if (Game.getGameMode() == 1) {// creates more currents on easy mode
			
			currentCount =  5 + r.nextInt(10);

		}
		
		else if (Game.getGameMode() == 2) {//creates less currents on hard mode
			
			currentCount = 1 + r.nextInt(5);
		}
	}
	
	public static int getCurrentCount() { //returns the number of currents in the game
		
		return currentCount;
	}
	


	

}
