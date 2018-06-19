package com.spring.redis.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

import com.spring.redis.Message;
import com.spring.redis.MessagePublisher;

public class RedisMessagePublisher implements MessagePublisher{

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
 
	@Autowired
	private ChannelTopic topic;
	
	public RedisMessagePublisher() {
		
	}
	
	public RedisMessagePublisher(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
		this.redisTemplate = redisTemplate;
		this.topic = topic;
	}

	@Override
	public void publish(Message msg) {
		// TODO Auto-generated method stub
		redisTemplate.convertAndSend(topic.getTopic(), msg.toString());
		System.out.println("## RedisMessagePublisher - MESSAGE PUBLISHED ##");
	}

	
}
