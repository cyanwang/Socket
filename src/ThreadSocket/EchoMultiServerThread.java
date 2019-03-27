package ThreadSocket;

import java.io.*;
import java.net.*;

public class EchoMultiServerThread extends Thread {

	private Socket socket=null;
	public EchoMultiServerThread(Socket socket)
	{
		super();
		//声明一个socket对象		
		this.socket=socket;
	}
	public void run()
	{
		try
		{
		PrintWriter out=null;
		BufferedReader in=null;
		out=new PrintWriter(socket.getOutputStream());
		in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out.println("hello!....");
		out.println("Enter BYE to exit");
		out.flush();
		while(true)
		{
			String str=in.readLine();
			if(str==null)
			{
				break;
			}
			else
			{
				out.println("Echo:"+str);
				out.flush();
				if(str.trim().equalsIgnoreCase("BYE"))
					break;
			}
		}
		out.close();
		in.close();
		socket.close();
	}
	catch(IOException e)
	{
			
		}
	}
}
