package com.xu.springcloudproducercake.service.impl;

import com.xu.pojo.Girl;
import com.xu.springcloudproducercake.service.GetGirl;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author xuhongda on 2018/6/20
 * com.xu.springcloudproducerhello.service.impl
 * spring-practice
 */
@Service
public class GetGirlImpl implements GetGirl {


    @Override
    public Girl meet() {
        String strs1 = "周吴郑王黄刘张袁";
        String strs2 = "ABCDEF";
        Random random = new Random();
        int i = random.nextInt(strs1.length());
        int i2 = random.nextInt(strs2.length());
        String firstName = strs1.substring(i,i+1);
        String lastName = strs2.substring(i2,i2+1);
        String name = firstName+lastName;
        Girl girl = new Girl();
        girl.setName(name);
        girl.setLookLike("美若天仙");
        girl.setAge("18");
        return girl;
    }
}
