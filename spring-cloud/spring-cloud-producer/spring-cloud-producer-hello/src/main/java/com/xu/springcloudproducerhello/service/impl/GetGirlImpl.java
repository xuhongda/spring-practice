package com.xu.springcloudproducerhello.service.impl;

import com.xu.pojo.Girl;
import com.xu.springcloudproducerhello.service.GetGirl;
import org.springframework.stereotype.Service;

/**
 * @author xuhongda on 2018/6/20
 * com.xu.springcloudproducerhello.service.impl
 * spring-practice
 */
@Service
public class GetGirlImpl implements GetGirl {


    @Override
    public Girl meet() {
        return new Girl("美若天仙","迪丽热巴","18");
    }
}
