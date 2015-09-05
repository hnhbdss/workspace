package com.dss.demo;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(ProjectAdapter.class)
public interface Project {
	public String getProjectName();	
	public void setProjectName(String name);
	public String getProjectID();
	public void setProjectID(String projectID);

}
