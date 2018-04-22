package Internet;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoadUtil {
	//定义下载资源的路径
		private String filePath;
		//指定下载文件的保存位置
		private String targetFilePath;
		//定义需要使用多少个线程进行下载
		private int threadNum;
		//定义下载的线程对象
		private DownThread[] threads;
		//定义下载文件的总大小
		private int fileSize;
		public DownLoadUtil(String filePath,String targetFilePath,int threadNum){
			this.filePath = filePath;
			this.targetFilePath = targetFilePath;
			this.threadNum = threadNum;
			threads = new DownThread[threadNum];
		}
		
		public void downLoads() throws Exception{
			//要打开的资源位置，即要下载的文件
			URL url = new URL(this.filePath);
			//找到资源后，通过资源对象打开连接，返回URLConnection抽象类，需要转换为子类类型
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//上面代码开始进行建立连接，此处设置建立连接所花费时间超出设置时间，抛出异常将不再等待
			conn.setConnectTimeout(5*1000);
			//设置发送请求（即要打开的资源）时的请求方式
			conn.setRequestMethod("GET");
			//设置一般请求属性，即能够接收到的数据格式类型，即MIME(Multipurpose Internet Mail Extensions)类型
			String value = "image/gif,image/jpeg,image/png,image/pjpeg,*/*";
			conn.setRequestProperty("accpet", value);
			//设置请求属性中接受的语言类型，zh-CN中文
			conn.setRequestProperty("Accpet-Language", "zh-CN");
			//设置请求属性中数据传输使用的字符集编码
			conn.setRequestProperty("charset", "UTF-8");
			//设置请求属性中连接需要一直保持活动状态
			conn.setRequestProperty("Connection", "keep-Alive");
			//设置文件的总大小
			this.fileSize = conn.getContentLength();
			//告知服务器，此连接对象conn短时间内不会有其他请求
			conn.disconnect();
			//计算每个线程平均下载多少数据
			int partSize = this.fileSize/this.threadNum;
			//创建本地文件，用户保存下载回来的数据内容
			RandomAccessFile access = new RandomAccessFile(this.targetFilePath, "rw");
			//设置本地文件的大小
			access.setLength(this.fileSize);
			access.close();
			for(int i=0;i<this.threadNum;i++){
				int startPoints = partSize*i;
				access = new RandomAccessFile(this.targetFilePath, "rw");
				access.seek(startPoints);
				this.threads[i] = new DownThread(startPoints, partSize, access);
				this.threads[i].start();
			}
		}

		public double getCompleteRate(){
			int sumSize = 0;
			for(int i=0;i<this.threadNum;i++){
				sumSize = sumSize + this.threads[i].length;
			}
			return sumSize*1.0/this.fileSize;
		}

		class DownThread extends Thread{
			//当前线程下载的起始位置
			private int startPoints;
			//当前线程下载的内容大小
			private int partSize;
			//当前线程下载的文件块
			private RandomAccessFile access;
			//当前线程需要下载的字节数
			private int length;
			public DownThread(int startPoints,int partSize,RandomAccessFile access){
				this.startPoints = startPoints;
				this.partSize = partSize;
				this.access = access;
			}
			@Override
			public void run() {
				try {
					URL url = new URL(filePath);
					HttpURLConnection conn = (HttpURLConnection)url.openConnection();
					conn.setConnectTimeout(5*1000);
					conn.setRequestMethod("GET");
					String value = "image/gif,image/jpeg,image/png,image/pjpeg,*/*";
					conn.setRequestProperty("accpet", value);
					conn.setRequestProperty("Accpet-Language", "zh-CN");
					conn.setRequestProperty("charset", "UTF-8");
					//通过连接对象获取数据流
					InputStream stream = conn.getInputStream();
					//设置当前线程开始下载的内容位置
					stream.skip(startPoints);
					byte[] data = new byte[1024];
					//设置已经读了多少个字节
					int hasRead = 0;
					while(this.length<this.partSize && (hasRead=stream.read(data))!=-1){
						access.write(data, 0, hasRead);
						this.length = this.length + hasRead;
					}
					access.close();
					stream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

}
