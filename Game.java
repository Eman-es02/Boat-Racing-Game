import java.util.Random;
import java.util.Scanner;

public class Game {

	private int diceNum;
	private static String rollTurn;
	private River river;
	private Boat boat1;
	private Boat boat2;
	private boolean hasWinner;
	private static int gameMode;
	protected static String player1;
	protected static String player2;
	private static int player1Score;
	private static int player2Score;
	private static String winner; 
	private static String winnerScore;
	private boolean gameOver; // variable to keep playing the game
	
	public Game() { //creates a game object
		
		gameOver = false;
		hasWinner = false;
		player1Score = 0;
		player2Score = 0;

		setPlayerName();
		setGameMode();
		boat1 = new Boat("p1",1, player1);
		boat2 = new Boat("p2",1, player2);
		river = new River(boat1, boat2);
		Start();
		
		
	}	
	
	public void rollDice() { //rolls dice for player to move
		
		Random r = new Random();
		diceNum = 1 + r.nextInt(6);
	}
	
	public int getDiceNum() { //returns the dice number
		
		return diceNum;
	}
	
	
	public void Start() { //displays the starting locations of the players
		
		river.display();
	}
	
	public void runGame() {	// runs the game until there is a winner

		while(!checkGameStatus()) {
		
			if (Boat.getPlayerTurn()==1) {
				
				rollTurn = player1;
			}
			else {
				rollTurn= player2;
			}
			
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("%s Press Enter to roll the dice:", rollTurn);
		String input = keyboard.nextLine();
		
		if(input.isBlank() || !input.isBlank()) {
		rollDice();
		System.out.printf("\n%s rolled %d on the dice\n", rollTurn, getDiceNum());
		moveBoat(getDiceNum() + river.checkCurrentHit() - river.checkTrapHit());
		updateScores(getDiceNum()); //score is calculated based on cumulative dice number
		river.display();
		checkWinner();
		
	}
		
		}
		showScore();
		
		Score.createScoreFile();
		Score.writeScore(getWinnerName(), getWinnerScore());
		Score.readScores();
	}
	
	
	public static void setGameMode() { //sets the mode of the game
		
		Scanner keyboard = new Scanner(System.in);
		
		while(true) {
			
		System.out.print("\nChoose Game Mode \n[1] for easy \n[2] for hard \nEnter your choice:");
		String gm = keyboard.next();
		
		if(gm.equals("1") || gm.equals("2")) {
			
		gameMode = Integer.parseInt(gm);
		break;
		}
		
		else {
			System.out.println("\nInvalid choice, please choose 1 or 2 only:");
			continue;
		}
		
	}
		
	}
	
	public static int getGameMode() { //returns the game mode
		
		return gameMode;
	}
	
	public static void setPlayerName() { // sets the name of the players
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Set Player 1 (p1) Name:");
		player1 = keyboard.next().trim();
		System.out.print("Set Player 2 (p2) Name:");
		player2 = keyboard.next().trim();
		
	}
	
	public static String getRollTurn() { // gets the name of the player who's current turn it is
		
		return rollTurn;
	}
	
	public  boolean checkGameStatus() { //checks if the game over and returns true or false
		
		if(hasWinner) {
			
		gameOver = true;
		
		}
		else {
			gameOver = false;
		}
			
		return gameOver;
	}
	
	
	
	public int moveBoat(int steps) { // moves the boats based on the player turn
		
		int s = 0;
		if(Boat.getPlayerTurn() == 1) {
			
			rollTurn = player1;
			s += steps;
			boat1.setLocation( boat1.getLocation() + steps);
		}
		
		else {
			
			rollTurn = player2;
			s += steps;
			boat2.setLocation(boat2 .getLocation()+steps);
		}
		
		Boat.addTurn();
		return s;
	}
	
	
	public void updateScores(int score) {
		
		
		if (Boat.getPlayerTurn() == 1){
		
		player1Score += score;
		}
		
		else {
			player2Score +=score;
	}
		

		
	}
	
	public void showScore() { //displays the name and score of the winner
		
		System.out.printf("\n\n%s wins with a score of %s\n", getWinnerName(), getWinnerScore());
	}
	

	public boolean checkWinner() { // checks if any boat has reached the river end and returns true or false
		
		int x= 0;
		
		if (boat1.getLocation() >=100 || boat2.getLocation() >=100) {
			
		if (boat1.getLocation() >=100) {
				
				boat1.setLocation(100);
				System.out.printf("%s IS THE WINNER!!!", boat1.getName());
				setWinnerName(boat1.getName()); //sets boat1 as the winner
				x = (player1Score/2); //calculates winner score using the round score/rounds * 2 (floating point numbers are truncated)
				setWinnerScore(Integer.toString(x)); //sets player 1 score as the winner's score

			}
		
			else {
				
				boat2.setLocation(100);
				System.out.printf("%s IS THE WINNER!!!", boat2.getName());
				setWinnerName(boat2.getName()); //sets boat2 as the winner
				x = (player2Score/2); //calculates winner score using the round score/rounds * 2 (floating point numbers are truncated)
				setWinnerScore(Integer.toString(x)); 
			} 
			
			gameOver = true;
			return hasWinner = true;
		}
		else {
			return hasWinner = false;
		}
	}
	
	public void setWinnerName(String w) { //sets winner name
		
		winner = w;
	}
	
	public void setWinnerScore(String s) { //sets winner score
		
		winnerScore = s;
	}
	
	public String getWinnerName() { //returns winner name
		
		return winner;
	}
	
	public String getWinnerScore() { //return winner score
		
		return winnerScore;	
	}
	
}
