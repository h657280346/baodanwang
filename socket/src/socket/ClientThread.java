package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{

	private Socket socket = null;
	private InputStream ins;
	private OutputStream ous;
	private BufferedReader br;
	private PrintWriter out;
	public ClientThread (Socket socket) throws IOException{
		this.socket = socket;
		ins = socket.getInputStream();
		ous = socket.getOutputStream();
		br = new BufferedReader(new InputStreamReader(ins));
		out = new PrintWriter(ous);
		}
	public void sendMsgToServer(String msg){
		out.println(msg);
		out.flush();
	}
	public void run(){
		try {
			String msg = null;
			while((msg = br.readLine())!=null){
				System.out.println("服务器发送的消息："+msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
