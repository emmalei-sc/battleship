package battleship;

public class UserThread extends Thread{
	
	private String username;
	private String password;
	private int wins = 0;
	private int losses = 0;
	private int ties = 0;
	private int shipsSunk = 0;
	private int shipsLost = 0;
	
	public UserThread() {
		
	}
	
	public UserThread(String username, String pw) {
		this.username = username;
		this.password = password;
	}
	
	public UserThread(String username, String pw, int wins, int losses, int ties, int shipsSunk, int shipsLost) {
		this.username = username;
		this.password = password;
		this.wins = wins;
		this.losses = losses;
		this.ties = ties;
		this.shipsSunk = shipsSunk;
		this.shipsLost = shipsLost;
	}
	
	public UserThread(String username, String pw, int wins, int losses) {
		this.username = username;
		this.password = pw;
		this.wins = wins;
		this.losses = losses;
	}
	
	public void addShipsSunk(int sunk) {
		shipsSunk += sunk;
	}
	
	public void addShipsLost(int lost) {
		shipsLost += lost;
	}
	
	public void addWin() {
		wins++;
	}
	
	public void addLoss() {
		losses++;
	}
	
	public void addTie() {
		ties++;
	}
	
	public void run()
	{
		while (true) {
			// Might have to catch a message to indicate when it's this player's turn?
		}
	}
}
