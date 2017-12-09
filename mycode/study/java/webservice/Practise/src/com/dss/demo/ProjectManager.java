package com.dss.demo;

import java.util.Map;
import javax.jws.WebMethod;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService(name="ProjectManager")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.ENCODED)
public interface ProjectManager {
	
	@WebMethod(operationName="getProjectName")
	public String getProjectName();
	
	@WebMethod(operationName="getProjectNameFromID")
	//@RequestWrapper(className="java.lang.String")
	//@ResponseWrapper(className="java.lang.String")
	public String getProjectNameFromID(@WebParam(name="projectID") String projectID);
	
	@WebMethod(operationName="greeting")
	//@ResponseWrapper(className="java.lang.String")
	public String greeting();
	
	@WebMethod(operationName="add")
	public void add(Project p);
	
	@WebMethod(operationName="updateProject")
	public void updateProject(String projectID, String newName);
	
	@WebMethod(operationName="getProject")
	public Project getProject(String projectID);
	
	@WebMethod(operationName="getProjects")
	@XmlJavaTypeAdapter(StringProjectMapAdapter.class)
	public Map<String, Project> getProjects();
}
