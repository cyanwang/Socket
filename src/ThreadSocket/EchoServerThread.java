package ThreadSocket;

import java.io.*;
import java.net.*;

public class EchoServerThread {

	 public static void main(String[] args)throws IOException
	 {
		 //声明一个serverSocket
		 ServerSocket serverSocket=null;
		 //声明一个监听标识
		 boolean listening=true;
		 try
		 {
			 serverSocket=new ServerSocket(1111);	
			
		 }
		 catch(IOException e)
		 {
			 System.err.println("Could not listen on port 1111");
			 System.exit(1);
		 }
		 //如果处于监听状态则开启一个线程
		 while(listening)
		 {
			 //实例化一个服务器端的socket与请求socket建立连接
			 new EchoMultiServerThread(serverSocket.accept()).start();
		 }
		 //将serverSocket的关闭操作放在循坏外卖
		 //只有当监听的状态为false时，服务器才关闭
		 serverSocket.close();
	 }
}
