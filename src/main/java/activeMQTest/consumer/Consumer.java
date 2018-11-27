package activeMQTest.consumer;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	private final static Logger logger = LoggerFactory.getLogger(Consumer.class);

	@JmsListener(destination = "queue1", containerFactory = "jmsQueueListener")
	public void receiveQueue(final TextMessage text, Session session) throws JMSException {
		try {
			// 一般还是使用json字符串进行传输
			logger.debug("Consumer收到的报文为:" + text.getText());
			// 公司自己的业务逻辑
			System.out.println("Consumer收到的报文为:" + text.getText());
			// 测试重发机制
			// int a = 1 / 0;
			// 使用手动签收模式，需要手动的调用，如果不在catch中调用session.recover()消息只会在重启服务后重发
			text.acknowledge();
		} catch (Exception e) {
			// 此不可省略 重发信息使用
			session.recover();
		}
	}
}