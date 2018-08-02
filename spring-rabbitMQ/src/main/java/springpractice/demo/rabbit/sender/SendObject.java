package springpractice.demo.rabbit.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springpractice.demo.pojo.User;

/**
 * @author xuhongda on 2018/8/2
 * springpractice.demo.rabbit.sender
 * spring-practice
 */
@Component
public class SendObject {
    @Autowired
    private AmqpTemplate amqpTemplate;
    public void send(User user){
        System.err.println("发送"+user);
        amqpTemplate.convertAndSend("object",user);
    }
}
