package springpractice.demo.rabbitMQ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springpractice.demo.rabbit.fanout.FanoutSender;

/**
 * @author xuhongda on 2018/8/6
 * springpractice.demo.rabbitMQ
 * spring-practice
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutTest {
    @Autowired
    private FanoutSender fanoutSender;

    /**
     * 订阅/发布模式会给每一个订阅队列 发送的全部消息，而不是平分
     */
    @Test
    public void test1(){
        for (int i = 0; i <10000 ; i++) {
            fanoutSender.send();
        }
    }
}
