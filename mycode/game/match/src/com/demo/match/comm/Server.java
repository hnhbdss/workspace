package com.demo.match.comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.demo.match.common.CloseUtils;
import com.demo.match.common.VisiableException;

public class Server {

	private Thread acceptThread = null;
	private MessageProcessor processor = new MessageProcessor();

	public void start(final int port) {
		
		acceptThread = new Thread() {
			public void run() {
				ServerSocket server = null;
				Socket client = null;
				try {
					server =  new ServerSocket(port);
					client = server.accept();
					Server.this.accept(client);
				}
				catch(IOException e) {
					throw new VisiableException(e);
				}
				finally {
					CloseUtils.closeQuietly(server);
					CloseUtils.closeQuietly(client);
				}
			}
		};
		acceptThread.start();
	}

	public void close() {
		if (acceptThread != null) {
			acceptThread.interrupt();
		}
	}
	
	private void accept(Socket client) throws VisiableException {
		try { 
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			processor.process(reader);
		}
		catch(Exception e) {
			throw new VisiableException(e);
		}
	}
}
