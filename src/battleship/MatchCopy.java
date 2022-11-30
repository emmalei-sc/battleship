package battleship;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MatchCopy {
	
	static final int GRID_LENGTH = 11;
	static final int SHIP_MAX_LENGTH = 5;
	static final int SHIP_MIN_LENGTH = 2;
	
	// Class to contain each player's ships and hits
	class Player {
		
		// Five ships per player
		Ship[] ships = new Ship[5];
		
		// Grid of ship locations
		boolean[][] shipLocations = new boolean[GRID_LENGTH][GRID_LENGTH];
		// Grid of where the player has attempted a hit on the other - 0: none, 1: miss, 2: hit
		int[][] hitLocations = new int[GRID_LENGTH][GRID_LENGTH];
		
		public Player() {
			
		}
	}
	
	private UserThread user1;
	private UserThread user2;
	private Player p1;
	private Player p2;
	private ArrayList<Player> players = new ArrayList<Player>();
	private int result = 0;
	
	public MatchCopy(UserThread u1, UserThread u2) {
		this.user1 = u1;
		this.user2 = u2;
		p1 = new Player();
		p2 = new Player();
		players.add(p1);
		players.add(p2);
	}
	
	//returns 1 if player 1 wins, 2 if player 2 wins
	public int startMatch() {
		placeShips();
		result = battle();
		updateStats();
		return result;
	}
	private void placeShips() {
		//randomly assign ships
		for (Ship ship : p1.ships) {
			int length = ThreadLocalRandom.current().nextInt(SHIP_MIN_LENGTH, SHIP_MAX_LENGTH+1);
			boolean orientation = ThreadLocalRandom.current().nextBoolean();
			int startX;
			int startY;
			
			boolean valid = false;
			do {
				startX = ThreadLocalRandom.current().nextInt(GRID_LENGTH+1);
				startY = ThreadLocalRandom.current().nextInt(GRID_LENGTH+1);
				if (orientation == false) // vertical
				{
					
				} else 
				{
					
				}
				
			} while (!valid);
			
		}
	}
	
	private int battle() {
		while (true) { //return once someone wins
			//p1 goes
			//p2 goes (identical code as p1)
			break;
		}
		return 0;
	}
	
	public void updateStats() 
	{
		// -------- Win Stats ----------
		if (result == 1)
		{
			user1.addWin();
			user2.addLoss();
		}
		else if (result == 2)
		{
			user2.addWin();
			user1.addLoss();
		}
		
		// -------- Ship Stats ----------
		// Player 1
		int p1ShipsSunk = 0;
		// Calculate how many of player TWO's ships died
		for (Ship ship : p2.ships) {
			if (!ship.isAlive())
				p1ShipsSunk++;
		}
		user1.addShipsSunk(p1ShipsSunk);
		user2.addShipsLost(p1ShipsSunk);
		
		// Player 2
		int p2ShipsSunk = 0;
		// Calculate how many of player ONE's ships died
		for (Ship ship : p1.ships) {
			if (!ship.isAlive())
				p2ShipsSunk++;
		}
		user2.addShipsSunk(p2ShipsSunk);
		user1.addShipsLost(p2ShipsSunk);
	}
}
