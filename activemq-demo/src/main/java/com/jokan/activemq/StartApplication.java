package com.jokan.activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jokan.activemq.service.MessageService;

public class StartApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-mq.xml");
		MessageService messageService = (MessageService) ctx.getBean("messageService");
		
		messageService.sendQueueMessage("我的测试消息1");
        messageService.sendTopicMessage("spring-topic", "我的测试消息2");
        messageService.sendTopicMessage("我的测试消息3");
	}
}
