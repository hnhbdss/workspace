package com.demo.match.common;

import java.io.Closeable;

public class CloseUtils {

	public static void closeQuietly(Closeable res) {
		try {
			res.close();
		}
		catch(Exception e) {
			System.err.println("close object failed:" + res);
		}
	}
}
