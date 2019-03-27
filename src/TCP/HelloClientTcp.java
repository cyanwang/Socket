package TCP;

import java.io.*;
import java.net.*;

public class HelloClientTcp {

	public static void main(String []args)throws Exception
	{
		Socket client=new Socket("localhost",8888);//指向一台服务器
		
		
		BufferedReader buf;//专门对应的读到的信息
		buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
		String str=buf.readLine();//读到的是一开始的服务器输出
		
		System.out.println("内容是"+str);
		
		
		//客户端传入输入
		PrintWriter out=null;//用于向服务器传送信息
		out=new PrintWriter(client.getOutputStream(),true);
		
		BufferedReader buf1=new BufferedReader(new InputStreamReader(System.in));//开启一个专门读控制台输入的
		
		String input;		
		
		if((input=buf1.readLine())!=null)
		{
			out.println(input);//把输入结果送给server，server此时会传输一个结果
			System.out.println("刚刚向控制台输入了非空"+buf.readLine());//把服务器输入的发送过来
			
		}		
		client.close();
	}
}
