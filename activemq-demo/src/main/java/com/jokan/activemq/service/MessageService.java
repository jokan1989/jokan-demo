package com.jokan.activemq.service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	@Resource(name = "testQueue")
	private Destination testQueue;
	
	@Resource(name = "testTopic")
	private Destination testTopic;
	
	/**
	 * 向队列发送消息
	 * @param messageContent
	 */
	public void sendQueueMessage(String messageContent) {
		//jmsTemplate.send(testQueue, new MessageCreator() {
		jmsTemplate.send("spring-queue", new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage();
				msg.setText(messageContent);
				return msg;
			}
		});
	}
	
	/**
	 * 
	 * @param destinationName 主题列队名
	 * @param messageContent  
	 */
	public void sendTopicMessage(String destinationName, String messageContent) {
		jmsTemplate.send(destinationName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage();
				msg.setText(messageContent);
				return msg;
			}
		});
	}
	
	/**
	 * 向主题发送消息
	 * @param messageContent
	 */
	public void sendTopicMessage(String messageContent) {
		jmsTemplate.send(testTopic, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage();
				msg.setText(messageContent);
				return msg;
			}
		});
	}
}
