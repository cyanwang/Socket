package TCP;

import java.io.*;
import java.net.*;

public class HelloClientTcp1 {

	public static void main(String []args)throws Exception
	{
		Socket client=new Socket("localhost",8888);
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
		String str=buf.readLine();
		System.out.println("ÄÚÈÝÊ±"+str);
		client.close();
	}
}
