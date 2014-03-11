package wismann.filmquiz.dk;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	
	public static void main(String args[]) throws IOException {
		Loader.Load();
		Game game = new Game(2);
		System.out.println("Game started");
		System.out.println("Player" + game.getTurn() + "'s turn...");
		System.out.println("Press any key to throw dice...");
		System.in.read();
		int diceThrow = game.throwDice();
		System.out.println("You rolled:" + diceThrow);
		Question q = game.getRandomQuestion(diceThrow);
		System.out.println("Category: "+ q.getCategory().toString());
		System.out.println("Questions: ");
		System.out.println(q.getQuestion());
		
		System.out.println("Options:" );
		System.out.println("A: "+ q.getAnswer());
		System.out.println("B: "+ q.getOptions().get(0));
		System.out.println("C: "+ q.getOptions().get(1));
		System.out.println("D: "+ q.getOptions().get(2));
		System.out.println("Enter answer: ");
		
		switch (System.in.read()) {
		case 'a':
			
		}
		
		
		System.exit(0);
	}
}
