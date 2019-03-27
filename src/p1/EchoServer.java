package p1;

import java.io.*; 
import java.net.*;

public class EchoServer {

	 public static void main(String[]args)
	 {
		 ServerSocket serversocket=null;
		 PrintWriter out=null;
		 BufferedReader in=null;
		 try
		 {
			 //实例化监听端口
			 serversocket=new ServerSocket(1111);
			 Socket incoming=null;
			 while(true)
			 {
				 incoming=serversocket.accept();
				 out=new PrintWriter(incoming.getOutputStream(),true);
				 //将字节流放入字符流缓冲之中
				 in=new BufferedReader(new InputStreamReader(incoming.getInputStream()));
				 //提示信息
				 out.println("Hello!....");
				 out.println("Enter BYE to exit");
				 out.flush();
				 while(true)
				 {
					 //只有当用户输入数据的适合才返回数据内容
					 String str=in.readLine();
					 //当用户连接断了才会返回数据内容
					 if(str==null)
					 {
						 break;
					 }
					 else
					 {
						//在用户输入字串加前缀echo:,将此信息打印到客户端
						 out.println("Echo:"+str);
						 out.flush();
						 //推出命令
						 if(str.trim().equalsIgnoreCase("BYE"))
							 break;					 
					 }
				 }
				 //收尾工作
				 out.close();
				 in.close();
				 incoming.close();
				 serversocket.close();
			 }
			 
		 }
		 catch(IOException e)
		 {
			 System.err.println("could not listen on port 1111");
			 System.exit(1);
		 }
		
	 }
}
