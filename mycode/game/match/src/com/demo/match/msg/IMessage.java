package com.demo.match.msg;

public interface IMessage {
	
	public static final String MESSAGE_SYNC = "message:";
	public static final String MESSAGE_INIT = "init:";
	
	public void process();
}