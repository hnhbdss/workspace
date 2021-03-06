package com.demo.match;

import com.demo.match.board.MatchServerSocket;

public class MatchServer {
			
	private int port;
	private String clientId1;
	private String clientId2;
	public MatchServer(int port, String clientId1, String clientId2) {
		this.port = port;
		this.clientId1 = clientId1;
		this.clientId2 = clientId2;
	}
	
	public static void main(String[] args) {

		if (args.length != 3) {
			System.err.println("Usage: port clientID1 clientID2");
		}
		else {
			MatchServer server = new MatchServer(Integer.valueOf(args[0]).intValue(), args[1], args[2]);
			server.start();
		}
	}

	public void start() {
		try {
			MatchServerSocket server = new MatchServerSocket(port);
			server.start(clientId1, clientId2);
		}
		catch(Exception e) { 
			System.err.println("catch exception when start:" + e.getMessage());
		}
	}
}
