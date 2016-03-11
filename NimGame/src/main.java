import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class main {

	public static void main(String[] args) {

		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		Computer computer = new Computer("Computer");
		GamePlay nim = new GamePlay();

		nim.GameMenu(player1, player2, nim, computer);
		
		/*
		JFrame frame = new JFrame("Nim Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//turns program off when window is closed.
		frame.setPreferredSize(new Dimension (400,400));
		frame.pack();
		frame.setVisible(true);
		
		JLabel label = new JLabel("Nim Game");
		frame.getContentPane().add(label);
		*/
		

	}

}
