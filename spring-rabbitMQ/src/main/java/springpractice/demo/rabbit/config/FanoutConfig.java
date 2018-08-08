package springpractice.demo.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *     fanout 模式
 *     广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
 * </p>
 * @author xuhongda on 2018/8/6
 * springpractice.demo.rabbit.config
 * spring-practice
 */
@Configuration
public class FanoutConfig {
    @Bean
    public Queue aQueue(){
        return new Queue("fanout.a");
    }

    @Bean
    public Queue bQueue(){
        return new Queue("fanout.b");
    }


    @Bean
    public Queue cQueue(){
        return new Queue("fanout.c");
    }


    @Bean
    public Queue dQueue(){
        return new Queue("fanout.d");
    }

    /**
     * 创建 fanout 交换机
     * @return FanoutExchange
     */
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 将队列绑定到交换机
     * @param aQueue 队列
     * @param fanoutExchange 交换机
     * @return Binding
     */
    @Bean
    public Binding bindA(Queue aQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(aQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindB(Queue bQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(bQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindC(Queue cQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(cQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindD(Queue dQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(dQueue).to(fanoutExchange);
    }
}
