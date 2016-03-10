import java.util.InputMismatchException;
import java.util.Scanner;
public class Player {
	String player;
	
	public Player(String player){
		this.player = player;
	}
	
	public void TakeMatchStick(GamePlay nim){
	try{
		Scanner scan = new Scanner(System.in);
		System.out.println("Available Match: "+ nim.matchSticks);
		System.out.println("Take [1], [2], [3]");
		int take = scan.nextInt();
		nim.matchSticks -=take;
		nim.MatchStickCounter(nim.matchSticks);
	}
	catch(InputMismatchException e){
		System.out.println("Invalid item");
		TakeMatchStick(nim);
	}
	}
	
	
	
	
	
}
