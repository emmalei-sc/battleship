package battleship;

import java.util.ArrayList;
import java.util.List;

//Part of the Match Class
public class Ship {
	private List<Position> tiles;
	
	public Ship() {
		tiles = new ArrayList<Position>();
	}
	
	public List<Position> getTiles(){
		return tiles;
	}
	
	public void addTile() {
		
	}
}
