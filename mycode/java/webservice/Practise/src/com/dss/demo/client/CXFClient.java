package com.dss.demo.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.dss.demo.ProjectImpl;
import com.dss.demo.ProjectManager;
public class CXFClient {

	public static void main(String[] args) {
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress("http://localhost:9000/ProjectManager");
		factory.setServiceClass(ProjectManager.class);
		
		ProjectManager mgr = (ProjectManager)factory.create();
		
		System.out.println("get greeting:" + mgr.greeting());
		
		ProjectImpl impl = new ProjectImpl();
		impl.setProjectID("10");
		impl.setProjectName("10_name");
		mgr.add(impl);
		mgr.updateProject("10", "11_name");
		
		System.out.println("project new name is :" + mgr.getProject("10").getProjectName());
	}

}
