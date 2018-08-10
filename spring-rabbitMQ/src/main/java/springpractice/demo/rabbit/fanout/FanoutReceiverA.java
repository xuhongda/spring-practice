package springpractice.demo.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2018/8/6
 * springpractice.demo.rabbit.fanout
 * spring-practice
 */
@Component
@RabbitListener(queues = "fanout.a")
public class FanoutReceiverA {
    @RabbitHandler
    public void rec(String s){
        System.err.println("fanout.a --- 接收");
        System.out.println(s);
    }
}
