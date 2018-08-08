package springpractice.demo.rabbit.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2018/8/6
 * springpractice.demo.rabbit.topic
 * spring-practice
 */
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send1(){
        String msg = "topic---a";
        System.err.println("topic.a 开始发送："+msg);
        amqpTemplate.convertAndSend("topicExchange","topic.a","topic---a");
    }

    public void send2(){
        String msg = "topic---b";
        System.err.println("topic.b 开始发送："+msg);
        amqpTemplate.convertAndSend("topicExchange","topic.b",msg);
    }

    public void send3(){
        System.err.println("开始 发送 # 号======》》》》");
        amqpTemplate.convertAndSend("topicExchange","topic.c","# 匹配");
    }
}
