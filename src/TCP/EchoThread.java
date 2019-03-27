package TCP;

import java.io.*;
import java.net.*;

public class EchoThread implements Runnable{

	private Socket client;
	public EchoThread(Socket client)
	{
		this.client=client;
	}
	public void run()
	{
		try
		{
			BufferedReader buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintStream pout=new PrintStream(client.getOutputStream());
			pout.println("�յ���������");
			boolean temp=true;
			while(temp)//һֱ����buf�ļ���״̬
			{
				String str=buf.readLine();
				if(str==null||" ".equals(str))
				{
					temp=false;
					break;
				}
				pout.println("ECHO:"+str);
			}
			pout.close();
			client.close();
		}
		catch(Exception e)
		{
			System.out.print("Shit");
			System.exit(1);
		}
	}
}
