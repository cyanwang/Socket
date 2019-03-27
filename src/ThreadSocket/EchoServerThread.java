package ThreadSocket;

import java.io.*;
import java.net.*;

public class EchoServerThread {

	 public static void main(String[] args)throws IOException
	 {
		 //����һ��serverSocket
		 ServerSocket serverSocket=null;
		 //����һ��������ʶ
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
		 //������ڼ���״̬����һ���߳�
		 while(listening)
		 {
			 //ʵ����һ���������˵�socket������socket��������
			 new EchoMultiServerThread(serverSocket.accept()).start();
		 }
		 //��serverSocket�Ĺرղ�������ѭ������
		 //ֻ�е�������״̬Ϊfalseʱ���������Źر�
		 serverSocket.close();
	 }
}
