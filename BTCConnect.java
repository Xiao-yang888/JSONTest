package com.btc.connect;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.impl.client.DefaultHttpClient;
import sun.net.www.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BTCConnect {
    //RPC服务的用户名，应该与比特币客户端节点的配置文件的bitcoin.conf中配置的一样
    private static final String RPCUSER = "xiaoyang";
    //RPC服务的密码
    private static final String RPCPASSWORD = "714736690";



    //maven：管理和构建项目的依赖和配置
    //依赖的配置：xml文件
    //例如：配置mysql数据库

    public static void main(String[] args) {
        System.out.println("Hello world");

        /**
         * 1，准备json-rpc通信的json数据
         *       fastjson.jar
         * 2，使用java网络通信进行rpc连接
         *       httpclient、httpcore
         *          请求类型：GET,POST
         * 3，接收java中的http形式的rpc链接的响应
         * 4，处理结果
         */

        JSONObject object = new JSONObject();
        object.put("id", System.currentTimeMillis() + "");
        object.put("jsonrpc", "2.0");//rpc服务协议的版本
        object.put("method", "getblockcount");
        //object.put("params", "");
        object.put("Authorization", "Basic" + base64Encode(RPCUSER + ":" + RPCPASSWORD));
        String jsonRpcStr = object.toJSONString();
        System.out.println(jsonRpcStr);

        //JSONArray
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("xiaoyang");
        jsonArray.add("20");
        jsonArray.add("male");
        JSONArray array = jsonArray;
        System.out.println(array);

        //2,发起一个post类型的网络请求，将第一步准备好的json格式数据发送给rpc服务器

    }

    public static String base64Encode(String msg) {
        return Base64.getEncoder().encodeToString(msg.getBytes(StandardCharsets.UTF_8));
    }
}
