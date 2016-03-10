import java.util.Scanner;

public class Computer extends Player{
	Scanner scan = new Scanner(System.in);
	
	public Computer(String name){
		super(name = "Computer");
	}

	public void AlwaysWinGoesFirst(GamePlay nim){
		nim.matchSticks = 18;
		AlwaysWInTakeFirstMatchStick(nim);

	}
	
	public void AlwaysWInTakeFirstMatchStick(GamePlay nim){
		System.out.println("Available Match: "+ nim.matchSticks);
		System.out.println("Take [1], [2], [3]");
		int take = scan.nextInt();
		nim.matchSticks -=take;
		nim.MatchStickCounter(nim.matchSticks);

	}
}
