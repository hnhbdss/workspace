package com.dss.demo.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dss.demo.ProjectImpl;
import com.dss.demo.ProjectManager;

public class SprintClient {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext(new String[] {"com/dss/demo/client/sprint-java-beans.xml"});
		ProjectManager mgr = (ProjectManager) context.getBean("ProjectManagerClient");
		
		System.out.println("greeting:" + mgr.greeting());

		ProjectImpl impl = new ProjectImpl();
		impl.setProjectID("100");
		impl.setProjectName("100_name");
		mgr.add(impl);
		mgr.updateProject("100", "111_name");
		
		System.out.println("project new name is :" + mgr.getProject("100").getProjectName());
	}

}
