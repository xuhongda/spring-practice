package springpractice.demo.rabbitMQ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springpractice.demo.pojo.User;
import springpractice.demo.rabbit.sender.SendObject;

/**
 * @author xuhongda on 2018/8/2
 * springpractice.demo.rabbitMQ
 * spring-practice
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {
    @Autowired
    private SendObject sendObject;

    @Test
    public void test1(){
        sendObject.send(new User("xuhongda",18));
    }
}
