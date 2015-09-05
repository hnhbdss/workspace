package com.dss.demo;

import javax.xml.bind.annotation.XmlType;


@XmlType(name = "Project")
public class ProjectImpl implements Project {

	private String projectName;
	private String projectID;
	@Override
	public String getProjectName() {
		return projectName;
	}

	@Override
	public void setProjectName(String name) {
		this.projectName = name;
	}

	@Override
	public String getProjectID() {
		return projectID;
	}

	@Override
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
