package battleship;

import java.util.ArrayList;
import java.util.List;

enum ShipState
{
	ALIVE,
	DEAD
}

//Part of the Match Class
public class Ship {
	// Position 0 is leftmost or topmost tile
	private List<Position> tiles;
	
	ShipState state;
//	boolean orientation; // 0 - vertical, 1 - horizontal
	
	public Ship() {
		tiles = new ArrayList<Position>();
		state = ShipState.ALIVE;
	}
	
	public List<Position> getTiles(){
		return tiles;
	}
	
	public void addTile(Position pos) {
		tiles.add(pos);
	}
	
	public void setState(ShipState state) {
		this.state = state;
	}
	
	public ShipState getState() {
		return state;
	}
}
