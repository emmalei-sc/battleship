package battleship;

enum GuessState 
{
	HIT,
	MISS,
	NONE
}

public class Guess extends Position {
	
	GuessState state = GuessState.NONE;

	public Guess(int x, int y) {
		super(x, y);
	}
	
	// Match will detect if the guess hit or missed a ship
	public void setState(GuessState state) {
		this.state = state;
	}
	
	public GuessState getState() {
		return state;
	}
}
