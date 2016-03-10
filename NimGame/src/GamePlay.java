import java.util.Scanner;
import java.util.Random;

public class GamePlay {
	int matchSticks;
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	boolean Player1GoesFirst = false;
	boolean Player2GoesFirst = false;

	public GamePlay(int matchSticks){
		this.matchSticks = matchSticks;
	}

	public void MatchStickCounter(int matchSticksLeft){
		matchSticks = matchSticksLeft;
	}

	public void GameTurns(Player player1, Player player2, GamePlay nim){
		
		PVPWhoGoesFirst();
		
		if(Player1GoesFirst){
			while(matchSticks > 1){
				System.out.print("Player 1: ");
				player1.TakeMatchStick(nim);

				System.out.print("Player 2: ");
				player2.TakeMatchStick(nim);
			}
			System.out.println("Player Wins!");
		}
		else if(Player2GoesFirst){
		while(matchSticks > 1){
			System.out.print("Player 2: ");
			player2.TakeMatchStick(nim);

			System.out.print("Player 1: ");
			player1.TakeMatchStick(nim);
		}
		System.out.println("Player Wins!");
		}
		/*while(matchSticks > 1){
			System.out.print("Player 1: ");
			player1.TakeMatchStick(nim);

			System.out.print("Player 2: ");
			player2.TakeMatchStick(nim);
		}
		System.out.println("Player Wins!");*/


	}

	public void GameMenu(Player player1, Player player2, GamePlay nim){
		String[] gameMode = {"[1] Player vs Player (Subsitution Game)",
				"[2] Player vs Computer (Subsitution Game)",
				"[3] Player vs Computer (Classical Game)",
				"[4] Game Rules"
		};
		System.out.println("Welcome to Nim");
		System.out.println("Select verison to play");

		for(String option : gameMode){
			System.out.println(option);
		}

		int selection = scan.nextInt();
		GameSelector(selection, player1, player2, nim);
	}

	public void GameSelector(int selection, Player player1, Player player2, GamePlay nim){
		if(selection == 1){
			//Player vs Player
			nim.matchSticks = 17;
			nim.GameTurns(player1, player2, nim);

		}
		else if(selection == 2){
			//Player vs Computer (Sub Game)

		}
		else if (selection == 3){

		}
		else if(selection == 4){
			System.out.println("Take 1, 2, or 3 matchsticks. The person who takes the last one losses.");
			System.out.println();
			GameMenu( player1,player2,nim);
		}
		else{
			System.out.println("Invalid entry");

		}
	}

	public boolean PVPWhoGoesFirst(){

		int coinFlip = rand.nextInt(2);

		if(coinFlip == 0){
			System.out.println("Player 1 goes first");
			Player1GoesFirst = true;
			return Player1GoesFirst;
		}
		else if(coinFlip == 1){
			System.out.println("Player 2 goes first");
			Player2GoesFirst = true;
			return Player2GoesFirst;
		}
		else{
			return false;
		}
	}
}
