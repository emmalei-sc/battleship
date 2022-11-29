package battleship;

public class Guess extends Position {
	
	enum State 
	{
		HIT,
		MISS,
		NONE
	}
	State state = State.NONE;

	public Guess(int x, int y) {
		super(x, y);
	}
	
	// Match will detect if the guess hit or missed a ship
	public void setState(State state) {
		this.state = state;
	}
}
