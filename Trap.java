import java.util.Random;

public class Trap extends RiverObject { //Trap is a RiverObject
	
	private int trapStrength;
	private static int trapCount;
	
	
	public Trap() { //creates a trap object
		
		super();
		setSymbol("#");
		setTrapStrength();
		Random r = new Random();
		setLocation(r.nextInt(98)+2); // creates trap location between 2 - 99 only
		
	}

	public void setTrapStrength() { //sets the strength of the trap
		
		Random r = new Random();
		
		if (Game.getGameMode() ==1) {//creates weaker traps on easy mode
			
		trapStrength = 1 + r.nextInt(3);
		}
		
		else if(Game.getGameMode() == 2) {//creates stronger traps on hard mode
			
			trapStrength = 1 + r.nextInt(5);
		}
	}
	
	public int getTrapStrength() { // returns the strength of the trap
		
		return trapStrength;
	}
	
	public static void setTrapCount() { // sets the number of traps in the game based on the game mode
		
		Random r = new Random();
		
		if (Game.getGameMode() == 1) {//creates less traps on easy mode
			
			trapCount =  1 + r.nextInt(5);

		}
		
		else if (Game.getGameMode() == 2) {//creates more traps on hard mode
			
			trapCount = 5 + r.nextInt(10);
		}
	}
	
	public static int getTrapCount() { //returns the number of traps in the game
		
		return trapCount;
	}
	

	
}


