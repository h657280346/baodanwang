package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Client {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost",6666);
		ClientThread ct = new ClientThread(socket);
		ct.start();
		Scanner sc = new Scanner(System.in);
		String s = null;
		while((s = sc.nextLine())!=null){
			ct.sendMsgToServer(s);
		}
//		 InputStream ins = socket.getInputStream();
//		 OutputStream ous = socket.getOutputStream();
//		 BufferedReader br = new BufferedReader(new InputStreamReader(ins));
//		 
	}
}
