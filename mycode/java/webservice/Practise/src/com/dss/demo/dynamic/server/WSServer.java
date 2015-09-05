package com.dss.demo.dynamic.server;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.dss.demo.ProjectManager;
import com.dss.demo.server.ProjectManagerImpl;

public class WSServer {

	public WSServer () {
		System.out.println("Starting server ...");
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		ProjectManager mgr = new ProjectManagerImpl();
		
		factory.setServiceClass(ProjectManager.class);
		factory.setAddress("http://localhost:9000/ProjectManager");
		factory.setServiceBean(mgr);
		
		factory.create();

	}
	
	public static void main(String[] args) throws InterruptedException {
		new WSServer();
		System.out.println("JaxWsServerFactoryBean Server ready...");
		
		Thread.sleep(5 * 60 * 1000);
		System.out.println("JaxWsServerFactoryBean Server exiting ...");
		System.exit(0);
	}

}
