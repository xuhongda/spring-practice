package com.xu.service.impl;

import com.alibaba.fastjson.JSON;
import com.xu.bean.FaYuanLossBean;
import com.xu.service.Task;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongda on 2018/5/21
 * com.xu.service.impl
 * spring-quartz-task
 */
@Service
public class TaskImpl implements Task {
    @Scheduled(fixedRate = 10000)
    @Override
    public void doIt() {
        System.out.println("这是一个基于注解的定时任务");
    }

}
