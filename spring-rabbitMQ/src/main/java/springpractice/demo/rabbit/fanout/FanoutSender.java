package springpractice.demo.rabbit.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2018/8/6
 * springpractice.demo.rabbit.fanout
 * spring-practice
 */
@Component
public class FanoutSender {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(){
        System.err.println("fanout --- 发送");
        String msg = "is fanout";
        amqpTemplate.convertAndSend("fanoutExchange","",msg);
    }
}
