package wismann.filmquiz.dk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {
	private ArrayList<Player> players;
	private Map<Category, List<Question>> questions;
	private int turn;
	
	public Game(int players) {
		
		this.players = new ArrayList<Player>();
		for (int i=1; i<=players; i++) {
			this.players.add(new Player(i));
		}
		
		this.questions = Question.getAllQuestions();
		turn = 1;
	}
	
	public int throwDice() {
		int minimum = 1;
		int maximum = 2;
		return minimum + (int)(Math.random()*maximum);
	}
	
	public Question getRandomQuestion(int dice) {
		Category category = null;
		switch (dice) {
			case 1:
				category = Category.NAVNE;
				break;
			case 2: 
				category = Category.STEDER;
				break;
			default:
				break;
		}
		
		ArrayList<Question> questionsFromCategory = (ArrayList<Question>) questions.get(category);
		int minimum = 0;
		int maximum = questionsFromCategory.size();
		int random = minimum + (int)(Math.random()*maximum);
		
		// Save question
		Question question = questionsFromCategory.get(random);
		// Remove it from the list
		questions.get(category).remove(random);
		// return it
		return question;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public void nextTurn() {
		if(turn < players.size()) {
			turn++;
		}
		else {
			turn = 1;
		}
	}
	
	

	
	

	
	
	
	
	
}
