package com.dss.demo.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.dss.demo.ProjectImpl;
import com.dss.demo.ProjectManager;

public class Client {

	private static final QName Service_Name = new QName("http://demo.dss.com/", "ProjectManagerService");
	private static final QName Port_Name = new QName("http://demo.dss.com/", "ProjectManagerPort");
	private static final String endpointAddress = "http://127.0.0.1:9000/ProjectManager";
	
	public Client() {

	}
	
	public static void main(String[] args) {
		
		System.out.println("Starting client...");
		
		Service svr = Service.create(Service_Name);
		
		svr.addPort(Port_Name, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
		
		ProjectManager mgr = svr.getPort(ProjectManager.class);
		
		System.out.println(mgr.greeting());
		
		ProjectImpl impl = new ProjectImpl();
		impl.setProjectID("1");
		impl.setProjectName("1_name");
		mgr.add(impl);
		mgr.updateProject("1", "2_name");
		
		System.out.println("project new name is :" + mgr.getProject("1").getProjectName());
	}

}
