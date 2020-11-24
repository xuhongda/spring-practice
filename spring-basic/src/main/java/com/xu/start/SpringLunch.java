package com.xu.start;

import com.xu.pojo.Car;
import com.xu.pojo.Cat;
import com.xu.pojo.Tiger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author xuhongda on 2020/11/24
 * PACKAGE_NAME
 * spring-practice
 */
@Service
public class SpringLunch {



    private Cat cat;

    @Autowired
    private Tiger tiger;

    @Autowired
    private void setCat(Cat cat){
        System.out.println("autowired cat");
        this.cat = cat;
    }




    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
    }

    private static void byXml() {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");

        Car car = (Car)applicationContext.getBean("car");

        System.out.println(car.getBrand());

        car.setBrand("DW");

        Car car1 = (Car)applicationContext.getBean("car");

        System.out.println(car1.getBrand());
    }
}
