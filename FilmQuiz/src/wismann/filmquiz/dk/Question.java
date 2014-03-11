package wismann.filmquiz.dk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Question {
	private String question;
	private String answer;
	private Category category;
	private ArrayList<String> options;
	
	private static Map<Category, List<Question>> QUESTIONS;
	
	public Question(String question, String answer, ArrayList<String> extraAnswers, Category category) {
		this.question = question;
		this.category = category;
		this.answer = answer;
		this.options = extraAnswers;
		addAnswerToOptions();
		
		addQuestion(this);
	}
	
	private void addAnswerToOptions() {
		int minimum = 0;
		int maximum = options.size();
		int random = minimum + (int)(Math.random()*maximum);
		
		// Insert the answer at random position
		options.add(random, answer);
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	// Gets all questions with given category
	public static List<Question> getQuestionsWithCategory(Category category) {
		return QUESTIONS.get(category);
	}
	
	public static Map<Category, List<Question>> getAllQuestions() {
		return QUESTIONS;
	}

	// Adds a question
	public static void addQuestion(Question question) {
		// Checks if there's a list with questions for given category.
		if (QUESTIONS == null) {
			QUESTIONS = new TreeMap<Category, List<Question>>();
		}
		if (!QUESTIONS.containsKey(question.category)) {
			ArrayList<Question> questionList = new ArrayList<Question>();
			questionList.add(question);
			QUESTIONS.put(question.category, questionList);
		}
		
		else {
			QUESTIONS.get(question.category).add(question);
		}
	}

	public ArrayList<String> getOptions() {
		return options;
	}

	
	
}
