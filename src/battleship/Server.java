package battleship;

import java.util.LinkedList;
import java.util.Queue;
import java.net.*;
import java.util.*;
import java.io.*;

//The main class for the backend
public class Server extends Thread {
// Should this be a servlet instead?
	
	Queue<UserThread> users;
	public Server(int port) {
		users = new LinkedList<>();
		this.start();
		Match m;
		while (true) {
			if (users.size() >= 2) {
				m = new Match(users.remove(), users.remove());
			}
			//update database
		}
	}
	
	public static void main(String[] args) {
		Server s = new Server(3456);
	}
	
	public synchronized void addUser(UserThread user) {
		users.add(user);
	}
	
	public void run() {
		while (true) {
			//listen for new users connecting, verify them, continually add them to the queue as UserThreads
		}
	}
}
