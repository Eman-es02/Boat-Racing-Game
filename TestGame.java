import java.util.Scanner;

public class TestGame {

	public static void main(String[] args) {
		
		boolean playgame = true;
		Scanner keyboard = new Scanner(System.in);
		String choice;
		
		System.out.println("\n\n\n_______WELCOME TO JAVA BOAT RACING GAME________\n\n\n");
		
		while (playgame) {
		
			System.out.println("_____________________________________________________________________________________________________________________");
			System.out.println("MAIN MENU");
			System.out.print("\n[1] to play game \n[2] to show leaderboard \n[3] to exit game\n");
			System.out.println("_____________________________________________________________________________________________________________________");
			System.out.print("Enter your choice:");
			choice = keyboard.next();
		
		if (choice.equals("1")) {
			
		Game g = new Game();
		g.runGame();
		}
		
		else if(choice.equals("2")) {
			
			Score.readScores();

			
		}
		
		else if(choice.equals("3")){
			
			System.out.println("\n\n\n\n\n_____Thanks for playing_____");
			playgame = false;

		}
		
		
		
		else {
			
			System.out.println("Invalid Input, Please choose 1,2, or 3 only:");
			
		}
		
		}
	}

}
