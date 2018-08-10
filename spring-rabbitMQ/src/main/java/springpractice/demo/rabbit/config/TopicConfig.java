package springpractice.demo.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuhongda on 2018/8/6
 * springpractice.demo.rabbit.config
 * spring-practice
 */
@Configuration
public class TopicConfig {

    private final static String QUEUE_A = "topic.queue.a";
    private final static String QUEUE_B = "topic.queue.b";


    /**
     * 需要注意方法名
     * @return Queue
     */
    @Bean
    public Queue topicQueueA(){
        return new Queue(TopicConfig.QUEUE_A);
    }

    @Bean
    public Queue topicQueueB(){
        return new Queue(TopicConfig.QUEUE_B);
    }

    /**
     * 交换机
     * @return TopicExchange
     */
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding queueA(Queue topicQueueA,TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueueA).to(topicExchange).with("topic.a");
    }


    /**
     * <p>
     *     * (star) can substitute for exactly one word.
     *     # (hash) can substitute for zero or more words.
     * </p>
     * @param topicQueueB
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding queueB(Queue topicQueueB,TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueueB).to(topicExchange).with("topic.#");
    }
}
