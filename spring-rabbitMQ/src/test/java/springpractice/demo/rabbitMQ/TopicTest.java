package springpractice.demo.rabbitMQ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springpractice.demo.rabbit.topic.TopicSender;

/**
 * @author xuhongda on 2018/8/6
 * springpractice.demo.rabbitMQ
 * spring-practice
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {
    @Autowired
    private TopicSender topicSender;

    @Test
    public void test1(){
        topicSender.send1();
    }

    @Test
    public void test2(){
        topicSender.send2();
    }

    @Test
    public void test3(){
        topicSender.send3();
        //while (true){}
    }
}
