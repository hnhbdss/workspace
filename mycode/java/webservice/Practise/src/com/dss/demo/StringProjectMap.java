package com.dss.demo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "StringProjectMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class StringProjectMap {
	
	@XmlElement(nillable = false, name = "entry")
	List<StringProjectEntry> entries = new ArrayList<StringProjectEntry>();
	
	public List<StringProjectEntry> getEntries() {
		return entries;
	}
	
	@XmlType(name="IdentifiedProject")
	@XmlAccessorType(XmlAccessType.FIELD)
	static class StringProjectEntry {
		
		@XmlElement(required = true, nillable = false)
		String id;
		
		Project project;
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getId() {
			return id;
		}
		
		public void setProject(Project p) {
			this.project = p;
		}
		
		public Project getProject() {
			return this.project;
		}
	}
	
}
