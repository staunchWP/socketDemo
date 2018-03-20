package com.example.soketdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于这个控制器，首先@Controller注解不必多言，
 * say方法上添加的@MessageMapping注解和我们之前使用的@RequestMapping类似。
 * @SendTo注解表示当服务器有消息需要推送的时候，会对订阅了@SendTo中路径的浏览器发送消息。
 * @author HuRui
 * create on 2018/3/16 14:48
 */
@Controller
public class WsController {
    @Autowired
    private WebSocketService webSocketService;

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public void say(RequestMessage message) {
        System.out.println(message.getName());
        webSocketService.sendMsg();
//        return new ResponseMessage("welcome," + message.getName() + " !");
    }

//    @MessageMapping(Constant.FORETOSERVERPATH)//@MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址。
//    @SendTo(Constant.PRODUCERPATH)//如果服务器接受到了消息，就会对订阅了@SendTo括号中的地址传送消息。
//    public ResponseMessage say1(ResponseMessage message) throws Exception {
//        List<String> users = new ArrayList<>();
//        //此处写死只是为了方便测试,此值需要对应页面中订阅个人消息的userId
//        users.add("d892bf12bf7d11e793b69c5c8e6f60fb");
//        webSocketService.send2Users(users, new ResponseMessage("admin hello"));
//        return new ResponseMessage("Welcome, " + message.getResponseMessage() + "!");
//    }
}
