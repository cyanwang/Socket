package TCP;

import java.net.*;

public class EchoThreadServer  {

	public static void main(String[]args)throws Exception
	{
		ServerSocket server=new ServerSocket(8888);
		boolean flag=true;
		while(flag)
		{
			System.out.println("�ȴ��ͻ������ӡ�����������");
			new Thread(new EchoThread(server.accept())).start();
		}
		server.close();
	}
}
