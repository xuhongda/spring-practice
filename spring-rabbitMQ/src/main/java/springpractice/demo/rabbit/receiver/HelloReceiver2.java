package springpractice.demo.rabbit.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2018/8/2
 * springpractice.demo.rabbit.receiver
 * spring-practice
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver2 {

    @RabbitHandler
    private void process(String hello){
        System.err.println("接收者2"+hello);
    }
}
