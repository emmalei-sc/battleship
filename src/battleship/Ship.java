package battleship;

import java.util.ArrayList;
import java.util.List;

//Part of the Match Class
public class Ship {
	// Position 0 is leftmost or topmost tile
	private List<Position> tiles;
	
	boolean alive;
	boolean orientation; // 0 - vertical, 1 - horizontal
	private int length;
	private int health;
	
	public Ship() {
		tiles = new ArrayList<Position>();
		alive = true;
	}
	
	public List<Position> getTiles(){
		return tiles;
	}
	
	public void addTile(Position pos) {
		tiles.add(pos);
	}
	
	public void hitShip() {
		health--;
		if (health <= 0)
			alive = false;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setShipLength(int len) {
		length = len;
	}
	
	public int getShipLength() {
		return length;
	}
}
