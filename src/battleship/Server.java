package battleship;

import java.util.LinkedList;
import java.util.Queue;
import java.sql.*;

import javax.servlet.http.HttpServlet;

import java.net.*;
import java.util.*;
import java.io.*;

//The main class for the backend
public class Server extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8370850669362836525L;
	ServerSocket server;
	Socket socket;
	Queue<UserThread> users;
	boolean isMatchRunning = false;
	public Server(int port) {
		users = new LinkedList<>();
		Match m;
		try {
			server = new ServerSocket(port);
			while (true) {
				//listen for new users connecting, verify them, continually add them to the queue as UserThreads
				socket = server.accept();
				InetAddress inetAddress = socket.getInetAddress();
				System.out.println("Connection from IP: " + inetAddress.getHostAddress());
				UserThread newUser = new UserThread(); //TODO
				users.add(newUser);
				if (!isMatchRunning && users.size() >= 2) {
					m = new Match(users.remove(), users.remove());
					isMatchRunning = true;
				}
				//update database
			}
		} catch (IOException e) {
			
		}
	}
	
	public static void main(String[] args) {
		Server s = new Server(3456);
	}
	
	public void UpdateMatchStatus(boolean status) {
		isMatchRunning = status;
	}
	
	public synchronized void addUser(String username) {
		//Please look this function over and ensure the strings match to the database
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		String password = null;
		int wins = 0;
		int losses = 0;
		try {
			Class.forName("conn.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Users?user=root&password=root&useSSL=false");
			ps = conn.prepareStatement("SELECT * FROM Users WHERE userName=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				password = rs.getString("password");
				wins = rs.getInt("wins");
				losses = rs.getInt("losses");
			}
			UserThread newUser = new UserThread(username, password, wins, losses);
			users.add(newUser);
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		
	}
	
	public synchronized void addUser(UserThread user) {
		users.add(user);
	}
	
	/* public void run() {
		while (true) {
			//listen for new users connecting, verify them, continually add them to the queue as UserThreads
		}
	} */
}
