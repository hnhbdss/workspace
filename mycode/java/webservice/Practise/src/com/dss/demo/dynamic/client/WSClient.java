package com.dss.demo.dynamic.client;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.ClientImpl;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class WSClient {

	private static final QName Service_Name = new QName("http://demo.dss.com", "ProjectManager");
		
	public static void main(String[] args) throws Exception {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		ClientImpl client = (ClientImpl) dcf.createClient("http://localhost:9000/ProjectManager?wsdl", Service_Name);
		Object[] response = client.invoke("greeting");
		System.out.println("hello with server:" + response[0]);

	}

}
