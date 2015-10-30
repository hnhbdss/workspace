package com.dss.demo.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.dss.demo.Project;
import com.dss.demo.ProjectManager;

import java.util.Map;
import java.util.HashMap;

@WebService(serviceName="ProjectManagerImplService2", endpointInterface="com.dss.demo.ProjectManager", portName="ProjectManagerImplPort2")
public class ProjectManagerImpl implements ProjectManager{
				
	private Map<String, Project> projects = new HashMap<String, Project>();
	public ProjectManagerImpl() {

	}

	@Override
	public String getProjectName() {
		return null;
	}

	@Override
	public String getProjectNameFromID(String projectID) {
		return null;
	}

	@Override
	public String greeting() {
		System.out.println("greeting() be called");
		return "Hello, This i ProjectManager";
	}

	@Override
	@WebMethod(operationName = "addProject")
	public void add(Project p) {
		projects.put(p.getProjectID(), p);
	}

	@Override
	@WebMethod(operationName = "updateProject")
	public void updateProject(String projectID, String newName) {
		projects.get(projectID).setProjectName(newName);
		
	}

	@Override
	@WebMethod(operationName = "getProject")
	public Project getProject(String projectID) {
		return projects.get(projectID);
	}
	
	@Override 
	@WebMethod(operationName = "getProjects")
	public Map<String, Project> getProjects() {
		return projects;
	}
}
