package TCP;
 
import java.io.*;
import java.net.*;

public class HelloServerTcp {

	public static void main(String[]args)throws Exception
	{
		ServerSocket server=new ServerSocket(8888);
		Socket client=null;
		System.out.println("�ȴ��ͻ������ӡ�������");
		client=server.accept();
		OutputStream out=client.getOutputStream();
		PrintStream pout=new PrintStream(out);
		pout.println("hello, world");
		pout.close();
		out.close();
		client.close();
		server.close();
	}
}
