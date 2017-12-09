package com.dss.demo.server;

import javax.xml.ws.Endpoint;

public class Server {

	public Server() {
		System.out.println("Starting Server...");
		ProjectManagerImpl impl = new ProjectManagerImpl();
		String address = "http://localhost:9000/ProjectManager";
		Endpoint.publish(address, impl);
	}
	public static void main(String[] args) throws Exception{
		
		new Server();
		
		System.out.println("Server ready ...");
		
		Thread.sleep(5 * 60 * 1000);
		System.out.println("Server exiting...");
		System.exit(0);

	}

}
