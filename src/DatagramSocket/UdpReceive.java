package DatagramSocket;

import java.io.*;
import java.net.*;

public class UdpReceive {

	public static void main(String[]args)
	{
		DatagramSocket ds=null;
		byte[]buf=new byte[1024];
		DatagramPacket dp=null;
		try
		{
			ds=new DatagramSocket(9000);
			dp=new DatagramPacket(buf,1024);
			ds.receive(dp);
			String str=new String(dp.getData(),dp.getLength())+"from"
					+dp.getAddress().getHostAddress()+":"+dp.getPort();
					System.out.println(str);
			ds.close();
		}
		catch(SocketException ex)
		{
			
		}
		//����DatagramPacketʱ��Ҫ�����ݸ�ʽʱbyte������		
	 
		catch(IOException ex1)
		{
			
		}
		
		
	}
}
