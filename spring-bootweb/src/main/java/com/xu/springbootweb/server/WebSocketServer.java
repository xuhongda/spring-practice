package com.xu.springbootweb.server;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * @author xuhongda on 2018/8/15
 * com.xu.springbootweb.server
 * spring-practice
 */
@EqualsAndHashCode
@Component
@ServerEndpoint("/websocket/{sid}")
public class WebSocketServer {

    private ObjectMapper mapper = new ObjectMapper();

    private static Log log = LogFactory.get(WebSocketServer.class);
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static CopyOnWriteArraySet<WebSocketServer> onLineArray = new CopyOnWriteArraySet<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 接收sid
     */
    private String sid = "";

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        //加入set中
        onLineArray.add(this);
        //在线数加1
        addOnlineCount();
        log.info("open a new link id = {}, online total num = {}", sid, getOnlineCount());
        this.sid = sid;
        try {
            Map<String, Object> map = new HashMap<>();

            map.put("hasIncreaseMsg", 0);
            map.put("totoalNum", 100);
            ObjectMapper mapper = new ObjectMapper();
            String value = mapper.writeValueAsString(map);
            sendMessage(value);
        } catch (IOException e) {
            log.error("websocket IO exception");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        //从set中删除
        onLineArray.remove(this);
        //在线数减1
        subOnlineCount();
        log.info("has a close ,now onLine num = {} , total  = {} ", getOnlineCount(), onLineArray.size());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("receive the id = {}, the message = {} ", sid, message);
        onLineArray.forEach(o -> {
            try {
                if (sid.equals(o.sid) && message.contains("true")) {
                    Date date = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String time = format.format(date);

                    o.sendMessage(time +": "+message);
                }
            } catch (Exception e) {
                log.info("exception = ", e);
            }
        });

    }


    @OnError
    public void onError(Session session, Throwable error) {
        log.error("has an error");
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message, @PathParam("sid") String sid) {

        onLineArray.forEach(ws -> {
            try {
                if (sid == null) {
                    log.info("push message to everyone = {}", message);
                    ws.sendMessage(message);
                } else if (ws.sid.equals(sid)) {
                    log.info("push message = {} , to id = {} ", message, sid);
                    ws.sendMessage(message);
                }
            } catch (Exception e) {
                log.info("exception =", e);
            }
        });
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
