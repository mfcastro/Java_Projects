import java.util.Scanner;
import java.util.Random;

public class GamePlay {
	int matchSticks =17;
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	boolean Player1GoesFirst = false;
	boolean Player2GoesFirst = false;
	boolean ComputerGoesFirst = false;
	boolean Player1Turn = true;
	boolean Player2Turn = false;
	boolean computerTurn = false;
	boolean isFirstMove = true;
	
	/*public GamePlay(int matchSticks){
		this.matchSticks = matchSticks;
	}*/

	public void MatchStickCounter(int matchSticksLeft){
		matchSticks = matchSticksLeft;
	}

	public void PVPGameTurns(Player player1, Player player2, GamePlay nim){
		
		PVPWhoGoesFirst();
		
		if(Player1GoesFirst){
			while(matchSticks > 1){
				System.out.print("Player 1: ");
				player1.TakeMatchStick(nim);
				TurnSwicher();
				
				System.out.print("Player 2: ");
				player2.TakeMatchStick(nim);
				TurnSwicher();
				
			}
			System.out.println("Player Wins!");
			PrintWhoWins();
		}
		else if(Player2GoesFirst){
		while(matchSticks > 1){
			System.out.print("Player 2: ");
			player2.TakeMatchStick(nim);

			System.out.print("Player 1: ");
			player1.TakeMatchStick(nim);
		}
		System.out.println("Player Wins!");
		PrintWhoWins();
		}


	}

	public void GameMenu(Player player1, Player player2, GamePlay nim, Computer computer){
		String[] gameMode = {"[1] Player vs Player (Subsitution Game)",
				"[2] Player vs Computer (Subsitution Game)",
				"[3] Player vs Computer (Substituation Game: Computer Always wins)",
				"[4] Player vs Computer (Classical Game)",
				"[5] Game Rules"
		};
		System.out.println("Welcome to Nim");
		System.out.println("Select verison to play");

		for(String option : gameMode){
			System.out.println(option);
		}

		int selection = scan.nextInt();
		GameSelector(selection, player1, player2, nim, computer);
	}

	public void GameSelector(int selection, Player player1, Player player2, GamePlay nim, Computer computer){
		if(selection == 1){
			//Player vs Player
			//nim.matchSticks = 17;
			nim.PVPGameTurns(player1, player2, nim);
		}
		else if(selection == 2){
			//Player vs Computer (Sub Game)
			
			nim.PVCGameTurns(player1, computer, nim);
		}
		else if (selection == 3){
			nim.ComputerAlwaysWinsGameTurns(player1, computer, nim);
		}
		else if (selection == 4){
			System.out.println("Under Dev");
		}
		else if(selection == 5){
			System.out.println("Take 1, 2, or 3 matchsticks. The person who takes the last one losses.");
			System.out.println();
			GameMenu( player1,player2,nim, computer);
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
	
	public boolean PVCWhoGoesFirst(){
		int coinFlip = rand.nextInt(2);

		if(coinFlip == 0){
			System.out.println("Player 1 goes first");
			Player1GoesFirst = true;
			return Player1GoesFirst;
		}
		else if(coinFlip == 1){
			System.out.println("Computer goes first");
			ComputerGoesFirst = true;
			return ComputerGoesFirst;
		}
		else{
			return false;
		}
	}
	
	public void PrintWhoWins(){
		if(Player1Turn){
			System.out.println("Player 2 wins");
		}
		else if (Player2Turn){
			System.out.println("Player 1 wins;");
		}
	}
	
	public void TurnSwicher(){
		if(Player1Turn && !Player2Turn){
			Player1Turn = false;
			Player2Turn = true;
		}
		else if(!Player1Turn && Player2Turn){
			Player1Turn = true;
			Player2Turn = false;
		}
	}
	
	public void PVCTurnSwitcher(){
		if(Player1Turn && !computerTurn){
			Player1Turn = false;
			computerTurn = true;
		}
		else if(!Player1Turn && computerTurn){
			Player1Turn = true;
			computerTurn = false;
		}
	}
	
	public void ComputerPrintWhoWins(){
		if(Player1Turn){
			System.out.println("Computer wins");
		}
		else if (computerTurn){
			System.out.println("Player 1 wins");
		}
	}
	
	
	
	
	
public void PVCGameTurns(Player player1, Computer computer, GamePlay nim){
		
		PVCWhoGoesFirst();
		
		if(Player1GoesFirst){
			while(matchSticks > 1){
				System.out.print("Player 1: ");
				player1.TakeMatchStick(nim);
				PVCTurnSwitcher();
				
				System.out.print("Computer: ");
				computer.TakeMatchStick(nim);
				PVCTurnSwitcher();
			}
			System.out.println("Player Wins!");
			//PrintWhoWins();
		}
		else if(ComputerGoesFirst){
		while(matchSticks > 1){
			System.out.print("Computer: ");
			computer.TakeMatchStick(nim);

			System.out.print("Player 1: ");
			player1.TakeMatchStick(nim);
		}
		System.out.println("Player Wins!");
		//PrintWhoWins();
		}

	}


public void ComputerAlwaysWinsGameTurns(Player player1, Computer computer, GamePlay nim){
	
	PVCWhoGoesFirst();
	
	if(Player1GoesFirst){
		while(matchSticks > 1){
			System.out.print("Player 1: ");
			player1.TakeMatchStick(nim);
			PVCTurnSwitcher();
			
			System.out.print("Computer: ");
			computer.AlwaysWInTakeMatchStick(nim, player1);
			PVCTurnSwitcher();
		}
		//System.out.println("Player Wins!");
		ComputerPrintWhoWins();
	}
	else if(ComputerGoesFirst){
	while(matchSticks > 1){
		System.out.print("Computer: ");
		computer.GoFirstAlwaysWInTakeMatchStick(nim, player1);

		System.out.print("Player 1: ");
		player1.TakeMatchStick(nim);
	}
	//System.out.println("Player Wins!");
	ComputerPrintWhoWins();
	}

}


}
