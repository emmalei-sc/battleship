package battleship;

public class UserThread extends Thread{
	String username;
	String password;
	int wins;
	int losses;
	public UserThread() {
		
	}
	public UserThread(String un, String pw, int w, int l) {
		username = un;
		password = pw;
		wins = w;
		losses = l;
	}
	public void run()
	{
		
	}
}
