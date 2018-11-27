package activeMQTest.producer;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * 发送消息，estination是发送到的队列，message是待发送的消息
	 * 
	 * @param destination
	 * @param message
	 */
	public void sendMessage(Destination destination, final String message) {
		System.out.println(jmsTemplate.getDeliveryMode());
		jmsTemplate.convertAndSend(destination, message);
	}

	/**
	 * 发送消息，message是待发送的消息
	 * 
	 * @param message
	 */
	public void sendMessage(final String message) {
		System.out.println(jmsTemplate.getDeliveryMode());
		jmsTemplate.convertAndSend("queue1", message);
	}

}
