package com.dss.demo;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class ProjectAdapter extends XmlAdapter<ProjectImpl, Project> {

	@Override
	public Project unmarshal(ProjectImpl v) throws Exception {
		return v;
	}

	@Override
	public ProjectImpl marshal(Project v) throws Exception {
		if (v instanceof ProjectImpl) {
			return (ProjectImpl) v;
		}
		return new ProjectImpl();
	}


}
