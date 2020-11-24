import com.xu.pojo.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuhongda on 2020/11/24
 * PACKAGE_NAME
 * spring-practice
 */
public class SpringLunch {



    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");

        Car car = (Car)applicationContext.getBean("car");

        System.out.println(car.getBrand());

        car.setBrand("DW");

        Car car1 = (Car)applicationContext.getBean("car");

        System.out.println(car1.getBrand());


    }
}
