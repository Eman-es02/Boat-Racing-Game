import java.util.ArrayList;


public class River{
	
	private ArrayList <RiverObject> rcolumn = new ArrayList <RiverObject>();// contains list of all RiverObjects
	protected static ArrayList <Trap> trapList = new ArrayList <Trap>(); //contains list of traps for checking
	protected static ArrayList <Current> currentList = new ArrayList <Current>();//contains list of currents for checking
	//private ArrayList<Boat> boatList = new ArrayList<Boat>();
	private Boat boat1;
	private Boat boat2;
	private Current current;
	private Trap trap;
	

	

	public River(Boat b1, Boat b2) { // constructs a river object
		
		rcolumn.clear(); //clears all previous river objects
		currentList.clear();//clears all previous current objects
		trapList.clear();//clears all previous trap objects
		
		boat1 = b1;
		boat2 = b2;
		
		rcolumn.add(boat1);
		rcolumn.add(boat2);
		
		Current.setCurrentCount(); // sets the number of currents present in the river
		Trap.setTrapCount();// sets the number of traps present in the river

		
		for( int i = 0; i<= Current.getCurrentCount(); i++) { //creates currents for the river based on the game mode
		
			current = new Current();
			rcolumn.add(current);
			currentList.add(current);
		
		
		
		}
		
		
		for( int i = 0; i<= Trap.getTrapCount(); i++) { //creates traps for the river based on the game mode
			
				trap = new Trap();
				rcolumn.add(trap);
				trapList.add(trap);

		}
		
		
	}
	
	public void display() { // displays the player position, river, traps, currents, boats
		
		
		System.out.print("\n ");
		
		for (int j = 0; j<=103;j++) { //prints top river track
			
			System.out.print("=");
		}
		
		System.out.print("\n");
		
		for (int j = 0; j<=100; j++) {
			
			boolean isObject = false;
			
			for(RiverObject r: rcolumn) {
				
				if (r.getLocation()==j) {
					
					isObject = true;
					
					if(r instanceof Boat) {
						
						if (boat1.getLocation()==boat2.getLocation() && r.equals(boat1)) { //prevents the river from displaying 2 boats in the same position
							
							System.out.print(boat2.getSymbol());
						}
						
						else if(boat1.getLocation() <1 || boat1.getLocation()>100) {//displays boat1 locations to the nearest boundary
							
							if(boat1.getLocation()<1) {
								
								boat1.setLocation(1);
								System.out.print(r.getSymbol());
							}
							
							else {
								
								boat1.setLocation(100);
								System.out.print(r.getSymbol());
							}
							
						}
						
						else if(boat2.getLocation() <1 || boat2.getLocation()>100) {//displays boat2 locations to the nearest boundary
							
							if(boat2.getLocation()<1) {
								
								boat2.setLocation(1);
								System.out.print(r.getSymbol());
							}
							
							else {
								
								boat2.setLocation(100);
								System.out.print(r.getSymbol());
							}
							
						}
						
						
						else if(boat1.getLocation() != boat2.getLocation()) {//displays boats as normal
							
							System.out.print(r.getSymbol());
						}
						
						
					}
					
					else if (r instanceof Trap || r instanceof Current) { //displays the traps and currents on the river
						
						System.out.print(r.getSymbol());
					}
					
						

					}
				
				
					}
			
			if(!isObject) { //creates empty spaces in the river
				
				System.out.print(" ");
			}
			

			
		}
		
		
		
		System.out.print("\n ");
		
		for (int j = 0; j<=103;j++) { //prints bottom river track
			
			System.out.print("=");
		}
		
		System.out.printf("\n	 	%s POSITION: %d/100", Game.player1, boat1.getLocation());  // displays the position of players in words for easy reference
		System.out.printf("		 	%s POSITION: %d/100\n",Game.player2, boat2.getLocation());
		
		System.out.println("\n\n\n");
		

	}
	
	public int checkCurrentHit() { //checks if player is hit by current and returns the strength
		
		int strength = 0;
		for(Current c: currentList) {
			
			if (boat1.getLocation() == c.getLocation() || boat2.getLocation() ==c.getLocation()) {
				
				System.out.printf("\n%s's boat is hit by current, extra %d step(s) moved\n", Game.getRollTurn(), c.getCurrentStrength());
				strength += c.getCurrentStrength();
			}
			
				
				
			}
		return strength;
		}
	
	public int checkTrapHit() { //checks if player is hit by trap and returns the strength
		
		int strength = 0;
		for(Trap t: trapList) {
			
			if (boat1.getLocation() == t.getLocation() || boat2.getLocation() == t.getLocation()) {
				
				System.out.printf("\n%s's boat is hit by trap, moved backwards %d step(s)\n", Game.getRollTurn(), t.getTrapStrength());
				strength += t.getTrapStrength();
			}
			
				
				
			}
		return strength;
		}
	}
	

	
	
	

	