package com.dss.demo.simple.client;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

import com.dss.demo.Project;
import com.dss.demo.ProjectManager;

public class ClientProxyFactoryClient {

	
	public static void main(String[] args) {
		ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
		factory.setServiceClass(ProjectManager.class);
		
		factory.setAddress("http://localhost:9000/ProjectManager");
		ProjectManager mgr = (ProjectManager) factory.create();
		Project p = mgr.getProject("1");
		System.out.println("project 1 : " + p.getProjectName());
	}

}
