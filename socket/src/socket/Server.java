package socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
public class Server {
	public static ArrayList<ServerThread> list = new ArrayList<ServerThread>();
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(6666);
		System.out.println("�������Ѿ��������˿ں�6666");
		while(true){
			Socket socket = server.accept();
			ServerThread st = new ServerThread(socket);
			list.add(st);
			st.start();
		}
	}

}