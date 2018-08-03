package springpractice.demo.rabbit.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2018/8/2
 * springpractice.demo.rabbit.sender
 * spring-practice
 */
@Component
public class HelloSender2 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
       amqpTemplate.convertAndSend("hello","你好啊！");
    }
}
