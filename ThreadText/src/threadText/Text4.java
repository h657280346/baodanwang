package threadText;

public class Text4 {
    static int j = 0;
	public static void main(String[] args){
		String [] s = new String [16];
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		/*ģ�⴦��16����־������Ĵ��������16����־���󣬵�ǰ������Ҫ����16����ܴ�ӡ����Щ��־��
		�޸ĳ�����룬���ĸ��߳�����16��������4���Ӵ��ꡣ
		*/
		for(int i=0;i<16;i++){  //���д��벻�ܸĶ�
			final String log = ""+(i+1);//���д��벻�ܸĶ�
			s[i] = log;
		}
			new Thread(new  Runnable() {
				public void run() {
					Text4.parseLog(s[0]);
					Text4.parseLog(s[1]);
					Text4.parseLog(s[2]);
					Text4.parseLog(s[3]);
				}
			}).start();

		new Thread(new  Runnable() {
			public void run() {
				Text4.parseLog(s[4]);
				Text4.parseLog(s[5]);
				Text4.parseLog(s[6]);
				Text4.parseLog(s[7]);
			}
		}).start();
		new Thread(new  Runnable() {
			public void run() {
				Text4.parseLog(s[8]);
				Text4.parseLog(s[9]);
				Text4.parseLog(s[10]);
				Text4.parseLog(s[11]);
			}
		}).start();
		new Thread(new  Runnable() {
			public void run() {
				Text4.parseLog(s[12]);
				Text4.parseLog(s[13]);
				Text4.parseLog(s[14]);
				Text4.parseLog(s[15]);
			}
		}).start();
	}
	
	//parseLog�����ڲ��Ĵ��벻�ܸĶ�
	public static void parseLog(String log){
		System.out.println(log+":"+(System.currentTimeMillis()/1000));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
}
