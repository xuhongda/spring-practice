package springpractice.demo.rabbit.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xuhongda on 2018/8/2
 * springpractice.demo.rabbit.sender
 * spring-practice
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hello " + new Date();
        System.err.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
