package com.xu.service;

import com.xu.bean.FaYuanLossBean;

import java.util.List;

/**
 * @author xuhongda on 2018/6/15
 * com.xu.service
 * spring-practice
 */

public interface FaYuanLoss {
    /**
     * 全国失信被执行名单
     */
    List<FaYuanLossBean> crawlerLoss();
}
