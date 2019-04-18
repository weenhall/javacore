package com.ween.network.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by ween on 2019/3/19
 */
public class GreetingClient {
    public static void main(String[] args) {
        String serverName=args[0];
        int port=Integer.parseInt(args[1]);
        try{
            System.out.println("连接到主机："+serverName+",端口号:"+port);
            Socket client=new Socket(serverName,port);
            System.out.println("远程主机地址："+client.getRemoteSocketAddress());
            OutputStream outToServer=client.getOutputStream();
            DataOutputStream out=new DataOutputStream(outToServer);
            out.writeUTF("你好,我是客户端地址:"+client.getLocalSocketAddress());

            InputStream inFromServer=client.getInputStream();
            DataInputStream in=new DataInputStream(inFromServer);
            System.out.println("来自服务器的消息:"+in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
