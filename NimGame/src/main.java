import java.util.Random;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		GamePlay nim = new GamePlay(17);
		
		nim.GameMenu(player1, player2, nim);
	
	}

}
