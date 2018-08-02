package springpractice.demo.rabbitMQ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springpractice.demo.rabbit.recevier.HelloReceiver;
import springpractice.demo.rabbit.sender.HelloSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {

	@Autowired
	private HelloSender helloSender;

	@Autowired
	private HelloReceiver helloReceiver;

	@Test
	public void hello() throws Exception {
		helloSender.send();
	}


}