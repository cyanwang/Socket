package TCP;

import java.io.*;
import java.net.*;

public class HelloClientTcp {

	public static void main(String []args)throws Exception
	{
		Socket client=new Socket("localhost",8888);//ָ��һ̨������
		
		
		BufferedReader buf;//ר�Ŷ�Ӧ�Ķ�������Ϣ
		buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
		String str=buf.readLine();//��������һ��ʼ�ķ��������
		
		System.out.println("������"+str);
		
		
		//�ͻ��˴�������
		PrintWriter out=null;//�����������������Ϣ
		out=new PrintWriter(client.getOutputStream(),true);
		
		BufferedReader buf1=new BufferedReader(new InputStreamReader(System.in));//����һ��ר�Ŷ�����̨�����
		
		String input;		
		
		if((input=buf1.readLine())!=null)
		{
			out.println(input);//���������͸�server��server��ʱ�ᴫ��һ�����
			System.out.println("�ո������̨�����˷ǿ�"+buf.readLine());//�ѷ���������ķ��͹���
			
		}		
		client.close();
	}
}
