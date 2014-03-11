package wismann.filmquiz.dk;

public class Player {
	private int id;
	private boolean turn;
	private int points;
	
	public Player (int id) {
		this.id = id;
		this.points = 0;
	}
	
	public int getId(){
		return id;
	}
	
	public boolean isTurn() {
		if (turn) {
			return true;
		}
		return false;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void addPoints(int pointsToAdd) {
		points += pointsToAdd;
	}
}
