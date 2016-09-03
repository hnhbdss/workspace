package com.demo.match.board;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import com.demo.match.common.ChessColor;
import com.demo.match.common.CloseUtils;
import com.demo.match.common.VisiableException;

public class MatchClientSocketPeer {

	private Socket socket;
	private ChessColor color;
	public MatchClientSocketPeer(Socket socket, ChessColor color) {
		this.socket = socket;
		this.color = color;
	}
	
	public void start() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = null;
			while((message = reader.readLine()) != null && !message.isEmpty()) {
				
			}
		}
		catch(Exception e) {
			System.err.println("catch exception when start MatchClientSocketPeer:" + e.getMessage());
			throw new VisiableException(e);
		}
		finally {
			CloseUtils.closeQuietly(socket);
		}
	}
}
