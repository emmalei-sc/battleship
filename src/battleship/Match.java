package battleship;

//Part of the Server Class
public class Match {
	private List<Ship> p1Ships;
	private List<Ship> p2Ships;
	private List<List<bool>> p1ShipLocations;
	private List<List<bool>> p2ShipLocations;
	private List<List<bool>> p1HitLocations;
	private List<List<bool>> p2HitLocations;
	private UserThread p1;
	private UserThread p2;
	
	
	public Match(UserThread p1, UserThread p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	//returns 1 if player 1 wins, 2 if player 2 wins
	//this is the only method the server should directly call
	public int start() {
		return shipPlacement();
	}
	public int shipPlacement() {
		//randomly assign ships
		return battle();
	}
	
	public int battle() {
		while (true) { //return once someone wins
			//p1 goes
			//p2 goes (identical code as p1)
		}
	}
}
