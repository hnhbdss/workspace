package com.dss.demo;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.dss.demo.StringProjectMap.StringProjectEntry;

public class StringProjectMapAdapter extends XmlAdapter<StringProjectMap, Map<String, Project>>{

	public StringProjectMap marshal(Map<String, Project> projects) throws Exception{
		
		StringProjectMap infos = new StringProjectMap();
		for (Map.Entry<String, Project> item : projects.entrySet()) {
			StringProjectMap.StringProjectEntry p = new StringProjectMap.StringProjectEntry();
			p.setId(item.getKey());
			p.setProject(item.getValue());
			infos.getEntries().add(p);
		}
		return infos;
	}
		
	public Map<String, Project> unmarshal(StringProjectMap infos) throws Exception{
			
			Map<String, Project> result = new HashMap<String, Project>();
			for (StringProjectEntry entry : infos.getEntries()) {
				result.put(entry.getId(), entry.getProject());
			}
			return result;
	}
	
}
