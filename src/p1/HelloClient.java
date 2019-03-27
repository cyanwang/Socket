package p1;

import java.io.*;
import java.net.*;

public class HelloClient {

	public static void main(String []args)
	{
		Socket hellosocket=null;
		BufferedReader in=null;
		//下面这段程序，用来将输入输出流与socket关联
		try
		{
			hellosocket=new Socket("192.168.3.31",9999);//对方的主机ip地址，和对应开放的端口
			in=new BufferedReader(new InputStreamReader(hellosocket.getInputStream()));
			System.out.println(in.readLine());
			in.close();
			hellosocket.close();
		}
		catch(UnknownHostException e)
		{
			System.err.println("Don't know about host:localhost");
			System.exit(1);
		}
		catch(IOException e)
		{
			System.err.println("Couldn't get I/O for the connection");
			System.exit(1);
		}
			
		
	}
}
