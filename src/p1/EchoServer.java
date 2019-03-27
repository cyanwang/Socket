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
			 //ʵ���������˿�
			 serversocket=new ServerSocket(1111);
			 Socket incoming=null;
			 while(true)
			 {
				 incoming=serversocket.accept();
				 out=new PrintWriter(incoming.getOutputStream(),true);
				 //���ֽ��������ַ�������֮��
				 in=new BufferedReader(new InputStreamReader(incoming.getInputStream()));
				 //��ʾ��Ϣ
				 out.println("Hello!....");
				 out.println("Enter BYE to exit");
				 out.flush();
				 while(true)
				 {
					 //ֻ�е��û��������ݵ��ʺϲŷ�����������
					 String str=in.readLine();
					 //���û����Ӷ��˲Ż᷵����������
					 if(str==null)
					 {
						 break;
					 }
					 else
					 {
						//���û������ִ���ǰ׺echo:,������Ϣ��ӡ���ͻ���
						 out.println("Echo:"+str);
						 out.flush();
						 //�Ƴ�����
						 if(str.trim().equalsIgnoreCase("BYE"))
							 break;					 
					 }
				 }
				 //��β����
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
