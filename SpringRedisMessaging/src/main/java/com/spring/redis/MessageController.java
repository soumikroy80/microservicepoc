package com.spring.redis;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.redis.core.RedisMessagePublisher;

@Controller
public class MessageController {

	
	@Autowired
	private RedisMessagePublisher redisMessagePublisher;
	
	/*public void setRedisMessagePublisher(RedisMessagePublisher redisMessagePublisher)
	{
		this.redisMessagePublisher = redisMessagePublisher;
	}*/
	
	@RequestMapping(path="/redispost/{message}", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String xyz(@PathVariable String message) {
		Random rand = new Random();
		Message msg = new Message();
		msg.setMsgId(String.valueOf(rand.nextInt()));
		msg.setMsgDesc(message);
		System.out.println("Sending message...");
		
		redisMessagePublisher.publish(msg);
		return "Message posted";
	}
}
