import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Computer extends Player{
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	public Computer(String name){
		super(name = "Computer");
	}

	/*public void AlwaysWinGoesFirst(GamePlay nim, Player player1){
		nim.matchSticks = 18;
		AlwaysWInTakeMatchStick(nim, player1);

	}*/
	
	public void AlwaysWInTakeMatchStick(GamePlay nim, Player player1){
		int take = ComputerAlwaysWin(player1);
		System.out.println("Available Match: "+ nim.matchSticks);
		System.out.println("Computer took "+ take);
		System.out.println();
		
			nim.matchSticks -=take;
			nim.MatchStickCounter(nim.matchSticks);

	}
	
	public void GoFirstAlwaysWInTakeMatchStick(GamePlay nim, Player player1){
		int take = ComputerAlwaysWin(player1);
		//nim.matchSticks =18;
		GoFirstAlwaysWinPrintAvailableMatches(nim);
		System.out.println("Computer took "+ take);
		System.out.println();
		
			nim.matchSticks -=take;
			nim.MatchStickCounter(nim.matchSticks);

	}
	
	public void GoFirstAlwaysWinPrintAvailableMatches(GamePlay nim){
		if(nim.isFirstMove){
			System.out.println("Available Match: "+ 17);
			nim.isFirstMove = false;
		}
		else{
			System.out.println("Available Match: "+ nim.matchSticks);
		}
	}
	
	
	public void TakeMatchStick(GamePlay nim){
		int take = rand.nextInt(3) + 1;	
		System.out.println("Available Match: "+ nim.matchSticks);
		System.out.println("Computer took "+ take);
		System.out.println();
			nim.matchSticks -=take;
			nim.MatchStickCounter(nim.matchSticks);
		
	}
	
	public int ComputerAlwaysWin(Player player1){
		int p1Last = player1.lastAmountTaken;
		
		if(p1Last == 1){
			return 3;
		}
		else if(p1Last == 2){
			return 2;
		}
		else if(p1Last == 3){
			return 1;
		}
		return 1;
	}
}
