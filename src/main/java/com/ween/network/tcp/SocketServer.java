package com.ween.network.tcp;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ween on 2019/3/19
 */
public class GreetingServer {

    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException {
        serverSocket=new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run(){
        while (true){
            try{
                System.out.println("等待客户端连接,端口号:"+serverSocket.getLocalPort());
                Socket server=serverSocket.accept();
                System.out.println("客户端主机地址:"+server.getRemoteSocketAddress());
                DataInputStream in=new DataInputStream(server.getInputStream());
                System.out.println("客户端说:"+in.readUTF());

                DataOutputStream out=new DataOutputStream(server.getOutputStream());
                out.writeUTF("我是服务器端，收到了你发送的消息："+in.readUTF());
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int port=Integer.parseInt(args[0]);
        try{
            GreetingServer t=new GreetingServer(port);
            t.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
