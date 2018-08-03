package com.xu.springeatmq.receiver;

import com.xu.springeatmq.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2018/8/2
 * springpractice.demo.rabbit.receiver
 * spring-practice
 */
@Component
@RabbitListener(queues = "object")
public class ReceiverObject {

    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @RabbitHandler
    public void x(User user)  {
        System.err.println("接收到"+user);
    }
}
