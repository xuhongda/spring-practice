package springpractice.demo.rabbit.recevier;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import springpractice.demo.pojo.User;

/**
 * @author xuhongda on 2018/8/2
 * springpractice.demo.rabbit.recevier
 * spring-practice
 */
@Component
@RabbitListener(queues = "object")
public class RecevieObject {

    @RabbitHandler
    public void x(User user){
        System.err.println("接收到"+user);
    }
}
