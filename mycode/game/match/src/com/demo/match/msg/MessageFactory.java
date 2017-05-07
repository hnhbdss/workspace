package com.demo.match.msg;

import com.demo.match.common.VisiableException;
import com.demo.match.msg.IMessage;
import com.demo.match.msg.impl.InitMessage;
public class MessageFactory {
	

	
	public IMessage buildMessage(String content) {
		if (content.startsWith(IMessage.MESSAGE_SYNC)) {
			switch(content.substring(IMessage.MESSAGE_SYNC.length(), IMessage.MESSAGE_SYNC.length())) {
			case IMessage.MESSAGE_INIT:
				return new InitMessage(content.substring(IMessage.MESSAGE_SYNC.length()));
			default:
				System.err.println("get invalid message:" + content);
				throw new VisiableException("invalid message:" + content);
			}
		}
		throw new VisiableException("invalid message:" + content);
	}
}