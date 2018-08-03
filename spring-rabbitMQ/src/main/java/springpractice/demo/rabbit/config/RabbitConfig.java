package springpractice.demo.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuhongda on 2018/8/2
 * springpractice.demo.rabbit.config
 * spring-practice
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello");
    }

    @Bean
    public Queue queue2(){
        return new Queue("object");
    }
}
