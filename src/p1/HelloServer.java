package p1;

import java.io.*; 
import java.net.*;

public class HelloServer {

	public static void main(String []args)throws IOException
	{
		ServerSocket serversocket=null;
		PrintWriter out=null;
		try
		{
			//������ʵ������һ����������Socket����
			serversocket=new ServerSocket(9999);
			
		}catch(IOException e)
		{
			System.err.println("Could not listen on port:9999");
			System.exit(1);
		}
		Socket clientsocket=null;
		try
		{
			//accept()�������������ͻ��˵�����
			clientsocket=serversocket.accept();
			
		}catch(IOException e)
		{
			System.out.println("Accept failed");
			System.exit(1);
		}
		out=new PrintWriter(clientsocket.getOutputStream(),true);
		out.println("hello world");
		clientsocket.close();
		serversocket.close();
	}
}
