package battleship;

public class Guess extends Position {
	
	boolean hit = false;

	public Guess(int x, int y) {
		super(x, y);
	}
	
	// Match will detect if the guess hit or missed a ship
	public void setHitState(boolean hit) {
		this.hit = hit;
	}
	
	public boolean getHitState() {
		return hit;
	}
}
