package p1;
 
import java.io.*;
import java.io.PrintWriter;
import java.net.*;

public class EchoClient1 {

	public static void main(String []args)
	{
		Socket echosocket=null;
		PrintWriter out =null;
		BufferedReader in=null;
		try
		{
			echosocket=new Socket("localhost",1111);
			out=new PrintWriter(echosocket.getOutputStream(),true);
			in=new BufferedReader(new InputStreamReader(echosocket.getInputStream()));
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
			String userInput;
			//价格客户端socket输入流输出到标准输出
			while((userInput=stdIn.readLine())!=null)
			{
				out.println(userInput);
				System.out.println(in.readLine());
			}
			out.close();
			in.close();
			echosocket.close();
			
		}catch(UnknownHostException e)
		{
			System.err.println("UnknowException");
			System.exit(1);
		}
		catch(IOException e)
		{
			System.err.println("Couldn't get I/O for the connection");
			System.exit(1);
		}
			
	}
}
