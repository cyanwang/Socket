package DatagramSocket;

import java.io.*;
import java.net.*;

public class UdpSend {

	 public static void main(String[]args)
	 {
		 //要编写UDP 网络成簇，首先要用到java。net.DatagramSocket类
		 DatagramSocket ds=null;
		 DatagramPacket dp=null;
		 try
		 {
			 ds=new DatagramSocket(3000);			 
		 }
		 catch(SocketException ex)
		 {
			 
		 }
		 String str="hello world";
		 try
		 {
			 dp=new DatagramPacket(str.getBytes(),str.length(),InetAddress.getByName("localhost"),9000);
			 System.out.println("hello");
		 }
		 catch(UnknownHostException ex1)
		 {
			 
		 }
		 try
		 {
			 ds.send(dp);
		 }
		 catch(IOException ex2)
		 {
			 
		 }
		 ds.close();
	 }
}
