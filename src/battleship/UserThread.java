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
	
	public UserThread(String username, String pw, int wins, int losses, int shipsSunk, int shipsLost) {
		this.username = username;
		this.password = password;
		this.wins = wins;
		this.losses = losses;
		this.shipsSunk = shipsSunk;
		this.shipsLost = shipsLost;
	}
	
	public void run()
	{
		
	}
}
