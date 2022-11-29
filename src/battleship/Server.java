package battleship;

import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.http.HttpServlet;

import java.net.*;
import java.util.*;
import java.io.*;

//The main class for the backend
public class Server extends HttpServlet {
// Should this be a servlet instead?
	Queue<UserThread> users;
	boolean isMatchRunning = false;
	public Server(int port) {
		users = new LinkedList<>();
		Match m;
		while (true) {
			//listen for new users connecting, verify them, continually add them to the queue as UserThreads
			if (!isMatchRunning && users.size() >= 2) {
				m = new Match(users.remove(), users.remove());
				isMatchRunning = true;
			}
			//update database
		}
	}
	
	public static void main(String[] args) {
		Server s = new Server(3456);
	}
	
	public void UpdateMatchStatus(boolean status) {
		isMatchRunning = status;
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
