package com.spring.redis;

import java.io.Serializable;

public class Message implements Serializable {

	private String msgId;
	private String msgDesc;
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getMsgDesc() {
		return msgDesc;
	}
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	
	@Override
	public String toString() {
		return "Message Id:"+msgId+"&& Description:"+msgDesc;
	}
}
