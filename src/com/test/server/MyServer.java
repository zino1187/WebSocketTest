package com.test.server;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/demo")
public class MyServer {
	
	@OnOpen
	public void open() {
		System.out.println("client is connected...");
	}
	@OnMessage
	public String handleMessage(String receiveData) {
		System.out.println("client send : "+receiveData);
		
		String sendData="echo : "+ receiveData;
		System.out.println(sendData);
		return sendData;
	}

	@OnClose	
	public void close() {
		System.out.println("client disconnected..");
	}

	@OnError
	public void handError(Throwable t) {
		t.printStackTrace();
	}

}
