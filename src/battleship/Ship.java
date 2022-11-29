package battleship;

import java.util.ArrayList;
import java.util.List;

enum State
{
	ALIVE,
	DEAD
}

//Part of the Match Class
public class Ship {
	// Position 0 is leftmost or topmost tile
	private List<Position> tiles;
	
	State state;
//	boolean orientation; // 0 - vertical, 1 - horizontal
	
	public Ship() {
		tiles = new ArrayList<Position>();
		state = State.ALIVE;
	}
	
	public List<Position> getTiles(){
		return tiles;
	}
	
	public void addTile() {
		
	}
	
	public void setState(State state) {
		this.state = state;
	}
}
