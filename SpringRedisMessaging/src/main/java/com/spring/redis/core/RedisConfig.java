package com.spring.redis.core;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import com.spring.redis.MessagePublisher;

@Configuration
public class RedisConfig {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	 
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		return template;
	}
	
	@Bean
	MessageListenerAdapter messageListener() {
		return new MessageListenerAdapter(new RedisListener());
	}
	
	@Bean
	ChannelTopic topic() {
		return new ChannelTopic("pubsub:redis-channel");
	}
	
	@Bean
	RedisMessageListenerContainer redisContainer() {
		final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(jedisConnectionFactory());
		container.addMessageListener(messageListener(), topic());
		container.setTaskExecutor(Executors.newFixedThreadPool(4));
		return container;
	}
	
	@Bean
	MessagePublisher redisPublisher() {
		return new RedisMessagePublisher(redisTemplate(), topic());
	}
	
	@Bean
	RedisMessagePublisher redisMessagePublisher() {
		return new RedisMessagePublisher(redisTemplate(), topic());
	}
}
