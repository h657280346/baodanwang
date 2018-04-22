package Internet;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoadUtil {
	//����������Դ��·��
		private String filePath;
		//ָ�������ļ��ı���λ��
		private String targetFilePath;
		//������Ҫʹ�ö��ٸ��߳̽�������
		private int threadNum;
		//�������ص��̶߳���
		private DownThread[] threads;
		//���������ļ����ܴ�С
		private int fileSize;
		public DownLoadUtil(String filePath,String targetFilePath,int threadNum){
			this.filePath = filePath;
			this.targetFilePath = targetFilePath;
			this.threadNum = threadNum;
			threads = new DownThread[threadNum];
		}
		
		public void downLoads() throws Exception{
			//Ҫ�򿪵���Դλ�ã���Ҫ���ص��ļ�
			URL url = new URL(this.filePath);
			//�ҵ���Դ��ͨ����Դ��������ӣ�����URLConnection�����࣬��Ҫת��Ϊ��������
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//������뿪ʼ���н������ӣ��˴����ý�������������ʱ�䳬������ʱ�䣬�׳��쳣�����ٵȴ�
			conn.setConnectTimeout(5*1000);
			//���÷������󣨼�Ҫ�򿪵���Դ��ʱ������ʽ
			conn.setRequestMethod("GET");
			//����һ���������ԣ����ܹ����յ������ݸ�ʽ���ͣ���MIME(Multipurpose Internet Mail Extensions)����
			String value = "image/gif,image/jpeg,image/png,image/pjpeg,*/*";
			conn.setRequestProperty("accpet", value);
			//�������������н��ܵ��������ͣ�zh-CN����
			conn.setRequestProperty("Accpet-Language", "zh-CN");
			//�����������������ݴ���ʹ�õ��ַ�������
			conn.setRequestProperty("charset", "UTF-8");
			//��������������������Ҫһֱ���ֻ״̬
			conn.setRequestProperty("Connection", "keep-Alive");
			//�����ļ����ܴ�С
			this.fileSize = conn.getContentLength();
			//��֪�������������Ӷ���conn��ʱ���ڲ�������������
			conn.disconnect();
			//����ÿ���߳�ƽ�����ض�������
			int partSize = this.fileSize/this.threadNum;
			//���������ļ����û��������ػ�������������
			RandomAccessFile access = new RandomAccessFile(this.targetFilePath, "rw");
			//���ñ����ļ��Ĵ�С
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
			//��ǰ�߳����ص���ʼλ��
			private int startPoints;
			//��ǰ�߳����ص����ݴ�С
			private int partSize;
			//��ǰ�߳����ص��ļ���
			private RandomAccessFile access;
			//��ǰ�߳���Ҫ���ص��ֽ���
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
					//ͨ�����Ӷ����ȡ������
					InputStream stream = conn.getInputStream();
					//���õ�ǰ�߳̿�ʼ���ص�����λ��
					stream.skip(startPoints);
					byte[] data = new byte[1024];
					//�����Ѿ����˶��ٸ��ֽ�
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
