package com.dss.demo.simple.server;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.frontend.ServerFactoryBean;

import com.dss.demo.ProjectManager;
import com.dss.demo.server.ProjectManagerImpl;

public class ServerFactoryServer {

	public ServerFactoryServer() {
		ProjectManager mgr = new ProjectManagerImpl();
		ServerFactoryBean factory = new ServerFactoryBean();
		
		factory.setServiceClass(ProjectManager.class);
		factory.setAddress("http://localhost:9000/ProjectManager");
		factory.setServiceBean(mgr);
		
		Server svr = factory.create();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ServerFactoryServer svr = new ServerFactoryServer();
		System.out.println("ServerFactoryBean Server ready...");
		
		Thread.sleep(1 * 60 * 1000);
		
		System.out.println("ServerFactoryBean Server exiting...");
		System.exit(0);
	}

}
