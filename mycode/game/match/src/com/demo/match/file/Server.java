package com.demo.match.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import com.demo.match.comm.MessageProcessor;
import com.demo.match.common.VisiableException;

public class Server {

	private MessageProcessor processor = new MessageProcessor();
	public Server() {
		
	}
	
	public void start(String filePath) throws FileNotFoundException {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			processor.process(reader);
		}
		catch(Exception e) {
			System.err.println("invalid input exception :" + e);
			throw new VisiableException(e);
		}
	}
}
