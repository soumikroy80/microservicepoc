package com.spring.redis.core;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisListener implements MessageListener{

	@Override
	public void onMessage(Message message, byte[] pattern) {
		// TODO Auto-generated method stub
		System.out.println("## RedisListener - MESSAGE RECEIVED ## " + message +  ", " + Thread.currentThread().getName() );
	}

}