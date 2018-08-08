package springpractice.demo.rabbit.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2018/8/6
 * springpractice.demo.rabbit.topic
 * spring-practice
 */
@Component
@RabbitListener(queues = "topic.queue.a")
public class TopicReceiver1 {

    @RabbitHandler
    public void rec(String msg){
        System.out.println("由topic-a 接收:"+msg);
    }
}
