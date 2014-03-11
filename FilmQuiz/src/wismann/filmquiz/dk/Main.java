package wismann.filmquiz.dk;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) throws IOException {
		Loader.Load();
		
		System.out.println("Welcome. Enter number of players: ");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		int amountOfPlayers = Integer.parseInt(input);
		System.out.println("Welcome. Enter number of rounds: ");
		input = reader.nextLine();
		int amountOfRounds = Integer.parseInt(input);
		Game game = new Game(amountOfPlayers, amountOfRounds*amountOfPlayers);
		
		
		System.out.println("Game started");
		
		while (game.getTurn() <= game.getGameLength()) {
			
			if (game.getTurn() == game.getGameLength()) {
				System.out.println("Last turn");
			}
			
		
			System.out.println("Player" + game.getTurn() + "'s turn...");
			System.out.println("Press enter to throw dice...");
			
			input = reader.nextLine();
			
			int diceThrow = game.throwDice();
			System.out.println("You rolled:" + diceThrow);
			Question q = game.getRandomQuestion(diceThrow);
			System.out.println("Category: "+ q.getCategory().toString());
			System.out.println("Questions: ");
			System.out.println(q.getQuestion());
			
			System.out.println("Options:" );
			System.out.println("a: "+ q.getOptions().get(0));
			System.out.println("b: "+ q.getOptions().get(1));
			System.out.println("c: "+ q.getOptions().get(2));
			System.out.println("d: "+ q.getOptions().get(3));
			System.out.println("Enter answer: ");
			
			String answer = null;
			
			input = reader.nextLine();
			switch (input) {
			case "a":
				answer = q.getOptions().get(0);
				break;
			case "b":
				answer = q.getOptions().get(1);
				break;
			case "c":
				answer = q.getOptions().get(2);
				break;
			case "d":
				answer = q.getOptions().get(3);
				break;
			
			}
			
			if (game.AnswerQuestion(q, answer)) {
				System.out.println("Ya. Correct! You've just earned one point");
			}
			else {
				System.out.println("WRONG. Answer is " + q.getAnswer());
			}
			
			System.out.println("Standing is:");
			for(Player p : game.getPlayers()) {
				System.out.println("Player " +  p.getId() + ": " + p.getPoints() );
			}
		}
		
		System.exit(0);
	}
}
