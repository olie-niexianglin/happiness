package com.pattern.structure.proxy.rpc.server;

import com.pattern.structure.proxy.rpc.comm.HelloService;
import com.pattern.structure.proxy.rpc.comm.Invocation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by niexianglin on 2016/8/19 20:54
 * Class Description:
 */
class Server{
    public static void main(String[] args) throws IOException {
        Server server = new Server(8088);
    }

    //用于保存Server所提供的服务 key->接口名字  value->接口实现类
    private Map<String,Object> serviceList = new HashMap<String,Object>(100);
    private ServerSocket serverSocket;

    //初始化，注册服务
    private void init(){
        serviceList.put(HelloService.class.getName(),new HelloServiceImp());
        try {
            while(1==1){
                Socket client = serverSocket.accept();
                System.out.println("------接收到客户调用请求------");
                new Thread(new ServerStub(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        System.out.println("------启动服务器已启动------");
        init();
    }
    public class ServerStub implements Runnable{

        Socket socket ;

        public ServerStub(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;
            try {
                ois = new ObjectInputStream(socket.getInputStream());
                Invocation invo = (Invocation) ois.readObject();
                //执行服务
                Object serviceimp = serviceList.get(invo.getInterfaces().getName());
                if(serviceimp!=null){
                    java.lang.reflect.Method invocationM = serviceimp.getClass().getMethod(invo.getMethod().getMethodName(),invo.getMethod().getParams());
                    invo.setResult(invocationM.invoke(serviceimp,invo.getMethod().getParams()));
                }
                //返回结果
                oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(invo);
                oos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    if(oos!=null) oos.close();
                    if(ois!=null) ois.close();
                    if(socket != null && !socket.isClosed()) socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
    }
}
