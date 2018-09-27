package com.jokan.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * 点对点
 * @author jokan
 */
public class QueueListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage txtMessage = (TextMessage) message;
			try {
				System.out.println("队列监听器接收到文本消息：" + txtMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException("只支持 TextMessage 类型消息！");
		}
		
	}

}
