package activeMQTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import activeMQTest.producer.Producer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ApplicationTest {

	@Autowired
	private Producer producer;

	@Test
	public void testActivemq() {
		producer.sendMessage("发送消息--->我是生产者");
		while (true) {
		}
	}
}
