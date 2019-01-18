package com.xu.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.bean.FaYuanLossBean;
import com.xu.service.FaYuanLoss;
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
 * @author xuhongda on 2018/6/15
 * com.xu.service.impl
 * spring-practice
 */
@Service
public class FaYuanLossImpl implements FaYuanLoss {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Scheduled(cron = "* 0/5 * * * ?")
    @Override
    public List<FaYuanLossBean> crawlerLoss() {

        String url = "https://www.baidu.com/s?ie=UTF-8&wd=%E8%80%81%E8%B5%96";
        System.setProperty("webdriver.chrome.driver", "E:\\Seleniumhq\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        options.addArguments("--start-maximized", "allow-running-insecure-content", "--test-type");
        options.addArguments("--lang=" + "zh-CN");
        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        try {
            Thread.sleep(100);
            // 输入查询参数
            driver.findElement(By.cssSelector("input.c-input.op_trust_pername")).clear();
            driver.findElement(By.cssSelector("input.c-input.op_trust_pername")).sendKeys("翁爱秀");
            driver.findElement(By.cssSelector("input.c-input.op_trust_searchWord")).clear();
            driver.findElement(By.cssSelector("input.c-input.op_trust_searchWord")).sendKeys("33032919750****1749");
            driver.findElement(By.cssSelector("button.c-btn.c-btn-primary.op_trust_btnSearch")).click();
            Thread.sleep(100);
            //详情
            Actions action = new Actions(driver);

            List<WebElement> opTrustMainBox = driver.findElements(By.className("op_trust_mainBox"));
            List<WebElement> elements = opTrustMainBox.get(1).findElements(By.cssSelector("li.op_trust_item.OP_LOG_BTN"));
            FaYuanLossBean faYuanLossBean;
            for (int i = 0; i < elements.size(); i++) {
                System.out.println("elements.size" + elements.size());
                driver.get(url);
                driver.findElement(By.cssSelector("input.c-input.op_trust_pername")).clear();
                driver.findElement(By.cssSelector("input.c-input.op_trust_pername")).sendKeys("翁爱秀");
                driver.findElement(By.cssSelector("input.c-input.op_trust_searchWord")).clear();
                driver.findElement(By.cssSelector("input.c-input.op_trust_searchWord")).sendKeys("33032919750****1749");
                driver.findElement(By.cssSelector("button.c-btn.c-btn-primary.op_trust_btnSearch")).click();
                Thread.sleep(100);
                System.out.println("ii==>>" + i);
                System.out.println(elements.size());
                //再次创建
                List<WebElement> opTrustMainBox2 = driver.findElements(By.className("op_trust_mainBox"));
                List<WebElement> elements2 = opTrustMainBox2.get(1).findElements(By.cssSelector("li.op_trust_item.OP_LOG_BTN"));

                WebElement webElement = elements2.get(i);
                action.moveToElement(webElement).perform();
                JavascriptExecutor js = (JavascriptExecutor) driver;
                List<WebElement> elements1 = driver.findElements(By.cssSelector("a.op_trust_fl.op_trust_titletip"));
                js.executeScript("arguments[0].click();", elements1.get(10 + i));
                //解析DOM
                String pageSource = driver.getPageSource();
                Document parse = Jsoup.parse(pageSource);
                Elements opTrustInfo = parse.select(".op_trust_info");
                Element element = opTrustInfo.get(10 + i);
                Element tbody = element.getElementsByTag("tbody").get(0);
                Elements trs = tbody.getElementsByTag("tr");
                List<FaYuanLossBean> faYuanLossBeans = new ArrayList<>();
                for (int j = 0; j < trs.size(); j++) {
                    // create Object
                    faYuanLossBean = new FaYuanLossBean();
                    Element tr = trs.get(j);
                    if ("执行法院：".equals(tr.child(0).text())) {
                        faYuanLossBean.setCourtName(tr.child(1).text());
                    }
                    if ("省份：".equals(tr.child(0).text())) {
                        faYuanLossBean.setAreaName(tr.child(1).text());
                    }
                    if ("案号：".equals(tr.child(0).text())) {
                        faYuanLossBean.setCaseCode(tr.child(1).text());
                    }
                    if ("生效法律文书确定的义务：".equals(tr.child(0).text())) {
                        faYuanLossBean.setDuty(tr.child(1).text());
                    }
                    if ("被执行人的履行情况：".equals(tr.child(0).text())) {
                        faYuanLossBean.setPerformance(tr.child(1).text());
                    }
                    if ("失信被执行人行为具体情形：".equals(tr.child(0).text())) {
                        faYuanLossBean.setDuty(tr.child(1).text());
                    }
                    if ("发布时间：".equals(tr.child(0).text())) {
                        faYuanLossBean.setDuty(tr.child(1).text());
                    }
                    faYuanLossBeans.add(faYuanLossBean);
                }
                System.out.println(objectMapper.writeValueAsString(faYuanLossBeans));
                return faYuanLossBeans;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
