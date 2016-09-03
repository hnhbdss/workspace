package com.demo.match;

import com.demo.match.comm.Server;
import com.demo.match.gui.MainFrame;

public class GUIServer {

	private static final int DEFAULT_PORT = 10000;

	public static void main(String[] args) {
	    GUIServer server = new GUIServer();
	    server.showWindow();
	}

	public void showWindow() {
	    MainFrame frame = new MainFrame();
	    frame.show();
	}
}
