package battleship;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MatchCopy {
	
	private static final int GRID_LENGTH = 11;
	
	// Class to contain each player's ships and hits
	class Player {
		
		// 8 ships per player
		// 1 5-squares, 1 4-squares, 1 3-squares, 2 2-squares, 3 1-squares
		Ship[] ships = new Ship[8];
		ArrayList<Integer> shipLengths = new ArrayList<Integer>();
		
		// Grid of ship locations
		boolean[][] shipLocations = new boolean[GRID_LENGTH][GRID_LENGTH];
		// Grid of where the player has attempted a hit on the other - 0: none, 1: miss, 2: hit
		int[][] hitLocations = new int[GRID_LENGTH][GRID_LENGTH];
		
		public Player() {
			// Init ship lengths
			shipLengths.add(5);
			shipLengths.add(4);
			shipLengths.add(3);
			shipLengths.add(2);
			shipLengths.add(2);
			shipLengths.add(1);
			shipLengths.add(1);
			shipLengths.add(1);
			for (int i=0; i<ships.length; i++) {
				ships[i] = new Ship();
				ships[i].setShipLength(shipLengths.get(i));
			}
			// Initialize ship locations to false
			for (int r=0; r<shipLocations.length; r++) {
				for (int c=0; c<shipLocations[r].length; c++) {
					shipLocations[r][c] = false;
				}
			}
			// init hit locations to none
			for (int r=0; r<hitLocations.length; r++) {
				for (int c=0; c<hitLocations[r].length; c++) {
					hitLocations[r][c] = 0;
				}
			}
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
		
		// hard assign ships
		
		
		
		//randomly assign ships
		
//		for (Ship ship : p1.ships) {
////			int length = ThreadLocalRandom.current().nextInt(SHIP_MIN_LENGTH, SHIP_MAX_LENGTH+1);
//			boolean orientation = ThreadLocalRandom.current().nextBoolean();
//			int startX;
//			int startY;
//			
//			boolean valid = false;
//			do {
//				startX = ThreadLocalRandom.current().nextInt(GRID_LENGTH+1);
//				startY = ThreadLocalRandom.current().nextInt(GRID_LENGTH+1);
//				if (p1.shipLocations[startX][startY] == true)
//				{
//					
//				}
//				if (orientation == false) // vertical
//				{
////					if (startX + ship.getShipLength() > GRID_LENGTH)
//				} else // horizontal
//				{
//					
//				}
//				
//			} while (!valid);
//			
//		}
	}
	
	private int battle() {
		while (true) { //return once someone wins
			//p1 goes
			//p2 goes (identical code as p1)
			break;
		}
		return 0;
	}
	
	public int makeGuess(int x, int y, String username) {
		Player current;
		Player other;
		if (user1.getUsername().equals(username)) {
			current = p1;
			other = p2;
		} else {
			current = p2;
			other = p1;
		}
		
		if (other.shipLocations[x][y] == true) { 
			current.hitLocations[x][y] = 2; // hit
		} else {
			current.hitLocations[x][y] = 1; // miss
		}
		return current.hitLocations[x][y];
	}
	
	public void updateStats() 
	{
		// -------- Win Stats ----------
		// String winner = "";
		// String loser = "";
		// boolean tie = false;
		if (result == 1)
		{
			user1.addWin();
			user2.addLoss();
			// winner = user1.getUsername();
			// loser = user2.getUsername();
		}
		else if (result == 2)
		{
			user2.addWin();
			user1.addLoss();
			// winner = user2.getUsername();
			// loser = user1.getUsername();
		}
		else if (result == 0) 
		{
			user1.addTie();
			user2.addTie();
			// tie = true;
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
		
		// Using Database team's function
		// Object ob = new Object();
		// ob.updateStats(winner, loser, tie, shipsHit, shipsLost);
		// uhhhh one call per player?
	}
}
