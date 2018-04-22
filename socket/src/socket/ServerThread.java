package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	private Socket socket = null;
	private InputStream ins;
	private OutputStream ous;
	private BufferedReader br;
	private PrintWriter out;
	public ServerThread (Socket socket) throws IOException{
		this.socket = socket;
		ins = socket.getInputStream();
		ous = socket.getOutputStream();
		br = new BufferedReader(new InputStreamReader(ins));
		out = new PrintWriter(ous);
	}
	public void sendMsg(String msg){
		out.println(msg);
		out.flush();
	}
	public void broadcastMsg(String Msg){
		for(ServerThread st : Server.list){
			st.sendMsg(Msg);
		}
	}
		public void run() {
			try {
				System.out.println("有客户端连接...");
				String s = "欢迎来到服务器";
				sendMsg(s);
				String msg = null;
				while((msg = br.readLine())!=null){
						broadcastMsg(msg);
				}
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

}
